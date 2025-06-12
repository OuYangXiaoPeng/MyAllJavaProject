package classtest.Class.craft;

import java.util.Scanner;

public class cash {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入所购商品的单价：");
        double price = sc.nextDouble();
        System.out.println("请输入所购商品的数量：");
        int num = sc.nextInt();
        System.out.println("账户金额：");
        double money = sc.nextDouble();//待支付金额
        double total = price * num;
//        if(total >= 300){
//            total = (int)(total * 0.88);
//        }
        if (total >= 299) {
            total = (int) (total - (int) (total / 299) * 50);
        }
        if (money > total) {
            System.out.println("找零：" + (money - total));
        } else if (money == total) {
            System.out.println("金额正好，不用找零");
        } else {
            System.out.println("余额不足，请补付：" + (total - money));
        }

    }
}
