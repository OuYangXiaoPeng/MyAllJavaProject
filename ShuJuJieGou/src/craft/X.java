package craft;

import java.util.Random;
import java.util.Scanner;

public class X {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int total = 49;
        int k = 7;
        int me = 0, ai;
        System.out.println("������Ϸ");
        System.out.println("����" + total + "���ƣ�����1~" + k + "����һ��\n�õ����һ����Ϊ��");
        System.out.println("�Ƿ����֣�(1.���� 2.����)");
        int PD = s.nextInt();
        while (true) {
            if (PD == 1) {
                ai = r.nextInt(k) + 1;
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
                for (int i = total; i > 0; i--) {
                    if (total % ((k + 1) * i + 1) == 0) {
                        System.out.println("�����������:" + ai + ",��ʣ:" + (total -= ai));
                        break;
                    }
                    if (total % ((k + 1) * i + 1) != 0) {
                        if (total > (k + 1)) {
                            if (total - (k + 1) * i - 1 >= 0) {
                                System.out.println("�����������:" + (total - (k + 1) * i - 1) + ",��ʣ:" + (total = (k + 1) * i + 1));
                                break;
                            }
                        }
                        if (total <= (k + 1)) {
                            if (total - (k + 1) + me > 0) {
                                System.out.println("�����������:" + ((k + 1) - me) + ",��ʣ:" + (total = total - (k + 1) + me));
                                break;
                            } else {
                                System.out.println("�����������:1,��ʣ:0");
                                total = 0;
                                break;
                            }
                        }
                    }
                }
                if (total <= 0) {
                    System.out.println("�����õ������һ�����֣��������ˣ�");
                    break;
                }
            } else if (PD == 2) {
                ai = r.nextInt(k) + 1;
                for (int i = total; i > 0; i--) {
                    if (total % ((k + 1) * i + 1) == 0) {
                        System.out.println("�����������:" + ai + ",��ʣ:" + (total -= ai));
                        break;
                    }
                    if (total % ((k + 1) * i + 1) != 0) {
                        if (total > (k + 1)) {
                            if (total - (k + 1) * i - 1 >= 0) {
                                System.out.println("�����������:" + (total - (k + 1) * i - 1) + ",��ʣ:" + (total = (k + 1) * i + 1));
                                break;
                            }
                        }
                        if (total <= (k + 1)) {
                            if (total - (k + 1) + me > 0) {
                                System.out.println("�����������:" + ((k + 1) - me) + ",��ʣ:" + (total = total - (k + 1) + me));
                                break;
                            } else {
                                System.out.println("�����������:1,��ʣ:0");
                                total = 0;
                                break;
                            }
                        }
                    }
                }
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
}
