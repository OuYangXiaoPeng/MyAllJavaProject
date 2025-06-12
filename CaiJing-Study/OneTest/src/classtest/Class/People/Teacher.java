package classtest.Class.People;

public class Teacher extends Person {
    String level;

    public Teacher() {
    }

    public Teacher(String name, int age, String address, String level) {
        super(name, age, address);
        this.level = level;
    }

    public void introduce() {
        System.out.println("姓名:" + name + ",年龄" + age +
                ",地址:" + address + ",等级:" + level);
    }

    public static void main(String[] args) {
        Teacher t = new Teacher("张三", 40, "重庆", "教授");
        t.introduce();
    }
}
