package classtest.Class.student;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("小刚");
        s1.setAge(18);
        s1.setGender("男");
        System.out.println("姓名:" + s1.getName() +
                ",年龄:" + s1.getAge() +
                ",性别:" + s1.getGender());

        Student s2 = new Student("小美", 19, "女");
        System.out.println("姓名:" + s2.getName() +
                ",年龄:" + s2.getAge() +
                ",性别:" + s2.getGender());
    }
}
