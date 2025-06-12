package ClassPractice.Three;

import java.util.Scanner;

public class SuShu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入一个整数：(输入0退出)");
        while (true) {
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            } else {
                if (num <= 1) {
                    System.out.println(num + " 不是素数。");
                } else {
                    boolean isSuShu = true;
                    for (int i = 2; i * i <= num; i++) {
                        if (num % i == 0) {
                            isSuShu = false;
                            break;
                        }
                    }
                    if (isSuShu) {
                        System.out.println(num + " 是素数。");
                    } else {
                        System.out.println(num + " 不是素数。");
                    }
                }
            }

        }

    }
}