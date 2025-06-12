package classtest.Class.Final;

public class FinalDemo1 {
    static final double PI = 3.1415926;

    public static void main(String[] args) {
        System.out.println("PI = " + PI);
//        1.final修饰变量变为常量，不可再次被编辑
//        PI = 3.1415;
        Boss b = new Boss();
        b.pay();
        A a = new A();
//        B b1 = new B();

    }
}

class Boss {
    final void pay() {
        int money = 5000;
        System.out.println("向工人支付了" + money + "工资");
    }
}

class Emp extends Boss {
//    void pay(){
////        2.由于父类Boss中pay()方法被final修饰了，子类中无法再次重写该方法
//    }
}

//使用final修饰类
final class A{
    public A(){
        System.out.println("这是A的构造方法.");
    }
}

//由于A类用了final修饰，所以继承不了A类
//class B extends A{
//    public B(){
//        System.out.println("这是B的构造方法.");
//    }
//}