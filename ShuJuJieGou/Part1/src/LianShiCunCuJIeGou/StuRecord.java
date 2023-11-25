package LianShiCunCuJIeGou;

//学生记录类--结点类，包括两个部分；
//数据域，保存三个数据项
//指针域
public class StuRecord {
    //成员变量4个，数据域3个，指针1个
    String stuNo;
    String Name;
    int score;
    StuRecord next;//指向后继地址的指针

    //构造方法--2个
    public StuRecord() {
    }

    public StuRecord(String stuNo, String Name, int score, StuRecord next) {
        this.Name = Name;
        this.stuNo = stuNo;
        this.score = score;
        this.next = next;
    }
}
