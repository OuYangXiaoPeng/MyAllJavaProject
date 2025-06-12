package classtest.Class.Method;

public class staticD {
//    静态变量
    static double Pai = 3.1415;
//    静态方法
    public static void method(){
        System.out.println("这是一个静态方法");
    }

    public static void main(String[] args) {
        System.out.println(staticD.Pai);
        staticD.method();
    }
}
