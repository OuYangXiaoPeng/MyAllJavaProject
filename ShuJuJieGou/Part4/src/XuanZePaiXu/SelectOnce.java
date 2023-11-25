package XuanZePaiXu;

/**
 * 选择排序的基础--一趟选择
 */
public class SelectOnce {
    //在数组r[i~n-1]中选择出最小值
    public static int selectOnce(int[] r, int i) {
        //先令第i号元素为临时最小值
        int min = i;
        //循环：令j从i+1~n-1依次取值，将r[i]之后的元素依次和临时最小值r[min]比较
        for (int j = i + 1; j < r.length; j++) {
            //若r[j]小于临时最小值r[min]，则r[j]成为新的临时最小值
            if (r[j] < r[min])
                min = j;
        }
        //循环结束，min中就是当前范围中的最小值的下标
        return min;
    }

    public static void display(int [] r){
        for (int i = 0; i < r.length; i++){
            System.out.print(r[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //定义并初始化数组
        int[] num = {6, 3, 9, 8, 2};
        int i = 0;
        int k, temp;
        //一趟选择
        k = selectOnce(num, i);
        System.out.println("第一趟选择，最小值" + num[k] + ",下标为：" + k);
        //一趟交换：将选择的最小值交换到r[i]
        temp = num[i];
        num[i] = num[k];
        num[k] = temp;
        display(num);

        i=1;
        //一趟选择
        k = selectOnce(num, i);
        System.out.println("第二趟选择，最小值" + num[k] + ",下标为：" + k);
        //一趟交换：将选择的最小值交换到r[i]
        temp = num[i];
        num[i] = num[k];
        num[k] = temp;
        display(num);

        i=2;
        //一趟选择
        k = selectOnce(num, i);
        System.out.println("第三趟选择，最小值" + num[k] + ",下标为：" + k);
        //一趟交换：将选择的最小值交换到r[i]
        temp = num[i];
        num[i] = num[k];
        num[k] = temp;
        display(num);

        i=3;
        //一趟选择
        k = selectOnce(num, i);
        System.out.println("第四趟选择，最小值" + num[k] + ",下标为：" + k);
        //一趟交换：将选择的最小值交换到r[i]
        temp = num[i];
        num[i] = num[k];
        num[k] = temp;
        display(num);
    }
}
