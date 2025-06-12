package classtest.Class.craft;

public class Shop {
    public static void XianJin(double money) {
        System.out.println("现金金额:" + money);
    }

    public static void WeiXin(String weID, double money) {
        System.out.println("微信号:" + weID + "金额:" + money);
    }

    public static void BankCard(String bankName, int bankID, double money) {
        System.out.println("银行名称:" + bankName + ",银行卡号:" + bankID + ",金额:" + money);
    }

    public static void main(String[] args) {
        XianJin(200);
        WeiXin("123456", 150);
        BankCard("XX银行", 123456789, 300);
    }
}
