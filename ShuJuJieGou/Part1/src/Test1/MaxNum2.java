package Test1;

import java.util.Scanner;

public class MaxNum2 {

    public static void main(String[] args) {
        int[] num = new int[5];
        Scanner s = new Scanner(System.in);
        System.out.println("请输入5个数进行比大小");
        for (int i = 0; i < num.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个数");
            num[i] = s.nextInt();
        }
        int maxNum = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] > maxNum) {
                maxNum = num[i];//s

            }
        }
        System.out.println("这5个数中最大的数是:" + maxNum);
    }
}
