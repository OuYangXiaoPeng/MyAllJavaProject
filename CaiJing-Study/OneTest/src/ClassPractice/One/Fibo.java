package ClassPractice.One;

import java.util.Scanner;

public class Fibo {
    public static int fibo(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入月份(1-36):");
        int n = sc.nextInt();
        while (true) {
            if (n >= 1 && n <= 36) {
                int sum = fibo(n);
                System.out.println("当前月份的兔子数量为:" + sum);
                break;
            } else {
                System.out.println("您输入的不符合要求");
            }
        }

    }
}
