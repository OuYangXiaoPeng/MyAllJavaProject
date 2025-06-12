package classtest.Class.Animal;

public class Animal {
    //成员变量
    String name;
    int age;
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color.equals("白色") || color.equals("黑色") || color.equals("黄色")) {
            this.color = color;
        } else {
            this.color = "彩色";
        }
    }

    public void show() {
        System.out.println(this.color + "的" + this.name + "今年" + this.age + "岁了");
    }

    public void eat() {
        System.out.println(this.age + "的" + this.name + "正在吃饭!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.name = "小黄";
        animal.age = 3;
        animal.color = "red";
        animal.show();
        animal.eat();
    }
}
