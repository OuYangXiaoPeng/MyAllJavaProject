package classtest.String;

public class StringDemo1 {
    public static void main(String[] args) {
//        1.引用数据类型（常量串）
        String str1 = "Hello, World!";
        System.out.println("字符串:" + str1);
        System.out.println(System.identityHashCode(str1));

//        2.用String类来创造对象
        String str2 = new String("Java");
        System.out.println("String类:" + str2);
        System.out.println(System.identityHashCode(str2));

//        3.利用char数组的方法进行构造
        char[] charArray = {'J', 'a', 'v', 'a'};
        String str3 = new String(charArray);
        System.out.println("char数组:" + str3);

        char[] charArray2 = {'你', '好', '世', '界'};
        String str4 = new String(charArray2,2,2);
        System.out.println("char数组起始位置改变:" + str4);

    }
}
