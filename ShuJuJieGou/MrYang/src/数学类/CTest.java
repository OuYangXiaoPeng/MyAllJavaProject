package ��ѧ��;

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
        System.out.println("�˳����롯n��");
        while (true) {
            System.out.println("ѡ��Ҫ���е�����(+,-,*,/,^,^2,^3)");
            select = sc.next();
            if (select.equals("n")) {
                break;
            }
            if (select.equals("+")) {
                C z3 = z1.add(z2);
                System.out.println("�������");
                z3.show();
            }
            if (select.equals("-")) {
                C z3 = z1.subtract(z2);
                System.out.println("�������");
                z3.show();
            }
            if (select.equals("*")) {
                C z3 = z1.multiply(z2);
                System.out.println("�������");
                z3.show();
            }
            if (select.equals("/")) {
                C z3 = z1.divide(z2);
                System.out.println("�������");
                z3.show2();
            }
            if (select.equals("^")) {
                System.out.println("��ͨ����");
                System.out.println("������ٴη�:");
                int n = sc.nextInt();
                C z3 = z1.pow(n);
                System.out.println("������"+n+"�η�");
                z3.show();
            }
            if (select.equals("^2")) {
                System.out.println("�����");
                System.out.println("������ٴη�:");
                int n = sc.nextInt();
                C z3 = z1.pow2(n);
                System.out.println("������"+n+"�η�");
                z3.show();
            }
            if (select.equals("^3")) {
                System.out.println("����ڤ");
                System.out.println("������ٴη�:");
                int n = sc.nextInt();
                C z3 = z1.pow3(n);
                System.out.println("������"+n+"�η�");
                z3.show();
            }
        }
    }
}
