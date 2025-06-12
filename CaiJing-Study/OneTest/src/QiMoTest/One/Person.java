package QiMoTest.One;

abstract class Person {
    public String name;
    public int age;
    public String hobby;

    public Person(String name, int age, String hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public abstract void show();
}

class Student extends Person {
    public String address;

    public Student(String name, int age, String hobby, String address) {
        super(name, age, hobby);
        this.address = address;
    }

    @Override
    public void show() {
        System.out.println("我是学生（" + name + "）今年（" + age + "）岁，爱好（" + hobby + "），家住（" + address + "）。");
    }

    public static void main(String[] args) {
        Person p1 = new Student("建国", 18, "踢足球", "重庆");
        p1.show();
    }
}
