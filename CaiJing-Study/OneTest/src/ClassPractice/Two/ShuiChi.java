package ClassPractice.Two;

public class ShuiChi {

    static double water = 0;

    static void input() {
        water += 3;
    }

    static void output() {
        water -= 2;
    }

    public static void main(String[] args) {
        System.out.println("水池没注水的水量:"+ShuiChi.water);
        ShuiChi.input();
        System.out.println("水池加一次水的水量:"+ShuiChi.water);
        ShuiChi.output();
        System.out.println("水池减少一次水的水量:"+ShuiChi.water);
    }
}
