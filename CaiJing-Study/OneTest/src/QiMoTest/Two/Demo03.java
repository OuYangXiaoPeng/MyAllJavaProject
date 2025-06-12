package QiMoTest.Two;

import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您的身份证号码：");
        String idNumber = scanner.next();

        if (idNumber.length() != 18) {
            System.out.println("输入有误");
            return;
        }

        show(idNumber);
    }

    public static void show(String idNumber) {
        // 判断第一位是否为0
        if (idNumber.charAt(0) == '0') {
            System.out.println("输入有误");
            return;
        }

        // 判断前17位是否为数字
        for (int i = 0; i < 17; i++) {
            if (!Character.isDigit(idNumber.charAt(i))) {
                System.out.println("输入有误");
                return;
            }
        }

        // 判断最后一位是否为数字或X
        char lastChar = idNumber.charAt(17);
        if (!((lastChar >= '0' && lastChar <= '9') || lastChar == 'X' || lastChar == 'x')) {
            System.out.println("输入有误");
            return;
        }

        System.out.println("输入正确");

        // 获取下标位置为5的元素
        char ch = idNumber.charAt(5);
        System.out.println("下标位置为5的元素: " + ch);

        // 获取元素“0”第一次出现的位置
        int index = idNumber.indexOf('0');
        System.out.println("元素“0”第一次出现的位置: " + index);

        // 判断字符串首尾是否分别以“5”、“x”开始、结尾
        boolean bool1 = idNumber.startsWith("5");
        boolean bool2 = idNumber.endsWith("x");
        System.out.println("字符串是否以“5”开始: " + bool1);
        System.out.println("字符串是否以“x”结尾: " + bool2);

        // 截取字符串（起止位置分别为1、5）
        String sub = idNumber.substring(1, 5);
        System.out.println("截取的字符串（1,5）: " + sub);

        // 将字符串按照指定的符号（“0”）分割成数组
        String[] sArray = idNumber.split("0");
        System.out.println("按照“0”分割后的数组：");
        for (String s : sArray) {
            System.out.println(s);
        }
    }
}