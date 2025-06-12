package QiMoTest.Two;

import java.util.Random;
import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个整数（5≤n≤10）：");
        int n = scanner.nextInt();

        if (n < 5 || n > 10) {
            System.out.println("输入有误，结束程序。");
        }

        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println("排序前的数组：");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();


//        排序
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println("排序后的数组：");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}