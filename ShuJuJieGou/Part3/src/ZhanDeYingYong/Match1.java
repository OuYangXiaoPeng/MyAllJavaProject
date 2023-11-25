package ZhanDeYingYong;

import ShunXuZhan.SqStack;

import java.util.Scanner;

/**
 * 分隔符匹配（1）--只有小括号
 * 基本思想：从左到右扫描表达式，遇到左括弧，则入栈；遇到右括弧，则出栈一个左括弧匹配
 * 在每个字符扫描的过程中，最后出现的左括弧，最先匹配
 * */
public class Match1 {

    public static void main(String[] args) throws Exception {
        int count = new Scanner(System.in).nextInt();
        System.out.println("次数:");
        for (int j = 0; j < count; j++) {
            //提示输出java语句
            System.out.println("请输入Java表达式:");
            String str = new Scanner(System.in).next();
            //创建空栈
            SqStack stk = new SqStack(100);
            int len = str.length();//字符串长度
            //循环，从左到右扫描字符串（每次获取一个字符）：
            for (int i = 0; i < len; i++) {
                //获取第i个字符
                char c = str.charAt(i);
                //若是左括弧，则入栈
                if(c == '('){
                    stk.push(c);
                }
                //否则，若是右括弧：
                else if(c == ')'){
                    //若栈为空，则提示错误“左括弧数量不足”，退出
                    if(stk.isEmpty()){
                        System.out.println("左括弧数量不足");
                        return;
                    }
                    //否则，出栈一个左括弧，与当前的右括弧匹配
                    stk.pop();
                }
                //否则(其他字符)，略过
                else;
            }
            //若栈非空，则提示错误“右括弧数量不足”
            if(!stk.isEmpty()){
                System.out.println("右括弧数量不足");
            }
            //否则，提示“匹配正确”
            else {
                System.out.println("匹配正确");
            }
        }

    }
}
