package Work.OneWork;

import java.util.Scanner;

public class JiOu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("判断奇数和偶数请输入一个整数:(输入0停止)");
            int num = sc.nextInt();
            if (num == 0) {
                System.out.println("程序结束");
                break;
            } else if (num % 2 == 0) {
                System.out.println(num + "是偶数。");
            } else
                System.out.println(num + "是奇数。");
        }
    }
}
