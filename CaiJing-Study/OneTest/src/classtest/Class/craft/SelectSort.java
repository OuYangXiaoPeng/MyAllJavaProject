package classtest.Class.craft;

public class SelectSort {
    public static void main(String[] args) {
        int[] a = new int[5];
        int index;//记录数组索引下标
        for (int i = 0; i < a.length - 1; i++) {
            a[i] = (int) (Math.random() * 100);
        }
        System.out.println("原数组:");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();

//        //选择排序算法
//        //外层控制，控制比较的轮数
//        for (int i = 1; i < a.length; i++) {
//            index = 0;//因为每次都是从第一个元素开始比较的
//            for (int j = 1; j < a.length - i; j++) {
//                if (a[j] > a[index]) {
//                    index = j;
//                }
//            }
//            int temp = a[a.length - i];
//            a[a.length - i] = a[index];
//            a[index] = temp;
//        }

        SelectSort01(a);
        System.out.println("排序后的数组:");
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    //选择排序方法
    //选择最小的出来
    public static void SelectSort01(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }
}
