package ClassPractice.Three.People;

public class TestP {
    public static void main(String[] args) {
        People p = new People("小明");
        People d = new Doctor("小红", "外科");
        People s = new Student("小亮", 18);
        p.show();
        d.show();
        s.show();
    }
}
