package classtest.Class.Father;

public class Son extends Father {
    String name = "儿子";

    private void play() {
        System.out.println("父类在私有方法去游玩");
    }

    public static void play02() {
        System.out.println("父类在静态方法去游玩");
    }

//    public final void play03() {
//        System.out.println("父类在常量方法去游玩");
//    }

    public void eat() {
        super.eat();
        System.out.println("儿子在吃肉");
    }

    public void drink() {
        System.out.println("儿子在喝可乐");
    }
    public void say(){
        System.out.println(super.name);
        System.out.println(name);
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.eat();
        son.drink();
        son.say();
    }
}
