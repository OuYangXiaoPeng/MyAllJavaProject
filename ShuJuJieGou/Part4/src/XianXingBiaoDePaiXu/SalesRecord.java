package XianXingBiaoDePaiXu;

/**
 * 商品销售记录类--自定义变量
 */
public class SalesRecord implements Comparable {
    //成员变量4个--书名、书号、销售、单价
    int id;
    String name;
    int num;
    int price;

    //构造方2个
    public SalesRecord() {
    }

    public SalesRecord(int id, String name, int num, int price) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
        //将参数对象强转为SaleRecord对象
        SalesRecord s = (SalesRecord) o;
        //通过销量的差来表示两个对象的关系
        return this.price - s.price;
    }
}
