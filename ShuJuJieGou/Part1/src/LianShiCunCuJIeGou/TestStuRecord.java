package LianShiCunCuJIeGou;


//学生成绩表--链式存储结构的实现
public class TestStuRecord {

    public static void main(String[] args) {
        //1.创建4个结点对象，保存数据元素的值
        StuRecord stu1 = new StuRecord("001", "张三", 76, null);
        StuRecord stu2 = new StuRecord("002", "李四", 88, null);
        StuRecord stu3 = new StuRecord("003", "王五", 90, null);
        StuRecord stu4 = new StuRecord("004", "赵六", 68, null);
        StuRecord stu5 = new StuRecord("005", "Tom", 90, null);
        //2.建立结点之间的关系
        stu1.next = stu2;
        stu2.next = stu3;
        stu3.next = stu4;
        stu4.next = null;

        //3.按表格输出
        System.out.println("学号\t姓名\t成绩");
        System.out.println("-------------------");
        //定义一个结点指针的变量s,指向第一个结点
        StuRecord s;
        s = stu1;
        while (s != null) {
            System.out.println(s.stuNo + "\t" + s.Name + "\t" + s.score);
            s = s.next;//让指针指向后继结点
        }

//        stu1.next = stu2;
//        stu2.next = stu3;
//        stu3.next = stu5;
//        stu5.next = null;
//
//        //3.按表格输出
//        System.out.println("学号\t姓名\t成绩");
//        System.out.println("-------------------");
//        //定义一个结点指针的变量s,指向第一个结点
//
//        s = stu1;
//        while (s != null) {
//            System.out.println(s.stuNo + "\t" + s.Name + "\t" + s.score);
//            s = s.next;//让指针指向后继结点
//        }


    }
}
