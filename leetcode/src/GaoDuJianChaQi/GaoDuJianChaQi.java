package GaoDuJianChaQi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GaoDuJianChaQi {

    public static int heightChecker(int[] heights) {
        int n = heights.length;
        int[] copy = new int[n];
        System.arraycopy(heights, 0, copy, 0, n);
        Arrays.sort(copy);
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (copy[i] != heights[i]) {
                System.out.println(copy[i] + " " + heights[i]);
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {1, 5, 4, 3, 6, 7, 13, 2};
        heightChecker(height);
        List<Integer> list = new ArrayList<>();
        for (int i : height) {
            list.add(i);
        }
        System.out.println(list);
    }
}
