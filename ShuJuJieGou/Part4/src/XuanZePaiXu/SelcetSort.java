package XuanZePaiXu;

import java.util.Random;

/**
 * 选择排序
 * 基本思想：
 * 选择n-1趟，
 */
public class SelcetSort {

    public static void selcectSort(int[] r) {
        int i, j, min, temp;
        //循环n-1次（选择n-1趟）令i从0到i-2依次取值
        for (i = 0; i < r.length - 1; i++) {
            //从未排序元素r[i~n-1]中选出最小值r[min]
            min = i;
            for (j = i + 1; j < r.length; j++) {
                if (r[j] < r[min]) {
                    min = j;
                }
            }
            //若min不等于i，则交换r[min]到r[i]
            if (min != i) {
                temp = r[i];
                r[i] = r[min];
                r[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        //定义并初始化、显示数组
        int [] num = new int[10];
        for (int i = 0; i < num.length; i++) {
            num[i] = new Random().nextInt(100);
            System.out.print(num[i]+" ");
        }
        System.out.println();
        //调用排序算法
        selcectSort(num);
        //显示排序后的数组
        System.out.println("排序后的数组:");
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]+" ");
        }
    }
}
