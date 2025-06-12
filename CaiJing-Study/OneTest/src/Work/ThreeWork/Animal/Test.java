package Work.ThreeWork.Animal;

import java.util.Scanner;

class Cat extends Animal {

    public String getYell() {
        return "喵喵";
    }
}

class Dog extends Animal {
    public String getYell() {
        return "汪汪";
    }
}

class Duck extends Animal {
    public String getYell() {
        return "嘎嘎";
    }
}

class Chicken extends Animal {
    public String getYell() {
        return "咯咯";
    }
}

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入动物(0结束):");
        Animal animal;
        while (true) {
            String animalName = sc.next();
            if (!animalName.equals("0")) {
                switch (animalName) {
                    case "猫":
                        animal = new Cat();
                        break;
                    case "狗":
                        animal = new Dog();
                        break;
                    case "鸭":
                        animal = new Duck();
                        break;
                    case "鸡":
                        animal = new Chicken();
                        break;
                    default:
                        animal = new Animal();
                        break;
                }
                System.out.println(animalName + " : " + animal.getYell());
            } else
                break;
        }
    }
}
