package QiMoTest.One;

import java.util.Random;
import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入数组长度n：");
        int n = scanner.nextInt();

        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println("生成的数组为：");
        for (int num : array) {
            System.out.println(num);
        }

        // 冒泡排序
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        System.out.println("排序后的数组为：");
        for (int num : array) {
            System.out.println(num);
        }
        System.out.println("数组中的最大值为：" + array[array.length - 1]);
    }
}
