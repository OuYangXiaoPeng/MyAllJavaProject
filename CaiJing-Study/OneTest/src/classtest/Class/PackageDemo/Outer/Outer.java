package classtest.Class.PackageDemo.Outer;

public class Outer {
    int num = 100;
    private String hobby;

    public Outer() {
    }

    public Outer(String hobby) {
        this.hobby = hobby;
    }


    public class Inner {
        private String name;
        private int age;

        public Inner() {
        }

        public Inner(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void show() {
            System.out.println("姓名:" + name + "\n年龄:" + age);

//            Outer outer = new Outer("篮球");
            hobby = "篮球";
            System.out.println("Outer中的hobby:" + hobby);
        }
    }


}
