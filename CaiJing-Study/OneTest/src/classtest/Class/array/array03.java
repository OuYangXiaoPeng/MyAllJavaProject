package classtest.Class.array;

import java.util.Arrays;

public class array03 {
    public static void main(String[] args) {
        //数组复制的基本操作
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[5];
        System.arraycopy(a, 2, b, 0, 3);
        System.out.print("b[i]:");
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
        //array操作方法
        //System.arraycopy(a,2,b,0,3);
        /*
        a数组源名称
        2源数组开始位置
        b目标数组名称
        0目标数组开始位置
        3复制长度
         */
        int [] c = Arrays.copyOf(a,8);
//        int[] c = Arrays.copyOf(b, 8);
        System.out.print("c[i]:");
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }

    }
}
