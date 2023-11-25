package DianLianBiaoYingYong3;

public class ProRecord {
    String proNo;
    String name;
    int price;
    int  stock;

    public  ProRecord() {
        this.proNo = null;
        this.name = null;
        this.price = 0;
        this.stock = 0;
    }

    public  ProRecord(String proNo, String name, int price,int stock) {
        this.proNo = proNo;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        ProRecord p = (ProRecord) o;
        return this.proNo.equals(p.proNo);
    }

    @Override
    public String toString() {
        return this.proNo + "\t" + this.name + "\t" + this.price +"\t"+this.stock+ "\n";
    }
}
