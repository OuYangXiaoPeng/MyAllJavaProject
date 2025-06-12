package classtest.Class.Bird;

public class Test {
    public static void main(String[] args) {
        Bird bird = new Bird("亮亮", 2, "蓝色");
        bird.show();
        Bird p = new Pigeon("鸽子", 3, "白色", 20);
        p.show();
        Pigeon p1 = new Pigeon("鸽子", 3, "白色", 20);
        p1.fly();
    }
}
