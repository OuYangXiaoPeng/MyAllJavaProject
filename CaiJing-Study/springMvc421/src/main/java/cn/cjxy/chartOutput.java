package cn.cjxy;

public class chartOutput {

    public static void main(String[] args) {
        String s = "hello world!";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println(c + ":" + (int) c);
        }
    }

}
