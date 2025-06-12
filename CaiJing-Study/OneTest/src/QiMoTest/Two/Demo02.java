package QiMoTest.Two;

import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个大于1的自然数：");
        int n = scanner.nextInt();

        if (n <= 1) {
            System.out.println("输入不合法，程序结束。");
        }

        if (isPrime(n)) {
            System.out.println(n + " 是质数");
        } else {
            System.out.println(n + " 不是质数");
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
