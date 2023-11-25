package XiaJiangLuJingZuiXiaoHe;

public class XiaJiangLuJingZuiXiaoHe {

    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        // 建立动态规划数组 dp，dp[i][j] 表示从第一行开始到第i行，且最后一个数字选择第j列时的最小和
        int[][] dp = new int[n][n];

        // 初始化第一行的最小和为对应列的数字
        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }

        // 从第二行开始计算最小和
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int minSum = Integer.MAX_VALUE;
                // 遍历上一行的每个数字，计算选择当前数字与上一行不在同一列的数字的和，并找到最小和
                for (int k = 0; k < n; k++) {
                    if (j != k) {
                        minSum = Math.min(minSum, dp[i - 1][k] + grid[i][j]);
                    }
                }

                // 将最小和保存在dp数组中
                dp[i][j] = minSum;
            }
        }

        // 在最后一行中找到最小和即为结果
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.min(result, dp[n - 1][i]);
        }

        return result;
    }

    public static void main(String[] args) {
        XiaJiangLuJingZuiXiaoHe xia = new XiaJiangLuJingZuiXiaoHe();
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int result = xia.minFallingPathSum(grid);
        System.out.println(result);
    }
}
