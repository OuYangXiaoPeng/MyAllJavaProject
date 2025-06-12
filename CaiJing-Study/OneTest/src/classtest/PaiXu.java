package classtest;

import java.util.Random;

public class PaiXu {

    // 求数组中最大值
    public int maxNum(int[] nums) {
        int max = nums[0];
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > max) {
//                max = nums[i];
//            }
//        }
        // 优化代码
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // 冒泡排序
    public void swqp(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }

            //排序过程
//            for(int k: nums){
//                System.out.print(k + " ");
//            }
//            System.out.println();

        }
    }

    public static void main(String[] args) {
        PaiXu main = new PaiXu();
        Random rand = new Random();
        int[] a = new int[10];
        System.out.println("随机数组:");
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(50);
            System.out.print(a[i] + " ");
        }
        System.out.println();
        int max = main.maxNum(a);
        System.out.println("最大值:" + max);
        main.swqp(a);
        System.out.println("数组排序后:");
        for(int i: a){
            System.out.print(i + " ");
        }
    }
}