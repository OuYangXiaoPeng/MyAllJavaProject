package FanXin1;

//Object表示泛型
//原理：因为object是所有引用类型的父类，
//具有很好的类型适应能力
//另外，对于8种基本类型，不能看成object类，但其对应的包装类可以看做object类

//自定义的学生类
class Student{
    String stuNo;

    public Student(){}
    public Student(String stuNo){
        this.stuNo = stuNo;
    }
}

public class Swap {

    //带泛型参数的swap方法
    public static void swap(Object[] a){
        Object temp = a[0];
        a[0] = a[1];
        a[1] = temp;
    }

    public static void main(String[] args) {
        //用同一个swap方法来交换
        Student [] a = {new Student("001"),new Student("002")};
        System.out.println(a[0].stuNo+" "+a[1].stuNo);
        swap(a);
        System.out.println(a[0].stuNo+" "+a[1].stuNo);

        String [] b = {"java","python"};
        System.out.println(b[0]+" "+b[1]);
        swap(b);
        System.out.println(b[0]+" "+b[1]);

        Integer [] c ={Integer.valueOf(88),Integer.valueOf(99)};
        System.out.println(c[0]+" "+c[1]);
        swap(c);
        System.out.println(c[0]+" "+c[1]);

        int [] d ={66,77};
        Integer[] e={Integer.valueOf(d[0]),Integer.valueOf(d[1])};
        System.out.println(e[0]+" "+e[1]);
        swap(e);
        System.out.println(e[0]+" "+e[1]);


        char [] c1 = {'a','b'};
        Character[] c2 = {Character.valueOf(c1[0]),Character.valueOf(c1[1])};
        System.out.println(c2[0]+" "+c2[1]);
        swap(c2);
        System.out.println(c2[0]+" "+c2[1]);

        double [] d1 = {12.1,11.2};
        Double[] d2 = {Double.valueOf(d1[0]),Double.valueOf(d1[1])};
        System.out.println(d2[0]+" "+d2[1]);
        swap(d2);
        System.out.println(d2[0]+" "+d2[1]);
    }
}
