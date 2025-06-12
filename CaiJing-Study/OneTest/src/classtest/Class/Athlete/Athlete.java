package classtest.Class.Athlete;

public class Athlete {
    String name;
    int age;
    String major;

    public Athlete() {
    }

    public Athlete(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public void show() {
        System.out.println("名字:" + name + "，年龄:" + age + "，专业:" + major);
    }
}
