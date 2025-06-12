package Work.OneWork;

public class LingXing {
    public static void main(String[] args) {
        int n = 8; // 菱形的上层数

        // 上半部分
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print("  "); // 打印空格
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("* "); // 打印星号
            }
            System.out.println(); // 换行
        }

        // 下半部分
        for (int i = n - 1; i >= 1; i--) {
            for (int j = n; j > i; j--) {
                System.out.print("  "); // 打印空格
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("* "); // 打印星号
            }
            System.out.println(); // 换行
        }
    }
}

