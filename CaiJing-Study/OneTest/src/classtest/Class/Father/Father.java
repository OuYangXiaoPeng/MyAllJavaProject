package classtest.Class.Father;

public class Father {
    String name = "父亲";


    public void eat() {
        System.out.println("父亲在吃饭");
    }

    public void drink() {
        System.out.println("父亲在喝水");
    }

//    以下4个方法不能重写
    public Father() {
        System.out.println("这是一个父类方法");
    }

    private void play() {
        System.out.println("父类在私有方法去游玩");
    }

    public static void play02() {
        System.out.println("父类在静态方法去游玩");
    }

    public final void play03() {
        System.out.println("父类在常量方法去游玩");
    }
}
