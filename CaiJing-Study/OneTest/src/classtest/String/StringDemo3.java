package classtest.String;

public class StringDemo3 {
    public static void main(String[] args) {
        System.out.println("字符常量串:");
        String str = "Hello World";
        String str2 = "Hello World";
        System.out.println("str==str2: " + (str == str2));
        System.out.println("str.equals(str2): " + str.equals(str2));

        System.out.println();
        System.out.println("字符String类:");
        String st = new String("Hello World");
        String st2 = new String("Hello World");
        System.out.println("st==st2: " + (st == st2));
        System.out.println("st.equals(st2): " + st.equals(st2));


    }
}
