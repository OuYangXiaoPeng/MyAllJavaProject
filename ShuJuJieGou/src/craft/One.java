package craft;

import java.util.Random;
import java.util.Scanner;

public class One {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int total = 50;
        int me = 0, ai = 0;
        System.out.println("总数"+total+"，输入1~4其中一个\n拿到最后一张牌为输");
        System.out.println("是否先手？(1.先手 2.后手)");
        int PD = s.nextInt();
        while (total > 0) {
            if (PD == 1) {
                ai = r.nextInt(4) + 1;
                System.out.print("输入你的数字:");
                me = s.nextInt();
                System.out.println("你输入的是:" + me + ",还剩:" + (total -= me));
                System.out.println();
                if (total <= 0) {
                    System.out.println("你拿到了最后一个数字，你输了！");
                    break;
                }
                for (int i = total; i > 0; i--) {
                    if (total % (5 * i + 1) == 0) {
                        System.out.println("电脑输入的是:" + ai + ",还剩:" + (total -= ai) );
                        break;
                    }
                    if (total % (5 * i + 1) != 0) {
                        if (total > 6) {
                            if (total - 5 * i - 1 >= 0) {
                                System.out.println("电脑输入的是:" + (total - 5 * i - 1) + ",还剩:" + (total = 5 * i + 1) );
                                break;
                            }
                        }
                        if (total <= 6) {
                            if (total-5+me>0) {
                                System.out.println("电脑输入的是:" + (5 - me) + ",还剩:" + (total = total-5+me));
                                break;
                            } else {
                                System.out.println("电脑输入的是:1,还剩:0" );
                                total = 0;
                                break;
                            }
                        }
                    }
                }

                if (total <= 0) {
                    System.out.println("电脑拿到了最后一个数字，电脑输了！");
                    break;
                }
            }
            if (PD == 2) {
                ai = r.nextInt(4) + 1;
                for (int i = total; i > 0; i--) {
                    if (total % (5 * i + 1) == 0) {
                        System.out.println("电脑输入的是:" + ai + ",还剩:" + (total -= ai));
                        break;
                    }
                    if (total % (5 * i + 1) != 0) {
                        if (total > 6) {
                            if (total - 5 * i - 1 >= 0) {
                                System.out.println("电脑输入的是:" + (total - 5 * i - 1) + ",还剩:" + (total = 5 * i + 1));
                                break;
                            }
                        }
                        if (total <= 6) {
                            if (total-5+me>0) {
                                System.out.println("电脑输入的是:" + (5 - me) + ",还剩:" + (total = total-5+me));
                                break;
                            } else {
                                System.out.println("电脑输入的是:1,还剩:0" );
                                total = 0;
                                break;
                            }
                        }
                    }
                }
                if (total <= 0) {
                    System.out.println("电脑拿到了最后一个数字，电脑输了！");
                    break;
                }
                System.out.print("输入你的数字:");
                me = s.nextInt();
                System.out.println("你输入的是:" + me + ",还剩:" + (total -= me));
                System.out.println();
                if (total <= 0) {
                    System.out.println("你拿到了最后一个数字，你输了！");
                    break;
                }
            }
        }
    }
}
