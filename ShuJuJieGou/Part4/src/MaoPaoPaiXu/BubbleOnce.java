package MaoPaoPaiXu;

/**
 * 一趟冒泡的实现--从左到右将相邻元素（关键字）两辆比较
 */
public class BubbleOnce {

    public static void bubble(int[] r) {
        //循环比较/交换n-1次
        // [j]    [j+1]    r的范围[0...n-2]依次取值
        //r[0]   r[1]      :若逆序（左大于右），则交换位置
        //r[1]   r[2]
        //r[2]   r[3]
        //......
        //r[n-2]    r[n-1]
        for (int j = 0; j < r.length - 1; j++) {
            if (r[j] > r[j + 1]) {
                int temp = r[j];
                r[j] = r[j + 1];
                r[j + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        //初始化一个数组
        int [] num = {6, 9, 3, 4, 2};
        //调用一趟冒泡排序
        bubble(num);
        //显示冒泡之后的结果
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();

        bubble(num);
        //显示冒泡之后的结果
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();

        bubble(num);
        //显示冒泡之后的结果
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();

        bubble(num);
        //显示冒泡之后的结果
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();

    }
}
