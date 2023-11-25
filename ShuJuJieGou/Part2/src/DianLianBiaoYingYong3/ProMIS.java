package DianLianBiaoYingYong3;

public class ProMIS{

    public static void main(String[] args) throws Exception{
        //创建表
        ProPriceList list = new ProPriceList();
        
        //插入
        ProRecord s1 = new ProRecord("1001", "华为手机", 3800,50);
        ProRecord s2 = new ProRecord("1002", "苹果电脑", 4900,18);
        ProRecord s3 = new ProRecord("1003", "Sorry电视", 1900,7);
        ProRecord s4 = new ProRecord("1004", "联想电脑", 6800,8);
        list.insert(s1);
        list.insert(s2);
        list.insert(s3);
        list.insert(s4);
        list.display();

        //获取商品代码为1002的商品记录，显示
        ProRecord p = list.get("1002");
        if (p != null)
            System.out.println("商品代码为1002的商品信息：\n" + p);
        else
            System.out.println("商品代码为1002的商品不存在");

        //查找华为手机记录的商品信息，显示
        ProRecord p2 = list.indexOf2("华为手机");
        if (p2 != null)
            System.out.println("华为手机的商品信息：\n" + p2);
        else
            System.out.println("华为手机不存在");

        //删除商品代码为1003的商品记录
        System.out.println("删除1003");
        list.remove("1003");

        //7.删除商品代码为1010的商品记录，显示
        try {
            list.remove("1010");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        list.display();
    }
}
