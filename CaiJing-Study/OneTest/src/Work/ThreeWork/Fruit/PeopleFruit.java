package Work.ThreeWork.Fruit;

public class PeopleFruit extends Fruit {
    double BaoZhuang;

    public PeopleFruit(double price, double BaoZhuang) {
        super(price);
        this.BaoZhuang = BaoZhuang;
    }

    public void showPrice() {
        System.out.println("人工包装的水果价格为:" + (price + BaoZhuang));
    }

    public static void main(String[] args) {
        Fruit f = new Fruit(10);
        f.showPrice();
        PeopleFruit pf = new PeopleFruit(10,5);
        pf.showPrice();
    }

}
