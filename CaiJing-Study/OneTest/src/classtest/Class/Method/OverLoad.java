package classtest.Class.Method;

public class OverLoad {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static int add(int... a) {
//        return 0;
        int num = 0;
        for (int i = 0; i < a.length; i++) {
            num += a[i];
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println("调用add(int a, int b):" + add(4, 5));
        System.out.println("调用add(int a, int b,int c):" + add(4, 5, 6));
        System.out.println("调用add(double a, double b):" + add(4.5, 5.5));
        System.out.println("调用不定长参数add(int ...a):" + add(4, 5, 6, 7, 8, 9));
    }
}
