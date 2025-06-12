package Work.TwoWork;

public class YangHuiSanJiao {
    public static void main(String[] args) {
        int[][] arr = new int[10][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1]; // 定义每一行的长度
            arr[i][0] = 1;// 每行的第一个元素是1
            arr[i][i] = 1; // 每行的最后一个元素也是1
            //某个位置的值等于上一行相邻两个元素的和
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}
