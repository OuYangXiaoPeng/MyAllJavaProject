package classtest.Class.PackageDemo.Outer;

public class Test{
    public static void main(String[] args) {
        Outer.Inner in = new Outer().new Inner("张三", 18);
        in.show();
    }
}
