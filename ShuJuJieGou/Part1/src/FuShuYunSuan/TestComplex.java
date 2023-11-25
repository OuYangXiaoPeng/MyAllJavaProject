package FuShuYunSuan;

//测试类
//创建新的数据结构（构造方法）
//把新的数据结构作为工具类来使用
public class TestComplex {

    public static void main(String[] args) {
        Complex z1 = new Complex(3, 2);
        Complex z2 = new Complex(5, 4);
        Complex z3;


        System.out.println("z1, z2:");
        System.out.print("z1 = ");
        System.out.println(z1);
        System.out.print("z2 = ");
        System.out.println(z2);
        System.out.println();

        z3 = z1.add(z2);
        System.out.print("z1 + z2 = ");
        System.out.println(z3);

        z3 = z1.minus(z2);
        System.out.print("z1 - z2 = ");
        System.out.println(z3);


        z3 = z1.multiply(z2);
        System.out.print("z1 * z2 = ");
        System.out.println(z3);


        z3 = z1.divide(z2);
        System.out.print("z1 / z2 = ");
        System.out.println(z3);
    }
}
