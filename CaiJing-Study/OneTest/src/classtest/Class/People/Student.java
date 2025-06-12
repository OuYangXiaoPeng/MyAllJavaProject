package classtest.Class.People;

public class Student extends Person {
    String stuID;
    String schoolName;

    public Student() {
    }

    public Student(String name, int age, String address, String stuID, String schoolName) {
        super(name, age, address);
        this.stuID = stuID;
        this.schoolName = schoolName;
    }

    public void sayHi() {
        System.out.println("我是:"+name+",学生ID:" + stuID + ",学校是:" + schoolName);
    }

    public static void main(String[] args) {
        Student p = new Student("张三", 18,
                "重庆", "123", "重庆财经学院");
        p.introduce();
        p.sayHi();
    }
}
