package DanLianBiaoYingYong;

/*
学生成绩表的元素
 */
public class StuRecord {
    //成员方法--3个
    String stuNo;
    String name;
    int score;

    //构造方法--2个
    public StuRecord() {
        this.stuNo = null;
        this.name = null;
        this.score = 0;
    }

    public StuRecord(String stuNo, String name, int score) {
        this.stuNo = stuNo;
        this.name = name;
        this.score = score;
    }

    //成员方法--2个:方便对象的比较和显示
    @Override
    public boolean equals(Object o) {
        StuRecord s = (StuRecord) o;
        return this.stuNo.equals(s.stuNo);
    }

    @Override
    public String toString() {
        return this.stuNo + "\t" + this.name + "\t" + this.score + "\n";
    }
}
