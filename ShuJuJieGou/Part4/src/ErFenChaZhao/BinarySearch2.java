package ErFenChaZhao;

import ChaRuPaiXu.InsertSort2;

import java.util.Random;
import java.util.Scanner;

public class BinarySearch2 {

    public static int get(int a[], int begin, int end, int k) {
        if (begin > end) {
            return -1;
        }
        int mid = begin + (end - begin) / 2;
        if (a[mid] < k) {
            return get(a, mid + 1, end, k);
        } else if (a[mid] > k) {
            return get(a, begin, mid - 1, k);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        InsertSort2 is = new InsertSort2();

        //���岢��ʼ������ʾ����
        int[] num = new int[10];
        for (int i = 0; i < num.length; i++) {
            num[i] = new Random().nextInt(100);
            System.out.print(num[i] + " ");
        }
        System.out.println();
        is.insertSort(num);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
        System.out.println("����Ҫ���ҵĹؼ���:");
        int k = new Scanner(System.in).nextInt();

        int result = get(num, 0, num.length, k);
        //��ʾ���Һ�Ľ��
        System.out.println("���ҵĽ��Ϊ:" + result);
    }

}
