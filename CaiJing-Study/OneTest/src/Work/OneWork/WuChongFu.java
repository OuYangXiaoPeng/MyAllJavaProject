package Work.OneWork;

public class WuChongFu {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7};
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {
                    if (i != j && i != k && j != k) { // 确保数字不重复
                        System.out.println(nums[i]*100 + nums[j]*10 + nums[k]);
                        num++;
                    }
                }
            }
        }
        System.out.println("共有" + num + "种组合");
    }
}
