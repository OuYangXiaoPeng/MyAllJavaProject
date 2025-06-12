package classtest.Class.array;

import java.util.Random;
import java.util.Scanner;

public class array02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组长度:");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("请输入数组中的元素允许的最大值:");
        int max = sc.nextInt();
        Random rad = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = rad.nextInt(max);
        }

        System.out.println("请输出当前数组:");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        //假设第一个元素为当前最大元素
        int maxNum = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > maxNum) {
                maxNum = a[i];
            }
        }
        System.out.println("当前数组中的最大值为:" + maxNum);



    }
}
