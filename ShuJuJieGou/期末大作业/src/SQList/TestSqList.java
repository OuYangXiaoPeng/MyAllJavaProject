package SQList;

//顺序表测试
public class TestSqList {

    public static void main(String[] args) throws Exception {
        System.out.println("(由于为了方便学生成绩管理系统的的输出，\n顺序表的输出中没有空格了！！！)");
//        1.创建一个容量为10的顺序表
        int x = 100;
        SqList list1 = new SqList(x);

//        2.初始化5个元素为1,2,4,6,8
//        for (int i = 0; i < 5; i++) {
//            list1.listElem[i] = 2 * i;
//            list1.curLen = 5;
//        }
        for (int i = 0; i < 5; i++) {
           list1.insert(0,2*i);//从表头插入
        }
        for (int i = 0; i < 5; i++) {
            list1.insert(list1.length(),2*i);//从表尾插入
        }

//        3.输出表
        list1.display();

//        4.输出表长
        System.out.println("表长为:" + list1.length());

//        5.取第二号元素的值
        System.out.println("第二号元素的值为：" + list1.get(2));

//        6.在位置7插入元素99
        list1.insert(7, 99);
        list1.display();

//       7.删除表首元素和表尾元素
        list1.remove(0);
        list1.remove(list1.length() - 1);
        list1.display();

//       8.删除位置2的元素
        list1.remove(2);
        list1.display();

//        9.查找元素
        int result;
        result = list1.indexOf(99);
        System.out.println("99所在的位置："+result);
        result = list1.indexOf(88);
        System.out.println("88所在的位置："+result);

//        6.清空表
        list1.clear();

//        7.判空表
        System.out.println("是否为空:"+ list1.isEmpty());
    }
}
