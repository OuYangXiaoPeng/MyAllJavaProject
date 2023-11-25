package XianXingBiaoDePaiXu;

/**
 * 销售记录表类
 */
public class SalesList {
    //销售记录对象数组的排序算法
    public static void sort(SalesRecord[] r) {
        for (int i = 0; i < r.length - 1; i++) {
            for (int j = 0; j < r.length - 1; j++) {
                if (r[j].compareTo(r[j + 1]) > 0) {
                    SalesRecord temp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = temp;
                }
            }
        }
    }

    //表格显示
    public static void display(SalesRecord[] r){
        System.out.println("书号\t书名\t销量\t单价");
        System.out.println("-----------------------------------");
        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i].id+"\t"+r[i].name+"\t"+r[i].num+"\t"+r[i].price);
        }
    }

    public static void main(String[] args) {
        //1、创建图书销售记录表，初始化8条销售记录
        SalesRecord[] sales=new SalesRecord[8];
        sales[0]=new SalesRecord(101,"C语言编程",112,33);
        sales[1]=new SalesRecord(103,"微机原理",156,46);
        sales[2]=new SalesRecord(102,"高等数学",287,36);
        sales[3]=new SalesRecord(105,"Java编程",343,40);
        sales[4]=new SalesRecord(108,"数据结构",331,25);
        sales[5]=new SalesRecord(104,"机械制图",289,42);
        sales[6]=new SalesRecord(107,"电子商务",223,30);
        sales[7]=new SalesRecord(106,"专业英语",118,37);
        //2、显示排序前的表格
        System.out.println("排序前：");
        display(sales);
        //3、排序
        sort(sales);
        //4、显示排序后的表格
        System.out.println("按单价排序后：");
        display(sales);

    }
}
