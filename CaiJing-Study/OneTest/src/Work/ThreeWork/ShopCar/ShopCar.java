package Work.ThreeWork.ShopCar;

import java.util.Scanner;

public class ShopCar {
    double price = 580;

    public void pay() {
        System.out.println("购买数量1应付款:" + price+"元");
    }

    public void pay(int num) {
        double newPrice = price * num * 0.8;
        System.out.println("购买数量" + num + "应付款:" + newPrice+"元");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShopCar shopCar = new ShopCar();

        System.out.println("请输入购买的数量:");
        int num = sc.nextInt();
        if (num < 2)
            shopCar.pay();
        else
            shopCar.pay(num);

    }
}
