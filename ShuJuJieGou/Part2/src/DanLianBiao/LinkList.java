package DanLianBiao;

import java.util.Scanner;

/*
单链表类
用结点来保存数据元素的值
实现线性表的8个基本操作
 */
public class LinkList implements IList {
    //成员变量--1个头指针
    private Node head;

    //构造方法--创建一个空的单链表(为了调试目的，增加了几个元素，建立链接)
    public LinkList() {
        head = new Node();
    }

    //8个成员方法
    @Override
    public void clear() {
//清空
        head.next = null;//将单链表的头结点指针域设置为空
    }

    @Override
    public boolean isEmpty() {
//        判空
        return head.next == null;
    }

    @Override
    public int length() {
//        求长--和表遍历有关

//        1.定义指针p指向第一个元素结点
        Node p = head.next;
//        2.定义长度变量length=0
        int length = 0;
//        3.只有p指向的结点存在，则循环
        while (p != null) {
            length++;//长度+1
            p = p.next;//p后移，指向下一个
        }
//        4.长度返回
        return length;
    }

    @Override
    public Object get(int i) throws Exception {
//        获取指定编号的元素值，返回--按序号查找
//        1.定义指针p，指向第一个元素结点
        Node p = head.next;
//        2.定义变量j，保存当前p指向的结点的序号，初值为0
        int j = 0;
//        3.只要p指向的结点存在（p未到表尾）并且j<i（当前结点序号小于要找发结点序号i），则循环
        while (p != null && j < i) {
            p = p.next;//指针后移
            j++;//计数加1
        }

//        4.若p已到表尾（i太大），或j>i（i太小）
        if (j > i || p == null) {//i小于0或者大于表长减1
//        则抛出异常
            throw new Exception("第" + i + "个元素不存在");
        }
//        5.（肯定因为j==i退出循环），说明找到了，返回当前结点的数据域
        return p.data;
    }

    @Override
    public void insert(int i, Object x) throws Exception {
        //在i号位置插入一个值为x的新结点
        //找到插入位置i的前驱结点ai
        //1.定义指针p，指向头结点
        Node p = head;
        //2.定义变量j，初值-1，当前结点的编号
        int j = -1;
        //3.只要p未到表尾 且 当前结点编号j<要找的结点编号i-1，则循环
        while (p != null && j < i - 1) {
            p = p.next;//p后移
            j++;//结点编号j+1
        }
        //4.若j>i-1(i太小，为负数)或p已到表尾(i太大)
        if (j > i - 1 || p == null) {
            //抛出异常不合法
            throw new Exception("插入位置" + i + "不合法");
        }
        //5.(j==i-1)，找到了i-1号结点，则创建值为x的新结点
        Node s = new Node(x);
        //修改链接关系
        //6.将ai作为新结点的后继结点
        s.next = p.next;
        //7.将新结点作为ai-1的后继结点
        p.next = s;
    }

    @Override
    public void remove(int i) throws Exception {
        //删除位置i的结点
        //找到ai的前驱结点ai-1--get(i-1)
        //1.定义指针p，指向头结点
        Node p = head;
        //2.定义变量j，初值-1，当前结点的编号
        int j = -1;
        //3.只要p未到最后一个结点 且 当前结点编号j<要找的结点编号i-1，则循环
        while (p.next != null && j < i - 1) {
            p = p.next;//p后移
            j++;//结点编号j+1
        }
        //4.若j>i-1(i太小，为负数)或p已到最后一个结点(i太大)
        if (j > i - 1 || p.next == null) {
            //抛出异常不合法
            throw new Exception("插入位置" + i + "不合法");
        }
        //修改链接关系(j==i-1)
        //5.将ai+1的地址指针(原来在ai的指针域)放到ai-1结点的指针域
        p.next = p.next.next;
    }

    @Override
    public int indexOf(Object x) {
//        查找：查找链表中是否存在值为x的结点，若存在，返回其第一次出现的位置，否则返回-1
//        1.定义指针p，指向第一个元素结点
        Node p = head.next;
//        2.定义变量j，保存当前p指向的结点的序号，初值为0
        int j = 0;
//        3.只要p指向的结点存在（p未到表尾）并且该结点的值不等于x，则循环
        while (p != null && !p.data.equals(x)) {
            p = p.next;//指针后移
            j++;//计数加1
        }
//        5.否则，当前结点的值就是x，找到了，返回该结点的序号j
        if (p == null)
            return -1;
//        4.若p已到表尾（指向的结点不存在），则未找到，返回-1
        else
            return j;
    }

    @Override
    public void display() {
//输出--从头到尾输出链表各个结点的值
//        1.定义指针p，指向第一个元素（的地址，存在于头结点的指针域head.next）
        Node p = head.next;
//        2.只要p指向的结点存在（p未到表尾），则循环
        while (p != null) {
//        输出p指向的当前结点的数据域p.data
            System.out.print(p.data + "");
//        p指向后继结点（的地址在当前p指向的结点的指针域p.next）
            p = p.next;
        }
//        3.输出换行
        System.out.println();
    }

    //头插法创建单链表
    public void create2(int n) throws Exception{
        Scanner s = new Scanner(System.in);
        System.out.println("头插法逆序建表：");
       //连续从键盘获取数据、创建结点插入到表头
        for (int i = 0; i < n; i++) {
            this.insert(0,s.next());
        }
    }

    //尾插法创建单链表
    public void create1(int n) throws Exception{
        Scanner s = new Scanner(System.in);
        System.out.println("尾插法正序建表：");
        //连续从键盘获取数据、创建结点插入到表尾
        for (int i = 0; i < n; i++) {
            this.insert(this.length(),s.next());
        }
    }
}
