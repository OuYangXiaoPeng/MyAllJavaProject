package StudentManagement;

import SQList.SqList;

public class StuList extends SqList {

    public StuList() throws Exception {
        super(100);
    }

    public StuRecord get(String sNo) throws Exception {
        for (int i = 0; i < this.length(); i++) {
            StuRecord temp = (StuRecord) super.get(i);
            if (temp.No.equals(sNo))
                return temp;
        }
        throw new Exception("学号:" + sNo + "的信息没找到");
    }

    public void insert(StuRecord p) throws Exception {
        super.insert(this.length(), p);
    }

    public void remove(String sNo) throws Exception {
        //删除
        int i;
        for (i = 0; i < this.length(); i++) {
            StuRecord temp = (StuRecord) super.get(i);
            if (Integer.valueOf(temp.No) == Integer.valueOf(sNo))
                break;
        }
        if (i < length()) {
            super.remove(i);
            System.out.println("删除成功！");
        } else
            throw new Exception("未找到学号代号:" + sNo + "，无法删除！");
    }

    public StuRecord[] indexOf2(Object obj) throws Exception {
        //查找
        int num = 0, num2 = 0;
        for (int i = 0; i < this.length(); i++) {
            StuRecord temp;
            temp = (StuRecord) super.get(i);
            if (temp.name.equals(obj) || temp.No.equals(obj)) {
                num++;
            }
        }
        StuRecord[] temp2 = new StuRecord[num];
        for (int i = 0; i < this.length(); i++) {
            StuRecord temp;
            temp = (StuRecord) super.get(i);
            if (temp.name.equals(obj) || temp.No.equals(obj)) {
                temp2[num2] = temp;
                num2++;
            }
        }
        return temp2;
    }

    public void Modify(String sNo, int Chinese, int math, int English) throws Exception {
        //修改成绩信息
        int i;
        StuRecord temp = null;
        for (i = 0; i < this.length(); i++) {
            temp = (StuRecord) super.get(i);
            if (temp.No.equals(sNo))
                break;
        }
        if (i < length()) {
            temp.Chinese = Chinese;
            temp.math = math;
            temp.English = English;
            temp.average = (Chinese+math+English)/3;
            System.out.println("修改学生信息成功！");
        } else
            throw new Exception("未找到学号代号:" + sNo + "，无法修改！");
    }

    public StuRecord[] SZ() throws Exception {
        //将数据保存在数组
        StuRecord[] stu = new StuRecord[this.length()];
        for (int i = 0; i < this.length(); i++) {
            stu[i] = (StuRecord) super.get(i);
        }
        return stu;
    }

    public StuRecord re(int i) throws Exception {
        StuRecord stu = (StuRecord) super.get(i);
        return stu;
    }

    @Override
    public void display() {
        System.out.println(String.format("%-6s", "学号")+"\t" + String.format("%-7s","姓名")+"\t"+ String.format("%-5s","性别") +"\t"+ String.format("%-5s", "语文成绩")+"\t" + String.format("%-5s", "数学成绩")+"\t"+ String.format("%-5s","英语成绩")+"\t"+ String.format("%-5s","平均成绩"));
        System.out.println("----------------------------------------------------------");
        super.display();
    }


}