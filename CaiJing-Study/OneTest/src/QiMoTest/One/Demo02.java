package QiMoTest.One;

import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入总钱数 n 和总鸡数 m
        System.out.print("请输入总钱数 n：");
        int n = scanner.nextInt();
        System.out.print("请输入总鸡数 m：");
        int m = scanner.nextInt();

        // 统计满足条件的方案数
        int count = 0;

        // 遍历公鸡数量 x，母鸡数量 y，小鸡数量 z
        for (int x = 0; x <= m; x++) { // 公鸡数量
            for (int y = 0; y <= m - x; y++) { // 母鸡数量
                int z = m - x - y; // 小鸡数量自动计算

                // 检查是否满足钱数条件
                if (5 * x + 3 * y + z / 3.0 == n) {
                    count++;
                    System.out.println("方案：" + "公鸡：" + x + " 母鸡：" + y + " 小鸡：" + z);
                }
            }
        }

        // 输出结果
        if (count == 0) {
            System.out.println("该问题无解！");
        } else {
            System.out.println("共有 " + count + " 种方案满足要求。");
        }

        scanner.close();
    }
}