package DanLianBiaoYingYong2;

import DanLianBiao.LinkList;
import java.util.Scanner;
/*
学生成绩表--继承自单链表类
 */
public class StuScoreList extends LinkList {

    Scanner sc = new Scanner(System.in);

    //构造方法--创建一个学生链表
    public StuScoreList() throws Exception {
        super();//调用父类构造方法创建一个空的表
        for (int i = 0; i < 5; i++) {
            StuRecord s = new StuRecord("00"+i, "学生"+i,80+i);
            this.insert(this.length(),s);

//            StuRecord s2 = new StuRecord(sc.next(), sc.next(), sc.nextInt());
//            this.insert(this.length(), s2);
        }
    }

    //重载方法get，获取指定学号的学生记录
    public StuRecord get(String sNo) throws Exception {
        //通过父类get(i)方法，遍历线性表，找到指定学号的记录并返回 令i：0~n-1
        for (int i = 0; i < this.length(); i++) {
            StuRecord temp = (StuRecord) super.get(i);
            if (temp.stuNo.equals(sNo))
                return temp;
        }
        //没找到，提示信息
        throw new Exception("学号:" + sNo + "的学生没找到");
    }

    //重载方法insert()，将记录插入表尾
    public void insert(StuRecord s) throws Exception {
        super.insert(this.length(), s);
    }

    //重载方法remove()，删除指定学号的记录
    public void remove(String sNo) throws Exception {
        //1.遍历线性表，找到学号为stuNo的记录位置
        int i;
        for (i = 0; i < this.length(); i++) {
            StuRecord temp = (StuRecord) super.get(i);
            if (temp.stuNo.equals(sNo))
                break;
        }
        if (i < length())
        //2.删除该位置的记录--调用父类的remove方法
            super.remove(i);
        else
            //没找到，提示信息
            throw new Exception("未找到学号:" + sNo + "，无法删除！");
    }

    //重载方法indexOf(),查找指定学号的记录
    public int indexOf(String stuNO) throws Exception{
        //for结合get遍历线性表，找到该学号的学生，就返回位置并退出
        for (int i = 0; i < this.length(); i++) {
            StuRecord temp = (StuRecord) super.get(i);
            if (temp.stuNo.equals(stuNO))
                return i;
        }
        //没找到就返回-1
        return -1;
    }

    //重写父类的display方法--以表格的形式输出
    @Override
    public void display() {
        System.out.println("学号\t姓名\t\t成绩");
        System.out.println("-----------------------------");
        super.display();//调用父类的display方法显示链表中的元素
    }
}
