package ZhanDeYingYong;

import java.util.Scanner;

import ShunXuZhan.SqStack;
/**
 * 后缀表达式求值
 * 基本思想：从左到右扫描表达式的每个字符，遇到操作数则入栈；遇到运算符，则连续
 * 出栈两个操作数进行运算，再将得到的结果作为中间操作数入栈
 * @author yhyym
 *
 */

public class Expression {

    public static void main(String[] args) throws Exception {
        //1、提示用户输入后缀表达式字符串
        System.out.println("请输入后缀表达式：");
        String str=new Scanner(System.in).next();
        //2、创建一个空的顺序栈
        SqStack stk=new SqStack(100);
        int len=str.length();
        //3、循环：分析表达式字符串的每一个字符
        for (int i=0; i<len; i++){
            //取出第i个字符
            char c=str.charAt(i);
            //a、若为'0'~'9'之一，则入栈
            if (c>='0' && c<='9')
                stk.push(c-'0');
                //b、若为'+'、'-'、'*'、'/'四个运算符之一，则：
            else if (c=='+' ||c=='-' ||c=='*' ||c=='/'){
                //第一次出栈，作为操作数num2
                int num2=(int) stk.pop();
                //第二次出栈，作为操作数num1
                int num1=(int) stk.pop();
                //根据运算符类型，计算result=num1 运算符 num2
                int result=0;
                switch(c){
                    case '+': result=num1+num2; break;
                    case '-': result=num1-num2; break;
                    case '*': result=num1*num2; break;
                    case '/': result=num1/num2; break;
                }
                //再将结果result入栈
                stk.push(result);
            }
            //c、若为其他字符，提示出错，退出
            else {
                System.out.println("后缀表达式有错！");
                return;
            }
        }
        //4、若栈非空且只有一个元素，出栈即为结果
        if (stk.length()==1)
            System.out.println("表达式的值为："+ stk.pop());
            //     否则，提示表达式错误
        else
            System.out.println("后缀表达式有错！");
    }
}
