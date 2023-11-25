package craft;

import java.util.Random;
import java.util.Scanner;

public class ������Ϸ {
    public static int AI(int total, int k) {
        if (total <= 1) {
            return 1;
        }
        Random r = new Random();
        int ai;
        if (total > k) {
            ai = r.nextInt(k) + 1;
        } else {
            ai = r.nextInt(total) + 1;
        }
        int flag = (total - 1) % (k + 1);
        if (flag == 0) {
            if ((total - 1) < (k + 1)) {
                return total - 1;
            } else {
                return ai;
            }
        } else {
            return flag;
        }
    }

    public static void pai(int total, int k, int PD) {
        int me = 0, ai;
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        while (true) {
            if (PD == 1) {
                System.out.print("�����������:");
                me = s.nextInt();
                while (total - me < 0 || me < 1 || me > k) {
                    System.out.print("���������룺");
                    me = s.nextInt();
                }
                System.out.println("���������:" + me + ",��ʣ:" + (total -= me));
                System.out.println();
                if (total <= 0) {
                    System.out.println("���õ������һ�����֣������ˣ�");
                    break;
                }
                ai = AI(total, k);
                System.out.println("�����������:" + ai + ",��ʣ:" + (total -= ai));
                if (total <= 0) {
                    System.out.println("�����õ������һ�����֣��������ˣ�");
                    break;
                }
            } else if (PD == 2) {
                ai = AI(total, k);
                System.out.println("�����������:" + ai + ",��ʣ:" + (total -= ai));
                if (total <= 0) {
                    System.out.println("�����õ������һ�����֣��������ˣ�");
                    break;
                }
                System.out.print("�����������:");
                me = s.nextInt();
                while (total - me < 0 || me < 1 || me > k) {
                    System.out.print("���������룺");
                    me = s.nextInt();
                }
                System.out.println("���������:" + me + ",��ʣ:" + (total -= me));
                System.out.println();
                if (total <= 0) {
                    System.out.println("���õ������һ�����֣������ˣ�");
                    break;
                }
            } else {
                System.out.print("���������룺");
                PD = s.nextInt();
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int total = 10;
        int k = 7;
        System.out.println("������Ϸ");
        System.out.println("����" + total + "���ƣ�����1~" + k + "����һ��\n�õ����һ����Ϊ��");
        System.out.println("�Ƿ����֣�(1.���� 2.����)");
        int PD = s.nextInt();
        pai(total, k, PD);
    }
}
