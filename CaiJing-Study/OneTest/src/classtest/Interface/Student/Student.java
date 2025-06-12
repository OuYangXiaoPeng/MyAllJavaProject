package classtest.Interface.Student;

public class Student implements Library, Restaurant {

    String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void Borrow() {
        System.out.println(this.name + "在图书馆借阅");
    }

    @Override
    public void eat() {
        System.out.println(this.name + "在餐厅吃饭");
    }

    public static void main(String[] args) {
        Student s = new Student("小芳");
        s.Borrow();
        s.eat();
    }
}
