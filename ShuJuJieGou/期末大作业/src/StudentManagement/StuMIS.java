package StudentManagement;

import java.io.*;
import java.util.Scanner;

public class StuMIS {

    public static void main(String[] args) throws Exception {
        StuList list = new StuList();
        String fileName = "src/StudentManagement/学生成绩表.txt";
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("”学生成绩表.txt“不存在，正在使用默认成绩表！");
            StuRecord s = new StuRecord("001", "张三", "男", 89, 87, 90);
            StuRecord s1 = new StuRecord("002", "李四", "男", 92, 87, 78);
            StuRecord s2 = new StuRecord("003", "赵六", "男", 74, 88, 91);
            StuRecord s3 = new StuRecord("004", "陈七", "女", 88, 89, 87);
            StuRecord s4 = new StuRecord("005", "李华", "男", 88, 80, 74);
            StuRecord s5 = new StuRecord("006", "小明", "男", 85, 54, 97);
            StuRecord s6 = new StuRecord("007", "小刚", "男", 78, 60, 75);
            StuRecord s7 = new StuRecord("008", "孙无", "男", 76, 69, 68);
            StuRecord s8 = new StuRecord("009", "赵丽", "女", 75, 88, 81);
            StuRecord s9 = new StuRecord("010", "陈七", "男", 83, 59, 96);
            StuRecord s10 = new StuRecord("011", "李华", "女", 90, 73, 75);
            StuRecord s11 = new StuRecord("012", "钱九", "男", 84, 61, 87);
            list.insert(s);
            list.insert(s1);
            list.insert(s2);
            list.insert(s3);
            list.insert(s4);
            list.insert(s5);
            list.insert(s6);
            list.insert(s7);
            list.insert(s8);
            list.insert(s9);
            list.insert(s10);
            list.insert(s11);
        } else {
            System.out.println("文件读取成功，正在使用”学生成绩表.txt“!");
            FileInputStream fis2 = new FileInputStream(file);
            InputStreamReader isr2 = new InputStreamReader(fis2);
            BufferedReader br2 = new BufferedReader(isr2);
            int nums2 = 0;
            while ((br2.readLine()) != null) {
                nums2++;
            }
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String[] line = new String[nums2 + 1];
            int nums = 0;
            while ((line[nums] = br.readLine()) != null) {
//                System.out.println(line[nums]);
                nums++;
            }
            String[] line2;
            for (int i = 0; i < line.length - 1; i++) {
                line2 = line[i].split("\\s+");
                int chn = Integer.valueOf(line2[3]);
                int mat = Integer.valueOf(line2[4]);
                int eng = Integer.valueOf(line2[5]);
                StuRecord stuR = new StuRecord(line2[0], line2[1], line2[2], chn, mat, eng);
                list.insert(stuR);
            }
            br.close();
        }


