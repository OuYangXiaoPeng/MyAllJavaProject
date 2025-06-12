package ClassPractice.Three.People;

public class Doctor extends People {
    String major;

    public Doctor(String name, String major) {
        super(name);
        this.major = major;
    }

    public void show() {
        System.out.println("名字是:" + name + ",专业:" + major);
    }
}
