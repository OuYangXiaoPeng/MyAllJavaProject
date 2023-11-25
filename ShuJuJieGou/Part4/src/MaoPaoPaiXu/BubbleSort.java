package MaoPaoPaiXu;

import java.util.Random;

public class BubbleSort {

    public static void bubbleSort(int[] r) {
        //循环（冒泡）n-1
        for (int i = 0; i < r.length - 1; i++) {
            //	一趟冒泡操作：从左到右进行n-1次两两比较
            //令每次比较的左边元素下标为j（0~n-2）
            for (int j = 0; j < r.length -i -1; j++) {
                if (r[j] > r[j + 1]) {
                    int temp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        //创建数组，随机数初始化，并显示排序前的数组
        int[] num = new int[10];
        for (int i = 0; i < num.length; i++) {
            num[i] = new Random().nextInt(100);
            System.out.print(num[i] + " ");
        }
        System.out.println();
        //调用排序算法
        bubbleSort(num);
        //显示排序后的数组
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }
}
