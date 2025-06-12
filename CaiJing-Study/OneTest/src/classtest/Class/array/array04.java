package classtest.Class.array;

public class array04 {
    //冒泡排序
    public static void main(String[] args) {
        //声明
        int[] a = new int[5];
        //随机生成一个长度为5的整型数组
        System.out.print("未排序前a[i]:");
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 100);
            System.out.print(a[i] + " ");
        }
        System.out.println();
        //外层循环，控制轮数
        for (int i = 1; i < a.length; i++) {
            //内层循环，控制比较次数
            for (int j = 0; j < a.length - i; j++) {
                //如果前面元素大就更换
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.print("(升序)排序后a[i]:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }
}
