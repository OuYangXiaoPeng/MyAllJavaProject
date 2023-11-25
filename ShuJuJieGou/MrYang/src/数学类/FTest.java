package 数学类;

import java.util.Scanner;

public class FTest {
    public static void main(String[] args) {
        F f1 = new F(7, 13);
        F f2 = new F(11, -13);
        System.out.println(f1);
        System.out.println();
        System.out.println(f2);
        Scanner sc = new Scanner(System.in);
        String select;
        System.out.println("退出输入’n‘");
        while (true) {
            System.out.println("选择要进行的运算(+,-,*,/,^)");
            select = sc.next();
            if (select.equals("n")) {
                break;
            }
            if (select.equals("+")) {
                F f3 = f1.add(f2);
                System.out.println("分数相加");
                System.out.println(f3);
            }
            if (select.equals("-")) {
                F f3 = f1.sub(f2);
                System.out.println("分数相减");
                System.out.println(f3);
            }
            if (select.equals("*")) {
                F f3 = f1.multiply(f2);
                System.out.println("分数相乘");
                System.out.println(f3);
            }
            if (select.equals("/")) {
                F f3 = f1.devide(f2);
                System.out.println("分数相除");
                System.out.println(f3);
            }
            if (select.equals("^")) {
                System.out.println("快速冥");
                System.out.println("输入多少次方:");
                int n = sc.nextInt();
                F f3 = f1.pow(n);
                System.out.println("分数的"+n+"次方");
                System.out.println(f3);
            }
        }
    }
}
