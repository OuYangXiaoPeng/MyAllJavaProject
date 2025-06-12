package Work.ThreeWork.Fruit;

public class Fruit {
    double price;

    public Fruit(double price) {
        this.price = price;
    }

    public void showPrice() {
        System.out.println("普通水果的价格是:" + price);
    }
}
