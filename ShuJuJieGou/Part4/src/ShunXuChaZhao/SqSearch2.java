package ShunXuChaZhao;

import java.util.Random;
import java.util.Scanner;

/**
 * ˳�����--�������ҹؼ���k����ұ�(����)��Ԫ��˳��ıȽ�
 * �Ľ���ʽ�����ڱ���˳�����
 * ����˼�룺����ÿ��ѭ���ıȽϴ�����ֻ���ؼ��ֱȽϣ�
 * ����һ����Ԫ�������һ����Ԫ�洢���ڱ���
 * �ڱȽϳɹ�֮�󣬸���Ԫ�ص��±�λ���Ƿ����ڱ���λ�ã����жϳɹ����
 */
public class SqSearch2 {
    //�ҵ����򷵻�һ��>=0��λ�ã����򷵻�-1
    public static int sqSearch(int[] r, int k) {
        int i = 0;  //���ұ�Ԫ�ص��±꣬��r[0]
        while (r[i] != k) {
            i++;
        }
        if (i < r.length - 1)
            return i;   //���ڱ���ǰ��λ���ҵ����˳������ҳɹ�
        else
            return -1; //���ڱ���λ���ҵ����˳�������ʧ��
    }

    public static void main(String[] args) {
        //���岢��ʼ������ʾ����
        int[] num = new int[10];
        for (int i = 0; i < num.length; i++) {
            num[i] = new Random().nextInt(100);
            System.out.print(num[i] + " ");
        }
        System.out.println();
        //���ò����㷨
        System.out.println("����Ҫ���ҵĹؼ���:");
        int k = new Scanner(System.in).nextInt();

        //�����ڱ�
        num[9] = k;

        int result = sqSearch(num, k);
        //��ʾ���Һ�Ľ��
        System.out.println("���ҵĽ��Ϊ:" + result);
    }
}
