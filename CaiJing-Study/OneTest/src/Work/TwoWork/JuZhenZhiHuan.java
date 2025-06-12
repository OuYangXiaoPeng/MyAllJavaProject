package Work.TwoWork;

public class JuZhenZhiHuan {
    public static void main(String[] args) {
        int [][] array = new int[][]{
                {91,25,8},
                {56,14,2},
                {47,3,67}
        };
        System.out.println("原矩阵:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++)
                System.out.print(array[i][j] + "\t");
            System.out.println();
        }
        System.out.println("转置矩阵后:");
        for(int i = 0; i < array[0].length; i++){
            for (int j = 0; j < array.length; j++)
                System.out.print(array[j][i] + "\t");
            System.out.println();
        }
    }
}
