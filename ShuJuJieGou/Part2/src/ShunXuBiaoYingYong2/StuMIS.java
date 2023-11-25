package ShunXuBiaoYingYong2;

/**
 * 学生管理科系统
 */
public class StuMIS {

    public static void main(String[] args) throws Exception {
        //1.创建学生成绩表
        StuScoreList slist = new StuScoreList();

        //2.显示表格
        slist.display();

        //3.创建两个学生成绩对象，插入到尾部，显示
        StuRecord s1 = new StuRecord("005", "张三\t", 98);
        StuRecord s2 = new StuRecord("006", "李四\t", 96);
        slist.insert(s1);
        slist.insert(s2);
        slist.display();

        //4.获取学号为003的学生记录，显示
        StuRecord s = slist.get("003");
        if (s != null)
            System.out.println("学号为003的学生信息：\n" + s);
        else
            System.out.println("学号为003的学生不存在");

        //5.查找学号为005的学生记录，显示
        int result = slist.indexOf("005");
        if (result != -1)
            System.out.println("学号为005的学生信息为：\n" + slist.get(result));
        else
            System.out.println("学号为005的学生不存在");

        //6.删除学号为002的学生记录
        System.out.println("删除002后：");
        slist.remove("002");
        //7.删除学号为019的学生记录，显示
        try {
            slist.remove("019");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        slist.display();
    }
}
