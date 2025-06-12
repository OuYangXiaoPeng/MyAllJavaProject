package Work.OneWork;

public class XiBao {
    public static void main(String[] args) {
        int cell = 1;
        int num = 10;
        for (int i = 1; i < num; i++) {
            cell = cell * 2;
        }
        System.out.println("第" + num + "代菌落中的细菌数量:" + cell + "个。");
    }

}
