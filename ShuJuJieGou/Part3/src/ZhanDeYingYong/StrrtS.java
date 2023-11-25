package ZhanDeYingYong;

import ShunXuZhan.SqStack;

import java.util.Scanner;

/**
 * 回文字符串判断
 * 基本思想：正数的第i个字符如果等于倒数的第i个字符
 * 如何得到倒数第i个字符：将字符顺序入栈，再出栈，得到字符的倒叙
 * 字符串的方法charAt(i)
 */
public class StrrtS {

    public static void main(String[] args) throws Exception {
        //提示用户输入字符串
        System.out.println("请输入字符串:");
        String str = new Scanner(System.in).next();
        //创建空栈
        SqStack stk = new SqStack(100);
        //求串长(循环次数)
        int len = str.length();
        //将字符串每个字符依次取出，并入栈
        //令i从0~n-1依次取值，循环：
        for (int i = 0; i < len; i++) {
            //取出第i个字符,入栈
            stk.push(str.charAt(i));
        }
        //比较正数的第i个字符和倒数第i个字符
        //令i从0~n-1依次取值，循环：
        for (int i = 0; i < len; i++) {
            //获取正数第i个字符ch1
            char ch1 = str.charAt(i);
            //获取倒数第i个字符ch2
            char ch2 = (char) stk.pop();
            //比较，若ch1不等于ch2，则提示“不是回文字符串”，退出
            if (ch1 != ch2) {
                System.out.println("不是回文字符串");
                return;
            }
        }
        //提示“是回文字符串”
        System.out.println("是回文字符串");
    }
    //降低栈空间
}
