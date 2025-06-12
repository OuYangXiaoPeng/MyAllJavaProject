package ClassPractice.Three.People;

public class Student extends People {
    int age;

    public Student(String name, int age) {
        super(name);
        this.age = age;
    }

    public void show() {
        System.out.println("名字是:" + name + ",年龄:" + age);
    }
}
