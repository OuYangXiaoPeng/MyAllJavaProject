package classtest.Class.array;

public class array {
    public static void main(String[] args) {
        int a[];
        int[] b;
        int c[] = new int[5];
        System.out.println(c[0]);
        int d[] = new int[]{1, 2, 3, 4, 5};
        System.out.println(d[0]);
        for (int i = 0; i < d.length; i++) {
            System.out.print(d[i] + ",");
        }
        System.out.println();
        a = c;
        a[0] = 100;
        System.out.println("数组a的遍历结果:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
        System.out.println("数组c的遍历结果:");
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + ",");
        }

        //倒序输出
        System.out.println();
        for (int i = c.length - 1; i >= 0; i--) {
            System.out.print(c[i] + ",");
        }

    }
}
