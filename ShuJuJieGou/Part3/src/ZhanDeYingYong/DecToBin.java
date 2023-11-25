package ZhanDeYingYong;

import ShunXuZhan.SqStack;

import java.util.Scanner;

/**
 * 整数十进制转二进制(除2取余法)
 * 基本思想：将数反复除2，得到的余数就是二进制中的位，直到商为0，结束
 * 先得到的余数是二进制的低位（后显示），后得到的余数是二进制的高位（先显示）
 * 和栈的特性相符合
 */
public class DecToBin {

    static SqStack e(int n, int m) throws Exception {
        //创建一个空栈
        SqStack stk = new SqStack(100);
        //只要商数不等于0，则循环：
        do {
            int mod = n % m;
            stk.push(mod);
            n = n / m;
        } while (n != 0);
        return stk;
    }

    static long pow(int a, int b) {
        if(b==0){
            return 1;
        }
        if(b==1){
            return a;
        }
        if(b%2==0){
            return pow(a,b/2)* pow(a,b/2);
        }else {
            return pow(a,b-1)*a;
        }
    }

    static SqStack ef(int n, int m) throws Exception {
        //创建一个空栈
        SqStack stk = new SqStack(100);
        //只要商数不等于0，则循环：
        do {
            int mod = n % m;
            if(mod == 11)
                mod = 'A';
            if(mod == 12)
                mod = 'B';
            if(mod == 13)
                mod = 'C';
            if(mod == 14)
                mod = 'D';
            if(mod == 15)
                mod = 'E';
            if(mod == 16)
                mod = 'F';
            stk.push(mod);
            n = n / m;
        } while (n != 0);
        return stk;
    }


    public static void main(String[] args) throws Exception {
        //提示用书，输入要转换的数
        System.out.println("请输入一个十进制的数:");
        int num = new Scanner(System.in).nextInt();
        //初始化商数
        int n = num;

        System.out.print(num + "转换为二进制数为:");
        //m为几进制
        e(n, 16).display();
        //只要栈非空，则循环：
//        while (!stk.isEmpty()) {
//            //出栈，显示一位数
//            System.out.print(stk.pop() + " ");
//        }
    }
    //8进制
    //16进制
}
