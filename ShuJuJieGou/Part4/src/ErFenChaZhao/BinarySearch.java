package ErFenChaZhao;

import java.util.Random;
import java.util.Scanner;

/**
 * ���ֲ���
 */
public class BinarySearch {

    public static int binarySearch(int[] r, int key) {
        //�����ʼ���½硢�Ͻ����λ
        int low = 0, high = r.length - 1, mid;
        //ֻ�в��ҵķ�Χ����(�½�<=�Ͻ�)����ѭ��
        System.out.println("��ʼ�½磺" + low + "����ʼ�Ͻ磺" + high + "����ʼ��ֵ��" + (low + high) / 2);
        while (low <= high) {
            //������λ
            mid = (low + high) / 2;
            System.out.println("�м�ֵΪ:" + mid);
            //�Ƚ�key����λֵr[mid]�Ĵ�С
            if (key == r[mid]) {
                return mid;//�ҵ��ˣ�����mid(���ҳɹ�)
            } else if (key > r[mid]) {
                low = mid + 1;//�´������Ұ�β��ң��޸��½磬�Ͻ粻��
                System.out.println("���½�Ϊ:" + low + "���Ͻ�:" + high + "����");
            } else if (key < r[mid]) {
                high = mid - 1;//�´��������β��ң��޸��Ͻ磬�½粻��
                System.out.println("�½�:" + low + "���䣬"+"���Ͻ�Ϊ:" + high);
            }
        }
        return -1;//���ҷ�Χ�������ˣ�����ʧ��
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
        //���岢��ʼ������ʾ����
        int[] num = new int[10];
        for (int i = 0; i < num.length; i++) {
            num[i] = new Random().nextInt(100);
            System.out.print(num[i] + " ");
        }
        System.out.println();
        //����������Ȼ����ʾ����������
        bubbleSort(num);
        for (int j : num) {
            System.out.print(j + " ");
        }
        System.out.println();
        //��ʾ�û�������ҵĹؼ���
        System.out.println("����Ҫ���ҵĹؼ���:");
        int k = new Scanner(System.in).nextInt();
        //���ö��ֲ���
        int result = binarySearch(num, k);
        //��ʾ���Һ�Ľ��
        System.out.println("���ҵĽ��Ϊ:" + result);
    }

}
