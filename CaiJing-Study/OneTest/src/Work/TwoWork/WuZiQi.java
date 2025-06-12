package Work.TwoWork;

import java.util.Scanner;

public class WuZiQi {
    private static final int SIZE = 9; // 棋盘大小
    private static char[][] board = new char[SIZE][SIZE]; // 棋盘
    private static char currentPlayer = '*'; // 当前玩家，'*' 表示玩家1，'o' 表示玩家2

    public static void main(String[] args) {
        initializeBoard(); // 初始化棋盘
        printBoard(); // 打印初始棋盘

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("当前玩家: " + currentPlayer);
            System.out.print("请输入x坐标（0-8）: ");
            int x = scanner.nextInt();
            System.out.print("请输入y坐标（0-8）: ");
            int y = scanner.nextInt();

            // 检查输入的合法性和位置是否空闲
            if (x >= 0 && x < SIZE && y >= 0 && y < SIZE && board[x][y] == '.') {
                board[x][y] = currentPlayer; // 在棋盘上放置当前玩家的棋子
                printBoard(); // 打印棋盘
                if (checkWin(x, y)) { // 检查当前玩家是否获胜
                    System.out.println("玩家 " + currentPlayer + " 获胜！");
                    break;
                }
                // 切换玩家
                currentPlayer = (currentPlayer == '*') ? 'o' : '*';
            } else {
                System.out.println("输入无效，请重新输入！");
            }
        }
        scanner.close();
    }

    // 初始化棋盘，全部填充为'.'表示空位
    private static void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '.';
            }
        }
    }

    // 打印棋盘
    private static void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 检查是否当前玩家获胜
    private static boolean checkWin(int x, int y) {
        return checkDirection(x, y, 1, 0)  // 水平方向
                || checkDirection(x, y, 0, 1)  // 垂直方向
                || checkDirection(x, y, 1, 1)  // 右下斜方向
                || checkDirection(x, y, 1, -1); // 左下斜方向
    }

    // 检查某个方向是否有5个相同的棋子连在一起
    private static boolean checkDirection(int x, int y, int dx, int dy) {
        int count = 1; // 当前棋子已经有1个
        // 检查正方向
        count += countInDirection(x, y, dx, dy);
        // 检查反方向
        count += countInDirection(x, y, -dx, -dy);
        return count >= 5;
    }

    // 检查一个方向上有多少个连续相同的棋子
    private static int countInDirection(int x, int y, int dx, int dy) {
        int count = 0;
        char player = board[x][y];
        int nx = x + dx;
        int ny = y + dy;
        while (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE && board[nx][ny] == player) {
            count++;
            nx += dx;
            ny += dy;
        }
        return count;
    }
}