package DanLianBiaoYingYong;

/**
 * 学生管理科系统
 */
public class StuMIS {

    public static void main(String[] args) throws Exception {
        //1.创建学生成绩表
        StuScoreList slist = new StuScoreList();
        //2.显示表格
        slist.display();
    }
}
