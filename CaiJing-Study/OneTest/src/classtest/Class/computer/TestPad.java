package classtest.Class.computer;

public class TestPad {
    public static void main(String[] args) {
        Computer c = new Computer();
        System.out.println(c.sayHello());
        Pad p = new Pad();
        p.startUp();
        p.pictureShow();
        p.open5G();
        System.out.println(p.sayHello());
        System.out.println(p.barrery);
        System.out.println(p.screen);
    }
}
