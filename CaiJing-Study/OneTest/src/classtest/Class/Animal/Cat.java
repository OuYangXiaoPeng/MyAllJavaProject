package classtest.Class.Animal;

public class Cat {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.name = "小白";
        animal.age = 5;
        animal.setColor("白色");
        animal.show();
        animal.eat();

        Animal animal2 = new Animal();
        animal2.age = 2;
        animal2.name = "小老虎";
        animal2.setColor("黄白相间");
        animal2.show();
        animal2.eat();
    }
}
