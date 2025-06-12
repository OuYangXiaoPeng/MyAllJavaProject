package classtest.Class.Method;

import java.util.Scanner;

public class MethodDemo02 {

    public static int primeNmu(int n) {
        boolean b = true;
        if (n < 2) {
            return 0;
        } else {
            for (int i = 2; i <= n - 1; i++) {
                if (n % i == 0) {
                    b = false;
                    break;
                }
            }
            if (b) {
                return n;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字(不小于2的整数):");
        while (true) {
            int num = sc.nextInt();
            if (num < 2) {
                System.out.println("输入不合法，请重新输入:");
            } else {
                System.out.println("当前范围的所有质数:");
                int sum = 0;
                for (int i = 0; i < num; i++) {
                    //判断当前数是否为质数
                    //如果是质数，用1表示，如果返回为0，代表不是质数
                    int sf = primeNmu(i);
                    if (sf != 0) {
                        System.out.print(sf + " ");
                        sum += sf;
                    }
                }
                System.out.println();
                System.out.println("当前所有质数的和是:" + sum);
                break;
            }
        }

    }
}
