package Work.TwoWork;

public class GuShi {
    public static void main(String[] args) {
        //横排输出
        String str = "春眠不觉晓处处闻啼鸟夜来风雨声花落知多少";
        char[][] chars = new char[4][5];
        int index = 0;
        System.out.println("横排:");
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                chars[i][j] = str.charAt(index);
                System.out.print(chars[i][j]);
                index++;
            }
            System.out.println();
        }
        //竖排输出
        System.out.println("----------------------------");
        System.out.println("竖排:");
        for (int i = 0; i < chars[0].length; i++) {
            for (int j = 0; j < chars.length; j++) {
                System.out.print(chars[j][i]);
            }
            System.out.println();
        }
    }
}
