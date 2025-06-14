package ClassPractice.Three;

public class Animal {
    private String name;
    private int age;
    private String color;

    public Animal() {

    }

    public Animal(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void show() {
        System.out.println("名字:" + name + ",年龄：" + age + ",颜色：" + color);
    }

    public static void main(String[] args) {
        Animal animal = new Animal("大黄", 3, "黄色");
        System.out.println(animal.getName());
        System.out.println(animal.getAge());
        System.out.println(animal.getColor());
        animal.show();
    }
}
