package Work.ThreeWork.Traffic;

public class Traffic {

    int wheels;
    int weight;

    public Traffic() {
    }

    public Traffic(int wheels, int weight) {
        this.wheels = wheels;
        this.weight = weight;
    }

    public void show() {
        System.out.println("车轮数: " + wheels + "净车重:" + weight);
    }
}
