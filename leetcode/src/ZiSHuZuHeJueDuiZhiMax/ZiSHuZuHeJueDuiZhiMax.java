package ZiSHuZuHeJueDuiZhiMax;

public class ZiSHuZuHeJueDuiZhiMax {

    public static int maxAbsoluteSum(int[] nums) {
        int f2, g2;
        int f = 0; // 当前位置的最大和
        int g = 0; // 当前位置的最小和
        int ans = 0; // 最大绝对和
        for (int x : nums) { // 遍历数组
            f2 = f;
            g2 = g;
            System.out.println("拿到：" + x + ":");
            f = Math.max(f, 0) + x; // 更新当前位置的最大和，如果f小于0，则置为0再加上当前元素x
            g = Math.min(g, 0) + x; // 更新当前位置的最小和，如果g大于0，则置为0再加上当前元素x
            ans = Math.max(ans, Math.max(f, Math.abs(g))); // 更新最大绝对和，取f和|g|的较大值与当前最大绝对和ans比较
            System.out.println("最大值:" + f + "(" + Math.max(f2, 0) + "+" + x + ")" + ",最小值:" + g + "(" + Math.min(g2, 0) + "+" + x + ")" + ",比较后:" + ans);
        }
        return ans; // 返回最大绝对和

    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 5, 6, -7, 3};

        int result = maxAbsoluteSum(nums);
        System.out.println(result);
    }

}
