package Work.ThreeWork.Triangle;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入3条边长:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        Triangle triangle = new Triangle(a, b, c);
        System.out.println("请输入查询次数:");
        int n = sc.nextInt();
        switch (n) {
            case 1:
                System.out.println("周长为:" + triangle.getZhouChang());
                break;
            case 2:
                System.out.println("周长为:" + triangle.getZhouChang());
                System.out.println("它" + triangle.isDengYao());
                break;
            case 3:
                System.out.println("周长为:" + triangle.getZhouChang());
                System.out.println("它" + triangle.isDengYao());
                System.out.println("其中它最长的边长是:" + triangle.maxBian());
                break;
        }
    }
}
