package ShunXuBiao;

import java.util.Scanner;

/*
【例1】
编程实现：建立一个顺序表（'a', 'z', 'd', 'm', 'z'），
然后查找顺序表中第一次出现的值为字母'z'的数据元素，
并输出其在顺序表中的位置。

 */
public class Exp01 {

    public static void main(String[] args) throws Exception{
//        1.创建一个内容为10的空顺序表
        SqList list1 = new SqList(10);
//        2.在其中插入字母表的所有元素
//        方法1：表尾插入--正序
//        list1.insert(0,'a');
//        list1.insert(1,'z');
//        list1.insert(2,'d');
//        list1.insert(3,'m');
//        list1.insert(4,'z');

//        方法2：表头插入--逆序
//        list1.insert(0,'z');
//        list1.insert(0,'m');
//        list1.insert(0,'d');
//        list1.insert(0,'z');

//        方法3：循环--1）数据元素来自数组 2）来自键盘
        char [] ch ={'a','z','d','m','z'};
        for (int i = 0; i < ch.length; i++) {
            list1.insert(list1.length(),ch[i]);
        }

//        Scanner sc = new Scanner(System.in);
//        for (int i = 0; i < ch.length; i++) {
//            list1.insert(list1.length(),sc.next());
//        }

        list1.display();
//        3.查找元素‘z’，返回结果
        int order = list1.indexOf('z');
        if (order != -1){
        System.out.println("找到了，位置在："+order);
        }
        else {
            System.out.println("没找到！"+order);
        }
    }
}
