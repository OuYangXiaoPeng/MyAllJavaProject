package ShunXuBiao;

/*
【例2】编程实现查找线性表（0，1，2，…，n-1）中第
i（1≤i≤n）个数据元素的直接前驱，
并输出其值。要求在顺序表上实现。

 */

import java.util.Scanner;

public class Exp02 {

    public static void main(String[] args) throws Exception {

        SqList slist1 = new SqList(20);
        for (int i = 0; i < 10; i++) {
            slist1.insert(i, i);
        }
        System.out.println("请输入i的值：");
        int i = new Scanner(System.in).nextInt();
        if (i > 0 && i <= 10) {
            System.out.println("第" + i + "个元素的直接前驱是： " + slist1.get(i - 1));
        } else {
            System.out.println("第" + i + "个元素的直接前驱不存在！");
        }
    }

}
