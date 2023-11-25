package FanXing2;
//Compareble接口表示泛类，主要用于需要比较的类型
//int compareTo(Object o)方法
//比较>,<或=0的情况
//8种包装类和String字符串类等等
//自定义学生类

class Student implements Comparable{
    int stuNo;
    String Name;
    int score;

    public Student(){}

    public Student(int stuNo,String Name,int score){
        this.Name = Name;
        this.stuNo = stuNo;
        this.score = score;
    }

    public int compareTo(Object o) {
        Student s = (Student) o;
        return (this.stuNo-s.stuNo);
    }
}

public class FindMax {
//泛型的求最大值的方法
    public static Comparable findMax(Comparable[] a){
        Comparable max = a[0];
        for (int i = 1; i < a.length; i++) {
            if(max.compareTo(a[i])<0)
                max = a[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Integer [] a= {23,98,65,79,10};
        String [] b = {"Tom","Jack","Alice"};
        Student [] c = {new Student(1,"张三",86),
                new Student(2,"李四",91),
                new Student(3,"王五",56)};

        System.out.println(findMax(a));
        System.out.println(findMax(b));
        Student s = (Student) findMax(c);
        System.out.println(s.Name);
    }
}
