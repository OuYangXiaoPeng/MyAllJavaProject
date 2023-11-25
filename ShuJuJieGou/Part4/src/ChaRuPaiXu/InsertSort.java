package ChaRuPaiXu;

import java.util.Random;

/**
 * 直接插入排序
 * 基本思想：将序列看做两部分（有序+无序），初始状态时，有序序列只有第一个元素
 * 依次将无序序列的元素插入到有序序列合适的位置，使得有序序列长度增加，无序序列长度
 * 缩短，直到有序序列长度为n，排序结束
 */
public class InsertSort {

    public static void insertSort(int[] r) {
        int i, j, temp;
        //循环插入n-1趟（令i从1~n-1依次取值，每趟r[i]插入到左边有序序列中）
        for (i = 1; i < r.length; i++) {
            //将r[i]插入到左边有序序列r[j]（j从i-1~0）的合适位置上
            temp = r[i];
            for (j = i - 1; j >= 0; j--) {
                if (temp < r[j]) {
                    r[j + 1] = r[j];
                } else
                    break;
            }
            r[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        //定义并初始化、显示数组
        int[] num = new int[10];
        for (int i = 0; i < num.length; i++) {
            num[i] = new Random().nextInt(100);
            System.out.print(num[i] + " ");
        }
        System.out.println();
        //调用排序算法
        insertSort(num);
        //显示排序后的数组
        System.out.println("排序后的数组:");
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }
}
