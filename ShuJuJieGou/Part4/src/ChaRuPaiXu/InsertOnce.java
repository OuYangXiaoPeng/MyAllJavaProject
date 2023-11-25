package ChaRuPaiXu;

/**
 * y一趟插入--将数组中第i号元素插入到它左边的有序序列，使得有序性继续保持，序列长度+1
 */
public class InsertOnce {
    //r[i]左边是有序的，将r[i]插入到左边的合适位置上，是有序序列长度+1
    public static void insertOnce(int[] r, int i) {
        //将待插入的r[i]暂存0temp（r[i]位置空出，可以供移动元素、插入元素）
        int temp = r[i];
        //将temp依次和他左边的有序0序列元素比较r[i-1]~r[0]，寻找插入位置
        int j;
        //令下标变量j从i-1~0依次取值，循环：
        for (j = i - 1; j >= 0; j--) {
            //若temp<r[j],则r[j]右移动1位（temp应该在r[j]的左侧）
            if (temp < r[j]) {
                r[j + 1] = r[j];
            }
            //否则，退出循环（temp应该在r[j]的右侧，不用继续比较了）
            else
                break;
        }
        //在r[j+1]插入temp（无论循环因何退出，j+1都是找到的插入位置）
        r[j + 1] = temp;
    }

    public static void display(int [] r){
        for (int i = 0; i < r.length;i++){
            System.out.print(r[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //定义初始化一个数组
        int [] num={6,3,9,8,2};
        //调用1次insertOnce算法
        insertOnce(num,1);
        //显示显示结果
        display(num);

        //调用1次insertOnce算法
        insertOnce(num,2);
        //显示显示结果
        display(num);

        //调用1次insertOnce算法
        insertOnce(num,3);
        //显示显示结果
        display(num);

        //调用1次insertOnce算法
        insertOnce(num,4);
        //显示显示结果
        display(num);
    }
}
