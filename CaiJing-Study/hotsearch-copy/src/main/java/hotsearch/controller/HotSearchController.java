package hotsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class HotSearchController {

    private static final String HOTWORDS_KEY = "hotwords";

    @Autowired
    private StringRedisTemplate redisTemplate;

    // 投票接口：http://localhost:8081/vote?keyword=redis
    @GetMapping("/vote")
    public void vote(@RequestParam String keyword) {
        System.out.println("收到投票：" + keyword);
        redisTemplate.opsForZSet().incrementScore(HOTWORDS_KEY, keyword, 1);
    }

    // 排行榜接口：http://localhost:8081/ranking
    @GetMapping("/ranking")
    public List<Map<String, Object>> getRanking() {
        Set<String> words = redisTemplate.opsForZSet().reverseRange(HOTWORDS_KEY, 0, -1);
        List<Map<String, Object>> result = new ArrayList<>();
        if (words != null) {
            for (String word : words) {
                Double score = redisTemplate.opsForZSet().score(HOTWORDS_KEY, word);
                Map<String, Object> item = new HashMap<>();
                item.put("keyword", word);
                item.put("score", score);
                result.add(item);
            }
        }
        return result;
    }

    // 删除热词
    @DeleteMapping("/delete")
    public String delete(@RequestParam String keyword) {
        Long result = redisTemplate.opsForZSet().remove(HOTWORDS_KEY, keyword);
        return result != null && result > 0 ? "删除成功" : "删除失败";
    }

    // 修改热词
    @PostMapping("/edit")
    public String edit(@RequestParam String old,
                       @RequestParam Double score) {

        if (old == null || old.isBlank()) {
            return "关键词不能为空";
        }

        if (score == null || score < 0) {
            return "热度值必须是非负数";
        }

        Double originalScore = redisTemplate.opsForZSet().score(HOTWORDS_KEY, old);
        if (originalScore == null) {
            return "关键词不存在";
        }

        // 只修改热度，不改关键词
        redisTemplate.opsForZSet().add(HOTWORDS_KEY, old, score);
        return "热度修改成功";
    }



}
