package classtest.Class.craft;

public class Car {
    //    成员变量
    String brand;
    String color;
    double speed = 80;

    //    汽车方法
    void run() {
        System.out.println(color + "的" + brand + "汽车在以" + speed + "速度运行");
    }

    void stop() {
        String color = "红色";
        System.out.println(this.color + "的" + brand + "汽车在" + color + "的旁边停着");
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.setBrand("宝马");
        car.setColor("白色");
        car.setSpeed(90);
        car.run();
        car.stop();
    }
}
