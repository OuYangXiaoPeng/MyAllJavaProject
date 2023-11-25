package DanLianBiao;
/*
单链表的测试类
创建单链表的对象
 */
public class TestLinkList {

    public static int pow(int a, int b) {
        if(b == 0){
            return 1;
        }
        if(b == 1){
            return a;
        }
        int temp = pow(a, b-1);
        return temp * a;
    }

    public static int f(int n){
        if(n == 0){
            return 1;
        }
        int temp = f(n-1);
        return temp * n;
    }

    public static int F(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 1;
        }
        int temp1 = F(n-1);
        int temp2 = F(n-2);
        return temp1 + temp2;
    }

    public static void main(String[] args) throws Exception {
//        1.创建单链表(初始化10个偶数结点_5个从表头插入，5个从表尾插入)
        LinkList list1 = new LinkList();//构造方法
        for (int i = 0; i < 5; i++) {
            list1.insert(0,2*(4-i));//表头插入要逆序
        }
        for (int i = 0; i < 5; i++) {
            list1.insert(list1.length(),2*(5+i));//表尾插入，要正序，插入位置等于当前表长
        }
//        2.输出单链表
        list1.display();

//        list1.clear();
//        list1.create1(5);
//        list1.create2(5);
//        list1.display();

//        3.输出链表的长度
        System.out.println("链表长度为："+list1.length());
//        4.取第3号结点的值--按序号查找
        System.out.println("3号结点的值为："+list1.get(3));

        try {
        System.out.println("-1号结点的值为："+list1.get(-1));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

//        5.按值查找是否存在值为4的结点，是否存在值为99的结点
        System.out.println("查找值为4的结点位置为："+list1.indexOf("4"));
        System.out.println("查找值为99的结点位置为："+list1.indexOf(99));

//        6.在位置4插入新结点77
        list1.insert(4,77);
        System.out.println("在4号位置插入77后：");
        list1.display();

        try{
        list1.insert(12,66);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            list1.insert(-1,66);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

//        7.删除表头、表尾和表中间位置的元素
        list1.remove(0);
        list1.remove(list1.length()-1);
        System.out.println("删除首尾元素后：");
        list1.display();
        list1.remove(5);
        System.out.println("删除5号位置的元素后：");
        list1.display();

//        list1.remove(4);
//        System.out.println("删除4号位置的值后：");
//        list1.display();

//        3.清空
        list1.clear();
//        4.判空
        System.out.println("进行清空后：");
        System.out.println("是否为空："+list1.isEmpty());

        System.out.println("2^4="+pow(2,4));
        System.out.println("4!="+f(4));
    }
}
