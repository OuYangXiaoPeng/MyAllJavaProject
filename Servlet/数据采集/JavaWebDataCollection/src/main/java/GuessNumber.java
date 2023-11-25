import java.util.Scanner;
import java.util.Random;

public class GuessNumber {
    public static void main(String[] args) {
        // 创建一个Scanner对象用于接收用户的输入
        Scanner input = new Scanner(System.in);
        // 创建一个Random对象用于生成随机数
        Random random = new Random();
        // 生成一个1到100之间的随机整数作为答案
        int answer = random.nextInt(100) + 1;
        // 定义一个变量用于记录用户的尝试次数
        int count = 0;
        // 定义一个布尔变量用于判断用户是否赢了
        boolean win = false;

        // 输出欢迎信息和游戏规则
        System.out.println("欢迎来到猜数字游戏！");
        System.out.println("计算机已经随机生成了一个1到100之间的整数，你有10次机会来猜它是多少。");

        // 开始循环，直到用户赢了或者尝试次数用完为止
        while (!win && count < 10) {
            // 提示用户输入自己的猜测，并接收输入
            System.out.print("请输入你的猜测（1-100）：");
            int guess = input.nextInt();
            // 增加尝试次数
            count++;

            // 判断用户的猜测是否正确
            if (guess == answer) {
                // 如果正确，输出恭喜信息，并将win设为true，结束循环
                System.out.println("恭喜你！你在第" + count + "次就猜对了！");
                win = true;
            } else if (guess > answer) {
                // 如果太大，输出提示信息，并告诉用户剩余的尝试次数
                System.out.println("你猜大了！");
                System.out.println("你还有" + (10 - count) + "次机会。");
            } else {
                // 如果太小，输出提示信息，并告诉用户剩余的尝试次数
                System.out.println("你猜小了！");
                System.out.println("你还有" + (10 - count) + "次机会。");
            }

            // 输出一条空行作为分隔符
            System.out.println();

        }

        // 判断循环结束后是否赢了
        if (!win) {
            // 如果没有赢，输出遗憾信息，并告诉用户正确答案
            System.out.println("很遗憾！你没有在10次之内猜对！");
            System.out.println("正确答案是：" + answer);
        }

    }
}