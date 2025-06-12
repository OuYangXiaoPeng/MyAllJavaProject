package Work.OneWork;

import java.util.Scanner;

public class FeiBoLaQie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int num1 = 1, num2 = 1;// 前两个数字
            System.out.println("斐波拉切数列\n" +
                    "请输入要查看第几个数中的值(0退出)：");
            int n = sc.nextInt();
            if (n == 0)
                break;
            for (int i = 2; i < n; i++) {
                num1 = num1 + num2;// 后一个数字是前两个数字之和
                // 交换num1和num2的值
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }
            System.out.println("第" + n + "个数为" + num2);
        }

    }
}
