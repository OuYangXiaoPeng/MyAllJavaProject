package Yang;

public class TwoNumsSum {

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = n - 1; i > -1; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] + nums[j + n - i] == target) {
                    return new int[]{j, j + n - i};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int a[] = new int[10];
        int n = a.length;
        int target = 4;
        int s = 0;

        for (int i = 0; i < a.length; i++) {
            a[i] = i+2;
        }

        for (int i = n - 1; i > -1; i--) {
            for (int j = 0; j < i; j++) {

                System.out.println(a[j] + "\t" + a[(j + n - i)]+":");
                System.out.println(j + "\t" + (j + n - i));

                s++;
            }
            System.out.println();
        }
        System.out.println("×ÜÊýÎª£º"+s);
    }
}
