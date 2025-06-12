package ClassPractice.One;

import java.util.Scanner;

public class JieCheng {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数:");
        int n = sc.nextInt();
        int total = 1;
        //阶乘
        for (int i = n; i > 0; i--) {
            total *= i;
        }
        System.out.println(n + "!=" + total);
    }
}
