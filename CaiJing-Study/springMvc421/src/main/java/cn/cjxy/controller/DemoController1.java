package cn.cjxy.controller;

import cn.cjxy.domain.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Controller
@RequestMapping("/demo1")
public class DemoController1 {

    @RequestMapping("/test1")
    public void test1(@RequestBody String name, HttpServletResponse response) throws Exception {
        System.out.println(name);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(name);
    }

    /**
     * json支持
     *
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping("/test2")
    @ResponseBody
    public User test2(@RequestBody User user) throws Exception {
        System.out.println(user);
        return user;
    }

    @RequestMapping("/test3")
    @ResponseBody
    public User test3(User user) throws Exception {
        System.out.println(user);
        return user;
    }

    @RequestMapping("/test4")
    @ResponseBody
    public String demo04(HttpEntity<String> entity) throws Exception {
        // 获取请求头
        HttpHeaders headers = entity.getHeaders();
        System.out.println(headers);
        // 获取请求体
        String rb = entity.getBody();
        System.out.println(rb);
        return rb;
    }

    /**
     * 文件上传
     *
     * @throws Exception
     * @RequestPart 当表单名称和形参不一样时，可以使用@RequestPart来指定
     */
    @RequestMapping("/upload_single")
    public void uploadSingle(@RequestPart("singlefile") MultipartFile file, HttpServletResponse response) throws Exception {
        //表单想的名称
        String name = file.getName();
        //文件名称
        String filename = file.getOriginalFilename();
        //大小
        long size = file.getSize();
        //文件类型
        String contentType = file.getContentType();

        //将前段传递的写入磁盘
        file.transferTo(new File("D:\\IdeaProject\\CaiJing-Study\\springMvc421\\upload\\" + filename));
        //输出到网页上
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<hr/>name:   " + name);
        response.getWriter().write("<hr/>filename:   " + filename);
        response.getWriter().write("<hr/>size:   " + size);
        response.getWriter().write("<hr/>contentType:   " + contentType);
    }

    @RequestMapping("/upload_many")
    public void uploadMany(MultipartFile[] manyfile, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("正在上传。。。");
        for (MultipartFile file : manyfile) {
//            上传
            file.transferTo(new File("D:\\IdeaProject\\CaiJing-Study\\springMvc421\\upload\\" + file.getOriginalFilename()));
        }
        response.getWriter().write("上传成功！");
    }
}
