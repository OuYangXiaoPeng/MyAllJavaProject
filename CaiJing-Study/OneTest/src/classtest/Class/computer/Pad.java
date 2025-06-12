package classtest.Class.computer;

public class Pad extends Computer {

    String barrery = "5000毫安电池";
    String screen;

    public Pad() {
        super();
        this.screen = super.screen;
    }

    void startUp() {
        System.out.println("Pad正在开机成功...请稍后...");
    }

    void pictureShow() {
        System.out.println("Pad正在打开图片中...请稍后...");
    }

    void open5G() {
        System.out.println("打开5G上网...");
    }
    String sayHello(){
        return super.sayHello()+"Pad";
    }

}
