package craft.Mark;

public class TestProduct {

    public static void main(String[] args) {
        Product p1 = new Product("001","笔记本",12,40);
        Product p2 = new Product("002","铅  笔",3,120);
        Product p3 = new Product("003","橡皮擦",2,150);
        Product p4 = new Product("004","书  包",128,26);

        Product [] product = new Product[100];

        int curLen = 0;

        product[0] = p1;
        curLen++;
        product[1] = p2;
        curLen++;
        product[2] = p3;
        curLen++;
        product[3] = p4;
        curLen++;

        System.out.println("商品编号\t名称\t\t\t价格\t\t数量");
        for (int i = 0; i < curLen; i++) {
            System.out.println(product[i].No+"\t\t"+product[i].Name+
                    "\t\t"+product[i].price+"\t\t"+product[i].num);
        }

    }

}
