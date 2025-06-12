package classtest.Class.People;

public class Emp extends Person {
    double salary;

    public Emp() {
    }

    public Emp(String name, int age, String address, double salary) {
        super(name, age, address);
        this.salary = salary;
    }

    public void getSalary() {
        System.out.println("工资:" + salary);
    }

    public static void main(String[] args) {
        Emp[] emp = new Emp[3];
        emp[0] = new Emp("张三", 21, "重庆", 6000);
        emp[1] = new Emp("李四", 22, "重庆", 7000);
        emp[2] = new Emp("王五", 23, "重庆", 8000);
        for (int i = 0; i < emp.length; i++) {
            emp[i].introduce();
            emp[i].getSalary();
        }
    }
}
