package ShunXuChaZhao;

import java.util.Random;
import java.util.Scanner;

/**
 * 顺序查找--将待查找关键字k与查找表(数组)的元素顺序的比较
 */
public class SqSearch {
    //找到了则返回一个>=0的位置，否则返回-1
    public static int sqSearch(int[] r, int k) {
        int i = 0;  //查找表元素的下标，从r[0]
        while (i < r.length && r[i] != k) {
            i++;
        }
        if (i < r.length)
            return i;   //找到了而退出
        else
            return -1; //因下标越界而退出，没找到
    }

    public static void main(String[] args) {
        //定义并初始化、显示数组
        int[] num = new int[10];
        for (int i = 0; i < num.length; i++) {
            num[i] = new Random().nextInt(100);
            System.out.print(num[i] + " ");
        }
        System.out.println();
        //调用查找算法
        System.out.println("输入要查找的关键字:");
        int k = new Scanner(System.in).nextInt();
        int result = sqSearch(num, k);
        //显示差找后的结果
        System.out.println("查找的结果为:"+result);
    }
}
