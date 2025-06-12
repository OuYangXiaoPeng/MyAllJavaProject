package Work.FourWork.Animal;

public class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void getMessage() {
        System.out.println("名字: " + name);
    }
}

class Tiger extends Animal {
    int age;

    public Tiger(String name, int age) {
        super(name);
        this.age = age;
    }

    public void getMessage() {
        System.out.println("名字: " + name + ",年龄:" + age);
    }
}

class Dog extends Animal {
    String color;

    public Dog(String name, String color) {
        super(name);
        this.color = color;
    }

    public void getMessage() {
        System.out.println("名字: " + name + ",颜色:" + color);
    }
}