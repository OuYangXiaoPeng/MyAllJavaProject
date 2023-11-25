package DanLianBiaoYingYong;

import DanLianBiao.LinkList;

import java.util.Scanner;

/*
学生成绩表--继承自单链表类
 */
public class StuScoreList extends LinkList {
    //构造方法--创建一个学生链表
    Scanner sc = new Scanner(System.in);

    public StuScoreList() throws Exception {
        super();//调用父类构造方法创建一个空的表
        for (int i = 0; i < 5; i++) {
            StuRecord s = new StuRecord("00"+i, "学生"+i,80+i);
            this.insert(this.length(),s);

//            StuRecord s2 = new StuRecord(sc.next(), sc.next(), sc.nextInt());
//            this.insert(this.length(), s2);
        }
    }

    //重写父类的display方法--以表格的形式输出
    @Override
    public void display() {
        System.out.println("学号\t姓名\t\t成绩");
        System.out.println("-----------------------------");
        super.display();//调用父类的display方法显示链表中的元素
    }
}
