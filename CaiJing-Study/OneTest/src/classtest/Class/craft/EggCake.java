package classtest.Class.craft;

public class EggCake {
    //    成员变量
    int eggCount;

    public EggCake(){
        this(1);
    }
    public EggCake(int eggCount) {
        this.eggCount = eggCount;
    }

    public static void main(String[] args) {
        EggCake cake1 = new EggCake();
        System.out.println("饼里有" + cake1.eggCount + "个蛋");
        EggCake cake2 = new EggCake(5);
        System.out.println("饼里有" + cake2.eggCount + "个蛋");
    }
}
