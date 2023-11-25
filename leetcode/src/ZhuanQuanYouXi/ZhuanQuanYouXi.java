package ZhuanQuanYouXi;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class ZhuanQuanYouXi {

    public int[] circularGameLosers(int n, int k) {

        // 创建一个数组来存储每个朋友是否接过球的状态
        boolean[] received = new boolean[n];
        // 创建一个变量来记录当前持球的朋友的编号
        int current = 1;
        // 创建一个变量来记录当前的轮数
        int round = 1;
        // 创建一个循环来模拟游戏的过程
        while (true) {
            // 检查当前持球的朋友是否已经接过球
            if (received[current - 1]) {
                // 如果是，跳出循环，游戏结束
                break;
            }
            // 把当前持球的朋友的状态设为 true
            received[current - 1] = true;
            // 计算下一次传球的目标朋友的编号
            int next = (current + round * k - 1) % n + 1;
            // 更新当前持球的朋友的编号
            current = next;
            // 更新当前的轮数
            round++;
        }
        // 创建一个列表来存储输家的编号
        List<Integer> losers = new ArrayList<>();
        // 遍历数组，找出所有状态为 false 的朋友
        for (int i = 0; i < n; i++) {
            if (!received[i]) {
                // 把他们的编号放入列表中
                losers.add(i + 1);
            }
        }
        // 按升序排列列表
        Collections.sort(losers);
        // 把列表转换为一个 int 数组并返回
        int[] answer = new int[losers.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = losers.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 2;

        ZhuanQuanYouXi solution = new ZhuanQuanYouXi();
        int[] answer = solution.circularGameLosers(n, k);

        for (int num : answer) {
            System.out.print(num + " ");
        }
    }
}
