package classtest.Abstract.Animal;

//匿名内部类
//    匿名内部类服务的是 普通类/抽象类/接口
    /*
    语法是:
        new 普通类/抽象类/接口(){
            抽象方法实现
        };
     */
public abstract class Animal {
    public abstract void eat();

    public static void main(String[] args) {
        new Animal() {
            String name = "张三";

            public void eat() {
                System.out.println(name + "吃饭ing!");
            }
        }.eat();
    }
}
//继承抽象类，并重写抽象方法
//Animal animal = new Animal();
//animal.eat();
