package Work.FourWork.Animal;

public class Test {
    public static void main(String[] args) {
        Animal a1 = new Animal("动物");
        Animal a2 = new Tiger("老虎", 2);
        Animal a3 = new Dog("狗子", "黄色");
        a1.getMessage();
        a2.getMessage();
        a3.getMessage();
    }
}
