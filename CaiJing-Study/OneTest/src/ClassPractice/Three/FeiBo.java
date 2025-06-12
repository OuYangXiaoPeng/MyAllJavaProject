package ClassPractice.Three;

import java.util.Scanner;

public class FeiBo {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c = 0;
        Scanner s = new Scanner(System.in);

        System.out.println("请输入斐波那契数列的第几项：");
        int num = s.nextInt();

        if (num == 1 || num == 2) {
            System.out.println("值为1");
        } else {

            for (int i = 2; i < num; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            System.out.println("斐波那契数列第" + num + "项的值为：" + c);
        }

    }
}