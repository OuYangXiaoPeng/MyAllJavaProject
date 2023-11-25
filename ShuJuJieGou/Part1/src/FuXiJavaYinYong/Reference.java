package FuXiJavaYinYong;
//理解java的基本数据类型和引用数据类型的区别
//基本数据类型--8种 变量保存的就是数值
//引用数据类型--2种：数组名变量、类的对象（实例）变量，保存的是一个地址

class A {
    int data;

    public A(int data) {
        this.data = data;
    }
}

public class Reference {

    public static void main(String[] args) {
        //定义几个基本类型，输出
        int a = 10;
        double b = 9.8;
        char c = 'k';

        System.out.println(a + " " + b + " " + c);

        //定义两个引用类型,输出
        int[] num = {1, 2, 3};//num数组名变量，就是引用类型，保存的就是数值元素第一个单元的地址
        A aa = new A(67);//创建了类A的对象aa，保存了对象在内存中的地址
        System.out.println(num);
        System.out.println(aa);

        System.out.println(num[1]);//输出数组元素--整型
        System.out.println(aa.data);//输出对象的成员变量的值

        //对于引用变量（指针），只能靠【下标】或成员变量名 来取得内存地址的值

    }

}
