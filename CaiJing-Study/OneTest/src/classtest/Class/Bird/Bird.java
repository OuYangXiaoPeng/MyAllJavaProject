package classtest.Class.Bird;

public class Bird {
    String name;
    int age;
    String color;

    public Bird() {
    }

    public Bird(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public void show() {
        System.out.println("名字:" + name + "，年龄:" + age + "，颜色:" + color);
    }
}
