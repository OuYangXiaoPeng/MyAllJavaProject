package classtest.Abstract.Police;

public class CriPolice extends Police {
    String major;

    public CriPolice(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    public void work() {
        System.out.println(this.name + "擅长" + this.major + "正在抓捕嫌疑人");
    }
}
