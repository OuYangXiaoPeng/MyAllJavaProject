package JuZhenDuiJiaoXianHe;

public class JuZhenDuiJiaoXianHe {


    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for (int i = 0,k = mat.length-1; i < mat.length; i++,k--) {
            sum += mat[i][i];
            if (i != k)
                sum += mat[i][k];
        }
        return sum;
    }

    public static void main(String[] args) {
        JuZhenDuiJiaoXianHe xianHe = new JuZhenDuiJiaoXianHe();
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int result = xianHe.diagonalSum(grid);
        System.out.println(result);
    }

}
