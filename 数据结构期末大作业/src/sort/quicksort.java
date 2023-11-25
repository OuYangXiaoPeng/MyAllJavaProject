package sort;

import java.util.Random;

public class quicksort {
    public static void quicksort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        if (r - l <= 100) {
            shellsort(a, l, r);
            return;
        }
        int[] p = partition(a, l, r);
        quicksort(a, l, p[0] - 1);
        quicksort(a, p[1] + 1, r);
    }

    public static int[] partition(int[] a, int l, int r) {
        int i = l;
        int pivot = a[new Random().nextInt(r - l + 1) + l];
        while (i <= r) {
            if (a[i] < pivot) {
                swap(a, l, i);
                l++;
                i++;
            } else if (a[i] == pivot) {
                i++;
            } else {
                swap(a, r, i);
                r--;
            }
        }
        return new int[]{l, r};
    }

    public static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void insert(int[] a, int l, int r, int step) {
        int key = a[r];
        for (int i = r; i - step >= l && a[i - step] > a[i]; i -= step) {
            swap(a, i, i - step);
        }
    }

    public static void shellsort(int[] a, int l, int r) {
        int step = 1;
        while (6 * step + 1 <= r - l) {
            step = 6 * step + 1;
        }
        while (step > 0) {
            for (int i = l + step; i <= r; i++) {
                insert(a, l, i, step);
            }
            step = (step - 1) / 6;
        }
    }

    public static void main(String[] args) {
        Random r = new Random();
        int random;
        int[] a = new int[]{3, 3, 3, 2, 1, 4, 5};
        int n = a.length;
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        int[] p = partition(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println(a[p[0]] + " " + a[p[1]]);
    }
}
