package 数学类;

import java.util.Scanner;

public class CTest {
    public static void main(String[] args) {
        C z1 = new C(7,5);
        C z2 = new C(2,3);
        z1.show();
        System.out.println();
        z2.show();
        Scanner sc = new Scanner(System.in);
        String select;
        System.out.println("退出输入’n‘");
        while (true) {
            System.out.println("选择要进行的运算(+,-,*,/,^,^2,^3)");
            select = sc.next();
            if (select.equals("n")) {
                break;
            }
            if (select.equals("+")) {
                C z3 = z1.add(z2);
                System.out.println("复数相加");
                z3.show();
            }
            if (select.equals("-")) {
                C z3 = z1.subtract(z2);
                System.out.println("复数相减");
                z3.show();
            }
            if (select.equals("*")) {
                C z3 = z1.multiply(z2);
                System.out.println("复数相乘");
                z3.show();
            }
            if (select.equals("/")) {
                C z3 = z1.divide(z2);
                System.out.println("复数相除");
                z3.show2();
            }
            if (select.equals("^")) {
                System.out.println("普通方法");
                System.out.println("输入多少次方:");
                int n = sc.nextInt();
                C z3 = z1.pow(n);
                System.out.println("复数的"+n+"次方");
                z3.show();
            }
            if (select.equals("^2")) {
                System.out.println("二项定理");
                System.out.println("输入多少次方:");
                int n = sc.nextInt();
                C z3 = z1.pow2(n);
                System.out.println("复数的"+n+"次方");
                z3.show();
            }
            if (select.equals("^3")) {
                System.out.println("快速冥");
                System.out.println("输入多少次方:");
                int n = sc.nextInt();
                C z3 = z1.pow3(n);
                System.out.println("复数的"+n+"次方");
                z3.show();
            }
        }
    }
}
