package classtest.Class.craft;

public class CountDemo {
    static int count = 0;
    String name;

    public CountDemo(String name) {
        this.name = name;
        count++;
    }

    public static void main(String[] args) {
        CountDemo demo1 = new CountDemo("张三");
        System.out.println("我是第"+CountDemo.count+"我的名字是:"+demo1.name);
        CountDemo demo2 = new CountDemo("李四");
        System.out.println("我是第"+CountDemo.count+"我的名字是:"+demo2.name);
    }
}
