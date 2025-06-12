package classtest.Class.PackageDemo;


import classtest.Class.Animal.Animal;

public class PackageDemo {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.setColor("黄色");
        System.out.println(animal.getColor());
    }
}
