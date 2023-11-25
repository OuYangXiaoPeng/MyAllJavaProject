package ErFenChaZhao;

import java.util.Random;
import java.util.Scanner;

/**
 * 二分查找
 */
public class BinarySearch {

    public static int binarySearch(int[] r, int key) {
        //定义初始化下界、上界和中位
        int low = 0, high = r.length - 1, mid;
        //只有查找的范围存在(下界<=上界)，则循环
        System.out.println("初始下界：" + low + "，初始上界：" + high + "，初始中值：" + (low + high) / 2);
        while (low <= high) {
            //计算中位
            mid = (low + high) / 2;
            System.out.println("中间值为:" + mid);
            //比较key和中位值r[mid]的大小
            if (key == r[mid]) {
                return mid;//找到了，返回mid(查找成功)
            } else if (key > r[mid]) {
                low = mid + 1;//下次在又右半段查找，修改下界，上界不变
                System.out.println("新下界为:" + low + "，上界:" + high + "不变");
            } else if (key < r[mid]) {
                high = mid - 1;//下次在又左半段查找，修改上界，下界不变
                System.out.println("下界:" + low + "不变，"+"新上界为:" + high);
            }
        }
        return -1;//查找范围不存在了，查找失败
    }

    public static void bubbleSort(int[] r) {
        for (int i = 0; i < r.length - 1; i++) {
            for (int j = 0; j < r.length - 1; j++) {
                if (r[j] > r[j + 1]) {
                    int temp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = temp;
                }
            }
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
        //对数组排序，然后显示排序后的数组
        bubbleSort(num);
        for (int j : num) {
            System.out.print(j + " ");
        }
        System.out.println();
        //提示用户输入查找的关键字
        System.out.println("输入要查找的关键字:");
        int k = new Scanner(System.in).nextInt();
        //调用二分查找
        int result = binarySearch(num, k);
        //显示查找后的结果
        System.out.println("查找的结果为:" + result);
    }

}
