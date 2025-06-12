package ClassPractice.Two;

public class KFC {

    int iceCount = 0;

    public KFC(int iceCount) {
        this.iceCount = iceCount;
    }

    public static void main(String[] args) {
        KFC kfc = new KFC(3);
        System.out.println("张三的可乐里面有" + kfc.iceCount + "块冰");
    }
}
