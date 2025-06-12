package QiMoTest.One;

public class Demo01 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("请输入税前收入：");
        double income = scanner.nextDouble();
        double tax = 0;

        if (income > 5000) {
            double taxableIncome = income - 5000;
            if (taxableIncome > 20000) {
                tax += (taxableIncome - 20000) * 0.30;
                taxableIncome = 20000;
            }
            if (taxableIncome > 5000) {
                tax += (taxableIncome - 5000) * 0.20;
                taxableIncome = 5000;
            }
            if (taxableIncome > 1000) {
                tax += (taxableIncome - 1000) * 0.10;
                taxableIncome = 1000;
            }
            tax += taxableIncome * 0.05;
        }

        System.out.println("应交个人所得税金额为：" + tax + "元");
    }
}
