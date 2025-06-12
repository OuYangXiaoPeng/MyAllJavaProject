package QiMoTest.Two;

public class CirPolice extends Police {
    String major;

    public CirPolice(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    @Override
    public void work() {
        System.out.println(name + "擅长" + major + "，正在抓捕犯罪嫌疑人。");
    }

    public static void main(String[] args) {
        Police p1 = new CirPolice("吴永强", 39, "擒拿格斗");
        p1.show();
        p1.work();
    }
}
