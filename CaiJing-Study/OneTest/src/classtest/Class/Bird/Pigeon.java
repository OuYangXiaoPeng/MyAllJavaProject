package classtest.Class.Bird;

public class Pigeon extends Bird {
    int speed;

    public Pigeon() {
    }

    public Pigeon(String name, int age, String color, int speed) {
        super(name, age, color);
        this.speed = speed;
    }

    public void fly() {
        System.out.println("名字:" + name + "，年龄:" +
                age + "，颜色" + color + "，飞行速度:" + speed);
    }

}
