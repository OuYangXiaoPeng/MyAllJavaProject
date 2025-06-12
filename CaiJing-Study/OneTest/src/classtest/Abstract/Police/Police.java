package classtest.Abstract.Police;

public abstract class Police {
    String name;
    int age;

    public Police(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    普通方法
    public void show() {
        System.out.println("我是警察" + this.name + "，今年" + this.age + "岁");
    }

//    抽象方法
    public abstract void work();

}
