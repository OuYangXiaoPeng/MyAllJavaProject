package craft;

import java.util.Random;
import java.util.Scanner;

public class 拿牌游戏 {
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
                System.out.print("输入你的数字:");
                me = s.nextInt();
                while (total - me < 0 || me < 1 || me > k) {
                    System.out.print("请重新输入：");
                    me = s.nextInt();
                }
                System.out.println("你输入的是:" + me + ",还剩:" + (total -= me));
                System.out.println();
                if (total <= 0) {
                    System.out.println("你拿到了最后一个数字，你输了！");
                    break;
                }
                ai = AI(total, k);
                System.out.println("电脑输入的是:" + ai + ",还剩:" + (total -= ai));
                if (total <= 0) {
                    System.out.println("电脑拿到了最后一个数字，电脑输了！");
                    break;
                }
            } else if (PD == 2) {
                ai = AI(total, k);
                System.out.println("电脑输入的是:" + ai + ",还剩:" + (total -= ai));
                if (total <= 0) {
                    System.out.println("电脑拿到了最后一个数字，电脑输了！");
                    break;
                }
                System.out.print("输入你的数字:");
                me = s.nextInt();
                while (total - me < 0 || me < 1 || me > k) {
                    System.out.print("请重新输入：");
                    me = s.nextInt();
                }
                System.out.println("你输入的是:" + me + ",还剩:" + (total -= me));
                System.out.println();
                if (total <= 0) {
                    System.out.println("你拿到了最后一个数字，你输了！");
                    break;
                }
            } else {
                System.out.print("请重新输入：");
                PD = s.nextInt();
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int total = 10;
        int k = 7;
        System.out.println("拿牌游戏");
        System.out.println("总数" + total + "张牌，输入1~" + k + "其中一个\n拿到最后一张牌为输");
        System.out.println("是否先手？(1.先手 2.后手)");
        int PD = s.nextInt();
        pai(total, k, PD);
    }
}