        System.out.println("-----------欢迎来到学生管理系统-----------");
        System.out.println("------1. 查看目前所有学生           -----");
        System.out.println("------2. 添加学生                 -----");
        System.out.println("------3. 删除学生                 -----");
        System.out.println("------4. 查找学生                 -----");
        System.out.println("------5. 修改数据                 -----");
        System.out.println("------6. 按照平均成绩降序排列       -----");
        System.out.println("------7. 按照语文成绩降序排列       -----");
        System.out.println("------8. 按照数学成绩降序排列       -----");
        System.out.println("------9. 按照英语成绩降序排列       -----");
        System.out.println("------10. 统计(各科平均成绩等数据)   -----");
        System.out.println("------11. 导出成txt               -----");
        System.out.println("------0. 退出                    -----");
        System.out.println("-------------------------------------");
        while (true) {
            System.out.println("请输入操作编号:");
            int i = new Scanner(System.in).nextInt();
            if (i == 1)
                list.display();
            else if (i == 2) {
                //添加
                System.out.println("请输入学号:");
                String a = new Scanner(System.in).next();
                System.out.println("请输入姓名:");
                String b = new Scanner(System.in).next();
                System.out.println("请输入性别:");
                String c = new Scanner(System.in).next();
                System.out.println("请输入语文成绩:");
                int d = new Scanner(System.in).nextInt();
                System.out.println("请输入数学成绩:");
                int e = new Scanner(System.in).nextInt();
                System.out.println("请输入英语成绩:");
                int f = new Scanner(System.in).nextInt();
                StuRecord r = new StuRecord(a, b, c, d, e, f);
                list.insert(r);
                System.out.println("添加学生成功！");
                System.out.println();
            }
            else if (i == 3) {
                //删除
                System.out.println("请输入要删除信息的学号:");
                String a = new Scanner(System.in).next();
                list.remove(a);
                System.out.println();
            }
            else if (i == 4) {
                //查询
                System.out.println("请输入要查询信息的学号或姓名:");
                String a = new Scanner(System.in).next();
                StuRecord[] p2 = list.indexOf2(a);
                if (p2 != null)
                    display(p2);
                else
                    System.out.println("信息不存在！");
                System.out.println();
            }
            else if (i == 5) {
                //修改
                System.out.println("请输入要修改信息的学号:");
                String a1 = new Scanner(System.in).next();
                System.out.println("请输入语文成绩:");
                int d = new Scanner(System.in).nextInt();
                System.out.println("请输入数学成绩:");
                int e = new Scanner(System.in).nextInt();
                System.out.println("请输入英语成绩:");
                int f = new Scanner(System.in).nextInt();
                list.Modify(a1, d, e, f);
                System.out.println();
            }
            else if (i == 6) {
                StuRecord[] records = list.SZ();
                averageSort(records);
                display(records);
                System.out.println();
            }
            else if (i == 7) {
                StuRecord[] records = list.SZ();
                ChineseSort(records);
                display(records);
                System.out.println();
            }
            else if (i == 8) {
                StuRecord[] records = list.SZ();
                mathSort(records);
                display(records);
                System.out.println();
            }
            else if (i == 9) {
                StuRecord[] records = list.SZ();
                EnglishSort(records);
                display(records);
                System.out.println();
            }
            else if (i == 10) {
                TJtitle();
                System.out.print("语文\t\t");
                display2(ChineseStatistics(list.SZ()));
                System.out.print("数学\t\t");
                display2(mathStatistics(list.SZ()));
                System.out.print("英语\t\t");
                display2(EnglishStatistics(list.SZ()));
                System.out.println();
            }
            else if (i == 11) {
                Save(list, "src/StudentManagement/学生成绩表.txt");
                System.out.println("文件保存成功！");
                System.out.println();
            }
            else if (i == 0) {
                System.out.println("是否保存此次修改?(1.是 2.否)");
                int sf = new Scanner(System.in).nextInt();
                if (sf == 1) {
                    Save(list, "src/StudentManagement/学生成绩表.txt");
                    System.out.println("文件保存成功！");
                    System.exit(0);
                } else
                    System.exit(0);
            }
            else {
                System.out.println("输入操作编号有误！");
                System.out.println();
            }


        }
    }

    public static void Save(StuList m, String name) throws Exception {
        FileWriter out;
        out = new FileWriter(name);
//        out.write(String.format("%-6s", "学号") + "\t" + String.format("%-7s", "姓名") + "\t" + String.format("%-5s", "性别") + "\t" + String.format("%-5s", "语文成绩") + "\t" + String.format("%-5s", "数学成绩") + "\t" + String.format("%-5s", "英语成绩") + "\t" + String.format("%-5s", "平均成绩") + "\n");
//        out.write("---------------------------------------------------------------\n");
        for (int i = 0; i < m.length(); i++) {
            out.write(String.format("%-7s", m.re(i).No) + "\t" + String.format("%-7s", m.re(i).name) + "\t" + String.format("%-7s", m.re(i).sex) + "\t" + String.format("%-7d", +m.re(i).Chinese) + "\t" + String.format("%-7d", m.re(i).math) + "\t" + String.format("%-7d", m.re(i).English) + "\t" + String.format("%-7s", m.re(i).average) + "\n");
        }
        out.close();
    }

    public static int[] ChineseStatistics(StuRecord[] r) {
        //语文统计
        int average = 0, max = 0, min = 100;
        int a = 0, b = 0, c = 0, d = 0, e = 0;
        int[] records = new int[8];
        for (int i = 0; i < r.length; i++) {
            average += (r[i].Chinese) / r.length;
            if (r[i].Chinese > max)
                max = r[i].Chinese;
            if (r[i].Chinese < min)
                min = r[i].Chinese;
            if (r[i].Chinese < 60)
                a++;
            else if (r[i].Chinese >= 60 && r[i].Chinese < 70)
                b++;
            else if (r[i].Chinese >= 70 && r[i].Chinese < 80)
                c++;
            else if (r[i].Chinese >= 80 && r[i].Chinese < 90)
                d++;
            else
                e++;
        }
        records[0] = average;
        records[1] = max;
        records[2] = min;
        records[3] = a;
        records[4] = b;
        records[5] = c;
        records[6] = d;
        records[7] = e;
        return records;
    }

    public static int[] mathStatistics(StuRecord[] r) {
        //数学统计
        int average = 0, max = 0, min = 100;
        int a = 0, b = 0, c = 0, d = 0, e = 0;
        int[] records = new int[8];
        for (int i = 0; i < r.length; i++) {
            average += (r[i].math) / r.length;
            if (r[i].math > max)
                max = r[i].math;
            if (r[i].math < min)
                min = r[i].math;
            if (r[i].math < 60)
                a++;
            else if (r[i].math >= 60 && r[i].math < 70)
                b++;
            else if (r[i].math >= 70 && r[i].math < 80)
                c++;
            else if (r[i].math >= 80 && r[i].math < 90)
                d++;
            else
                e++;
        }
        records[0] = average;
        records[1] = max;
        records[2] = min;
        records[3] = a;
        records[4] = b;
        records[5] = c;
        records[6] = d;
        records[7] = e;
        return records;
    }

    public static int[] EnglishStatistics(StuRecord[] r) {
        //英语统计
        int average = 0, max = 0, min = 100;
        int a = 0, b = 0, c = 0, d = 0, e = 0;
        int[] records = new int[8];
        for (int i = 0; i < r.length; i++) {
            average += (r[i].English) / r.length;
            if (r[i].English > max)
                max = r[i].English;
            if (r[i].English < min)
                min = r[i].English;
            if (r[i].English < 60)
                a++;
            else if (r[i].English >= 60 && r[i].English < 70)
                b++;
            else if (r[i].English >= 70 && r[i].English < 80)
                c++;
            else if (r[i].English >= 80 && r[i].English < 90)
                d++;
            else
                e++;
        }
        records[0] = average;
        records[1] = max;
        records[2] = min;
        records[3] = a;
        records[4] = b;
        records[5] = c;
        records[6] = d;
        records[7] = e;
        return records;
    }

    public static void ChineseSort(StuRecord[] r) {
        //按语文排序
        for (int i = 0; i < r.length - 1; i++) {
            for (int j = 0; j < r.length - 1; j++) {
                if (r[j].Chinese < r[j + 1].Chinese) {
                    StuRecord temp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = temp;
                }
            }
        }
    }

    public static void mathSort(StuRecord[] r) {
        //按数学排序
        for (int i = 0; i < r.length - 1; i++) {
            for (int j = 0; j < r.length - 1; j++) {
                if (r[j].math < r[j + 1].math) {
                    StuRecord temp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = temp;
                }
            }
        }
    }

    public static void EnglishSort(StuRecord[] r) {
        //按英语排序
        for (int i = 0; i < r.length - 1; i++) {
            for (int j = 0; j < r.length - 1; j++) {
                if (r[j].English < r[j + 1].English) {
                    StuRecord temp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = temp;
                }
            }
        }
    }

    public static void averageSort(StuRecord[] r) {
        //按平均成绩排序
        for (int i = 0; i < r.length - 1; i++) {
            for (int j = 0; j < r.length - 1; j++) {
                if (r[j].average < r[j + 1].average) {
                    StuRecord temp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = temp;
                }
            }
        }
    }

    public static void display(StuRecord[] r) {
        System.out.println(String.format("%-6s", "学号") + "\t" + String.format("%-7s", "姓名") + "\t" + String.format("%-5s", "性别") + "\t" + String.format("%-5s", "语文成绩") + "\t" + String.format("%-5s", "数学成绩") + "\t" + String.format("%-5s", "英语成绩") + "\t" + String.format("%-5s", "平均成绩"));
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < r.length; i++) {
            System.out.println(String.format("%-7s", r[i].No) + "\t" + String.format("%-7s", r[i].name) + "\t" + String.format("%-7s", r[i].sex) + "\t" + String.format("%-7d", +r[i].Chinese) + "\t" + String.format("%-7d", r[i].math) + "\t" + String.format("%-7d", r[i].English) + "\t" + String.format("%-7s", r[i].average));
        }
        System.out.println();
    }

    public static void TJtitle() {
        System.out.println("科目\t\t平均分\t最高分\t最低分\t不及格\t60~69\t70~79\t80~89\t90及以上");
        System.out.println("-------------------------------------------------------------------------");
    }

    public static void display2(int[] r) {
        for (int i = 0; i < r.length; i++) {
            System.out.print(r[i] + "\t\t");
        }
        System.out.println();
    }
}
