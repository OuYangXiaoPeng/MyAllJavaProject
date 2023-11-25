package ShunXuCunCuJieGou;

//学生成绩记录类--保存数据元素的信息
public class StuRecord {
    //成员变量--3个属性
    String stuNo;  //学号
    String Name;   //姓名
    int score;     //成绩

    //构造方法--2个
    public StuRecord() {
    }

    public StuRecord(String stuNo, String Name, int score) {
        this.Name = Name;
        this.stuNo = stuNo;
        this.score = score;
    }
}
