package LianShi2;

import java.util.Scanner;

public class TestStuRec2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str,name;
        int sorce;
        StuRec2 [] sturec = new StuRec2[100];
        System.out.println("请输入4个同学的信息："+"\n（先学号，再姓名，最后成绩）");
        System.out.println("第一位同学的信息：");
        StuRec2 stu1 = new StuRec2(str=s.next(),name=s.next(),sorce=s.nextInt(),null);
        sturec[0] = stu1;
        System.out.println("第二位同学的信息：");
        StuRec2 stu2 = new StuRec2(str=s.next(),name=s.next(),sorce=s.nextInt(),null);
        sturec[1] = stu2;
        System.out.println("第三位同学的信息：");
        StuRec2 stu3 = new StuRec2(str=s.next(),name=s.next(),sorce=s.nextInt(),null);
        sturec[2] = stu3;
        System.out.println("第四位同学的信息：");
        StuRec2 stu4 = new StuRec2(str=s.next(),name=s.next(),sorce=s.nextInt(),null);
        sturec[3] = stu4;
        StuRec2 stu5 = new StuRec2("007","邦德",98,null);

        stu1.next = stu2;
        stu2.next = stu3;
        stu3.next = stu4;
        stu4.next = null;

        StuRec2 p;
        p = stu1;
        System.out.println("学号\t姓名\t成绩");
        System.out.println("-------------------");
        while (p != null){
            System.out.println(p.stuNo+"\t"+p.Name+"\t"+p.score);
            p = p.next;
        }

        System.out.println();
        stu1.next = stu5;
        stu5.next = stu2;
        stu2.next = stu3;
        stu3.next = stu4;
        stu4.next = null;
        p = stu1;
        System.out.println("插入1个新的学生成绩结点：");
        System.out.println("学号\t姓名\t成绩");
        System.out.println("-------------------");
        while (p != null){
            System.out.println(p.stuNo+"\t"+p.Name+"\t"+p.score);
            p = p.next;
        }

        System.out.println();
        stu1.next = stu5;
        stu5.next = stu3;
        stu3.next = stu4;
        stu4.next = null;
        p = stu1;
        System.out.println("删除第三个结点的信息：");
        System.out.println("学号\t姓名\t成绩");
        System.out.println("-------------------");
        while (p != null){
            System.out.println(p.stuNo+"\t"+p.Name+"\t"+p.score);
            p = p.next;
        }


    }

}
