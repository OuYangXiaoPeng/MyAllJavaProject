package Work.FourWork.Cat;

public class Cat {
    String name;
    int age;
    double weight;
    String color;

    public Cat() {
    }

    public Cat(String name, int age, double weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public String toString() {
        return "名字:" + name + "\n" +
                "年龄:" + age + "\n" +
                "重量:" + weight + "\n" +
                "颜色:" + color + "\n";
    }
}
