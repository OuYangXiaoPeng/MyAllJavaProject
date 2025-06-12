package classtest.Class.People;

public class Person {
    String name;
    int age;
    String address;

    public Person() {
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void introduce() {
        System.out.println("姓名:" + name + ",年龄" + age + ",地址:" + address);
    }

    //    重写toString
    @Override
    public String toString() {
        return "姓名:" + name + ",年龄" + age + ",地址:" + address;
    }

    //    重写equals
    @Override
    public boolean equals(Object obj) {
//        如果传递的参数是本类的同一对象
        if (this == obj)
            return true;

        if (obj == null)
            return false;
//
        if (getClass() != obj.getClass())
            return false;
        Person p = (Person) obj;
        if (name != p.name || age != p.age || address != p.address)
            return false;
        return true;
    }

    public static void main(String[] args) {
        Person p1 = new Person("小米", 25, "重庆");
        Person p2 = new Person("小米", 25, "重庆");
        Person p3 = new Person("张三", 25, "重庆");
        Person p4 = new Person("小米", 26, "重庆");
        System.out.println(p1);
        System.out.println(p1.equals(p2));
    }
}
