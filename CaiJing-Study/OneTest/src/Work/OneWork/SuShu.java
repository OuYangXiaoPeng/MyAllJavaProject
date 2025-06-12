package Work.OneWork;

public class SuShu {
    public static void main(String[] args) {
        int n = 100;
        int num = 0;
        for (int i = 2; i <= n; i++) { // 从2到n遍历每个数
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) { // 如果能整除，i不是素数
                    flag = false;
                    break;
                }
            }
            if (flag) {
                num++;
                System.out.println(i); // 输出素数
            }
        }
        System.out.println("素数的个数为：" + num);
    }
}
