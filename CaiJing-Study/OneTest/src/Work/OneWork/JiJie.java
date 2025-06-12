package Work.OneWork;

import java.util.Scanner;

public class JiJie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a:while (true) {
            System.out.println("判断月份季节请输入一个月份:(输入0停止)");
            int num = sc.nextInt();
            switch (num) {
                case 0:
                    System.out.println("程序结束");
                    break a;
                case 12:
                case 1:
                case 2:
                    System.out.println("冬季");
                    break;
                case 3:
                case 4:
                case 5:
                    System.out.println("春季");
                    break;
                case 6:
                case 7:
                case 8:
                    System.out.println("夏季");
                    break;
                case 9:
                case 10:
                case 11:
                    System.out.println("秋季");
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }
    }
}
