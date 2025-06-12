package ClassPractice.Three;

public class Ticket {
    double price = 40;
    String name;
    int age;
    String sex;

    public Ticket() {
    }

    public Ticket(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void buyTicket() {

        System.out.println(name + "\t" + age + "\t" + sex + "\t" + price);
    }

    public void buyTicket2() {
        System.out.println(name + "\t" + age + "\t" + sex + "\t" + price / 2);
    }

    public static void main(String[] args) {
        Ticket[] p = new Ticket[4];
        p[0] = new Ticket("李思思", 20, "女");
        p[1] = new Ticket("张三 ", 16, "男");
        p[2] = new Ticket("王五 ", 8, "男");
        p[3] = new Ticket("吴刚 ", 40, "男");
        System.out.println("姓名\t\t年龄\t性别\t票价");
        System.out.println("-------------------------------");
        for (int i = 0; i < p.length; i++){
            if(p[i].age>=18){
                p[i].buyTicket();
            }else {
                p[i].buyTicket2();
            }
        }

    }
}
