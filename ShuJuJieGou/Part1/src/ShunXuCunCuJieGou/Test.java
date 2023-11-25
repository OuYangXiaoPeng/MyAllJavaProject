package ShunXuCunCuJieGou;

//顺序存储结构的实现
public class Test {

    public static void main(String[] args) {
        //创建4个学生成绩记录对象
        StuRecord stu1 = new StuRecord("001", "张三", 90);
        StuRecord stu2 = new StuRecord("002", "李四", 90);
        StuRecord stu3 = new StuRecord("003", "王五", 90);
        StuRecord stu4 = new StuRecord("004", "赵六", 90);
        StuRecord stu5 = new StuRecord("007", "陈七", 90);

        //创建一个长度为100的对象数组，顺序存储逻辑相邻的元素
        StuRecord[] records = new StuRecord[100];

        //表为空，当前长度变量设置为0
        int curLen = 0;

        //按逻辑顺序，存储4个元素到数组相邻单元
        records[0] = stu1;
        curLen++;
        records[1] = stu2;
        curLen++;
        records[2] = stu3;
        curLen++;
        records[3] = stu4;
        curLen++;

        //按照表格形式输出学生成绩表
        //输出表的标题
        System.out.println("------学生成绩表------");
        System.out.println("学号\t姓名\t成绩");
        System.out.println("--------------------");
        //输出表的内容
        for (int i = 0; i < curLen; i++) {
            System.out.println(records[i].stuNo +
                    "\t" + records[i].Name + "\t" + records[i].score);
        }


        records[3] = stu5;
        records[4] = stu4;
        curLen++;
        System.out.println();
        System.out.println("插入赵七的信息：");
        System.out.println("------学生成绩表------");
        System.out.println("学号\t姓名\t成绩");
        System.out.println("--------------------");
        //输出表的内容
        for (int i = 0; i < curLen; i++) {
            System.out.println(records[i].stuNo +
                    "\t" + records[i].Name + "\t" + records[i].score);
        }


        records[0] = stu1;
        records[1] = stu3;
        records[2] = stu4;
        records[3] = stu5;
        System.out.println();
        System.out.println("删除李四的信息：");
        System.out.println("------学生成绩表------");
        System.out.println("学号\t姓名\t成绩");
        System.out.println("--------------------");
        //输出表的内容
        for (int i = 0; i < curLen - 1; i++) {
            System.out.println(records[i].stuNo +
                    "\t" + records[i].Name + "\t" + records[i].score);
        }
    }
}
