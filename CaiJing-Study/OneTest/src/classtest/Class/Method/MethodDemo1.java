package classtest.Class.Method;

public class MethodDemo1 {
    //无参无返回值
    public static void love01() {
        System.out.println("我爱重庆");
    }

    //有参数无返回值
    public static void love02(String name, String address) {
        System.out.println(name + "爱" + address);
    }

    //无参有返回值
    public static String love03() {
        return "重庆财经学院";
    }

    //有参数有返回值
    public static long square(long a) {
        return a * a;
    }

    public static long plus(long a, long b) {
        return square(a) + square(b);
    }

    public static void main(String[] args) {
        love01();
        love02("张三", "重庆");
        System.out.println(love03());
        System.out.println(square(8));
        System.out.println(plus(5, 12));
    }

}
