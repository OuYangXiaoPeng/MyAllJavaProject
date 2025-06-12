package Work.ThreeWork.Traffic;

import java.util.Scanner;

class Car extends Traffic {
    int passengerCount;

    public Car(int wheels, int weight, int passengerCount) {
        super(wheels, weight);
        this.passengerCount = passengerCount;
    }

    public int getTotal() {
        return weight + passengerCount * 60;
    }

    public void show() {
        System.out.println(wheels + "轮小车，共载" +
                passengerCount + "人，总重" +
                getTotal() + "kg");
    }
}

class Truck extends Traffic {
    int passengerCount;
    int goodsWeight;

    public Truck(int wheels, int weight, int passengerCount, int goodsWeight) {
        super(wheels, weight);
        this.passengerCount = passengerCount;
        this.goodsWeight = goodsWeight;
    }

    public int getTotal() {
        return weight + passengerCount * 60 + goodsWeight;
    }

    public void show() {
        System.out.println(wheels + "轮货车，共载" +
                passengerCount + "人，载货" +
                goodsWeight + "kg，总重" +
                getTotal() + "kg");
    }
}

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输分别输入车轮数:");
        int wheels = sc.nextInt();
        System.out.println("净重量:");
        int weight = sc.nextInt();
        System.out.println("乘客数:");
        int passengerCount = sc.nextInt();
        System.out.println("货物重量:");
        int goodsWeight = sc.nextInt();
        System.out.println("车辆类型:");
        String type = sc.next();

        Traffic traffic;
        if (type.equals("Car")) {
            traffic = new Car(wheels, weight, passengerCount);
            traffic.show();
        } else if (type.equals("Truck")) {
            traffic = new Truck(wheels, weight, passengerCount, goodsWeight);
            traffic.show();
        } else {
            System.out.println("无效的车类型！");
        }
    }
}
