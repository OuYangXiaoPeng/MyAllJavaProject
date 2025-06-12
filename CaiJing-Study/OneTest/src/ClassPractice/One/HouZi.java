package ClassPractice.One;

import java.util.Scanner;

public class HouZi {
    // 递归方法，根据天数计算当天的桃子数量
    public static int peachNum(int day) {
        if (day == 10) {
            return 1;
        }
        // 根据公式：
        else {
            return 2 * (peachNum(day + 1) + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入查询的天数(1-10): ");
        while (true){
            int n = scanner.nextInt();
            if (n < 1 || n > 10) {
                System.out.println("输入有误，请重新输入！");
            } else {
                System.out.println("第 " + n + " 天有 " + peachNum(n) + " 个桃子");
                break;
            }
        }
       

    }
}
