package ��ѧ��;

import java.util.Scanner;


public class MTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row, col;
        int p = 1;
        String select;
        row = 2;
        col = 2;
        long[][] m = new long[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                m[i][j] = p;
                p += 1;
            }
        }
        M M1 = new M(m);
        M1.show();
        System.out.println();
        row = 2;
        col = 2;
        p = 1;
        m = new long[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                m[i][j] = p;
                p += 1;
            }
        }
        M M2 = new M(m);
        M2 = M2.transpose();
        M2.show();
        System.out.println("�˳�����'n'");
        while (true) {
            System.out.println("ѡ��Ҫ���е�����(+,-,*,*2,/,^,$)");
            select = sc.next();
            if (select.equals("n")) {
                break;
            }
            if (select.equals("+")) {
                if (M1.row != M2.row || M1.col != M2.col) {
                    System.out.println("����!�����Ͼ������㷨��!");
                } else {
                    M M3 = M1.add(M2);
                    System.out.println("�������");
                    M3.show();
                }
            }
            if (select.equals("-")) {
                if (M1.row != M2.row || M1.col != M2.col) {
                    System.out.println("����!�����Ͼ������㷨��!");
                } else {
                    M M3 = M1.subtract(M2);
                    System.out.println("�������");
                    M3.show();
                }
            }
            if (select.equals("*")) {
                if (M1.col != M2.row) {
                    System.out.println("����!�����Ͼ������㷨��!");
                } else {
                    M M3 = M1.multiply(M2);
                    System.out.println("�������");
                    M3.show();
                }
            }
            if (select.equals("*2")) {
                if (M1.col != M2.row) {
                    System.out.println("����!�����Ͼ������㷨��!");
                } else {
                    M M3 = M1.multiply2(M2);
                    System.out.println("�������");
                    M3.show();
                }
            }
            if (select.equals("^")) {
                if (M1.col != M1.row) {
                    System.out.println("����!�����Ͼ������㷨��!");
                } else {
                    System.out.println("������ٴη�:");
                    int n = sc.nextInt();
                    M M3 = M1.pow(n);
                    System.out.println("�����" + n + "�η�");
                    M3.show();
                }
            }
            if (select.equals("$")) {
                M M3 = M1.transpose();
                System.out.println("����ת��");
                M3.show();
            }
        }
    }
}
