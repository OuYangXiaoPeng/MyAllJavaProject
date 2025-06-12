package QiMoTest.Two;

public abstract class Police {
    String name;
    int age;

    public Police(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("我是警察" + name + ", 今年" + age + "岁了。");
    }

    public abstract void work();
}
