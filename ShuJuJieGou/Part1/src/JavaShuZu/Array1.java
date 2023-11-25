package JavaShuZu;

import java.util.Random;

//基本类型的数组
//数组的声明,数组的创建,初始化(元素赋予初始值),元素的顺序访问
//
public class Array1 {

    public static void main(String[] args) {
        //声明一个整型数组--定义了一个数组变量--引用型变量
        int[] num;//保存数组元素储存空间的首地址
        //创建数组元素的存储单元
        //语法：数组变量 = new 元素类型[数组长度]
        num = new int[9];
        //元素初始化--随机数发生器产生的随机数来初始化
        Random ran = new Random();
        //num[0]~num[8]都赋值
        for (int i = 0; i < num.length; i++) {
            num[i] = ran.nextInt(100);
        }
        //输出数组所有元素
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]);
            if (i < num.length - 1)
                System.out.print(",");
        }
        System.out.println();
        //增强for循环--for each循环
        for (Object obj : num) {
            System.out.print(obj + " ");
        }
        System.out.println();
        //将数组每天元素分别-1，然后输出数组
        for (int i = 0; i < num.length; i++) {
            num[i]++;
            System.out.print(num[i]);
            if (i < num.length - 1)
                System.out.print(",");
        }
        System.out.println();
    }

}
