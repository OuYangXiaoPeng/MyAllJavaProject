package classtest.Abstract.Police;

public class TraPolice extends Police{

    public TraPolice(String name, int age) {
        super(name, age);
    }

    @Override
    public void work() {
        System.out.println(this.name+"正在路上巡逻");
    }
}
