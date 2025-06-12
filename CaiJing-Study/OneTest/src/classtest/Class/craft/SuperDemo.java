package classtest.Class.craft;

class A {
    A() {
        System.out.println("这是父类A的构造方法");
    }
}

class B extends A{
    B() {
        System.out.println("这是子类B的构造方法");
    }
}

class C extends B{
    C() {
        System.out.println("这是子类C的构造方法");
    }
}

public class SuperDemo {
    public static void main(String[] args) {
        A b = new B();
        System.out.println("----------------------------");
        A c = new C();
    }
}
