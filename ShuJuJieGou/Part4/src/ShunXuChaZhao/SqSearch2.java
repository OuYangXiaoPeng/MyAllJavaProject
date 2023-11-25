package ShunXuChaZhao;

import java.util.Random;
import java.util.Scanner;

/**
 * 顺序查找--将待查找关键字k与查找表(数组)的元素顺序的比较
 * 改进形式，带哨兵的顺序查找
 * 基本思想：减少每次循环的比较次数（只跟关键字比较）
 * 少用一个表单元，将最后一个表单元存储”哨兵“
 * 在比较成功之后，根据元素的下标位置是否是哨兵的位置，来判断成功与否
 */
public class SqSearch2 {
    //找到了则返回一个>=0的位置，否则返回-1
    public static int sqSearch(int[] r, int k) {
        int i = 0;  //查找表元素的下标，从r[0]
        while (r[i] != k) {
            i++;
        }
        if (i < r.length - 1)
            return i;   //在哨兵的前面位置找到而退出，查找成功
        else
            return -1; //在哨兵的位置找到而退出，查找失败
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

        //设置哨兵
        num[9] = k;

        int result = sqSearch(num, k);
        //显示差找后的结果
        System.out.println("查找的结果为:" + result);
    }
}
