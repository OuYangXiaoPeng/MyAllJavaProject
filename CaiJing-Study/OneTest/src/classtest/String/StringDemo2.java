package classtest.String;

public class StringDemo2 {
    public static void main(String[] args) {
        String str = "  Hello, Java World!  ";

        // 1. 查找
        int index = str.indexOf("Java");
        System.out.println("字符串 'Java' 的位置: " + index);

        // 2. 字符串拼接
        String str2 = "It's amazing!";
        String result = str.concat(str2);
        System.out.println("拼接后的字符串: " + result);

        // 3. 获取字符串长度
        int length = str.length();
        System.out.println("字符串的长度: " + length);

        // 4. 获取指定索引位置的字符
        char ch = str.charAt(6);
        System.out.println("索引6处的字符: " + ch);

        // 5. 获取子字符串
        String substring = str.substring(3, 8);
        System.out.println("子字符串(索引3到8): " + substring);

        //6.去除空格
        String space = str.replace(" ", "");
        System.out.println("去除空格: " + space);

        //7.字符串替换
        String replace = str.replace("Java", "Python");
        System.out.println("替换字符串: " + replace);

        //8.判断字符串的开始与结尾
        boolean start = str.startsWith("  Hello");
        boolean end = str.endsWith("World!  ");
        System.out.println("str是否以 '  Hello' 开始: " + start);
        System.out.println("str是否以 'World!  ' 结尾: " + end);

    }
}
