package Test1;

//求3个整数最大值
//输入：3个独立的整型变量--数据结构，数据组织
public class MaxNum1 {

    public static void main(String[] args) {
        //1,定义4个整型变量abc/maxNum
        int a = 13, b = 6, c = 25, maxNum;
        //2、若a > b则；（a和c比较）
        if (a > b) {
            // 若a > c，则a为最大值
            if (a > c)
                maxNum = a;
                //否则，c为最大值
            else
                maxNum = c;
        } else {
            //若b > c,则b为最大值
            if (b > c)
                maxNum = b;
                //否则，c为最大值
            else
                maxNum = c;
        }
        //输出
        System.out.println("最大值为:" + maxNum);
    }

}
