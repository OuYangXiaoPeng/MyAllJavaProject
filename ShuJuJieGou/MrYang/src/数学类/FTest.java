package ��ѧ��;

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
        System.out.println("�˳����롯n��");
        while (true) {
            System.out.println("ѡ��Ҫ���е�����(+,-,*,/,^)");
            select = sc.next();
            if (select.equals("n")) {
                break;
            }
            if (select.equals("+")) {
                F f3 = f1.add(f2);
                System.out.println("�������");
                System.out.println(f3);
            }
            if (select.equals("-")) {
                F f3 = f1.sub(f2);
                System.out.println("�������");
                System.out.println(f3);
            }
            if (select.equals("*")) {
                F f3 = f1.multiply(f2);
                System.out.println("�������");
                System.out.println(f3);
            }
            if (select.equals("/")) {
                F f3 = f1.devide(f2);
                System.out.println("�������");
                System.out.println(f3);
            }
            if (select.equals("^")) {
                System.out.println("����ڤ");
                System.out.println("������ٴη�:");
                int n = sc.nextInt();
                F f3 = f1.pow(n);
                System.out.println("������"+n+"�η�");
                System.out.println(f3);
            }
        }
    }
}
