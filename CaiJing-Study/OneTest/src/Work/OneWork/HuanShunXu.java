package Work.OneWork;

import java.util.Arrays;
import java.util.Scanner;

public class HuanShunXu {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个正整数：");
        int number = sc.nextInt();

        // 数字反转
        int re = 0;
        while (number != 0) {
            int temp = number % 10;
            re = re * 10 + temp;
            number /= 10;
        }
        System.out.println("反转后为:"+re);

        // 字符串反转
        System.out.println("请输入字符串：");
        String str = sc.next();
        char[] lines = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            lines[i] = str.charAt(str.length() - 1 - i);
        }
        System.out.println("反转后的字符串为：" + Arrays.toString(lines));
    }
}
