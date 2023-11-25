package StudentManagement;

public class StuRecord{
    String No;
    String name;
    String sex;
    int Chinese;
    int math;
    int English;
    int average;

    public StuRecord() {
    }
    public StuRecord(String No, String name, String sex, int Chinese,int math, int English) {
        this.No = No;
        this.name = name;
        this.sex = sex;
        this.Chinese = Chinese;
        this.math = math;
        this.English = English;
        this.average = (Chinese + math + English)/3;
    }

    public boolean equals(Object o) {
        StuRecord p = (StuRecord) o;
        return this.No.equals(p.No);
    }

    public String toString() {
        return String.format("%-7s", this.No) + "\t" + String.format("%-7s", this.name) +"\t"+String.format("%-7s", this.sex)+ "\t" + String.format("%-7d", +this.Chinese) + "\t" + String.format("%-7d", this.math) + "\t" + String.format("%-7d", this.English) +"\t"+String.format("%-7s", this.average)+ "\n";
    }

}
