package ErFenChaZhao;

import java.util.Random;

public class YangSort {
    public static void all(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(j + "|" + (j + n - i) + "  ");
            }
            System.out.println();
        }
    }

    public static void bianli(int[] a) {
        int n = a.length;
        for (int i = n - 1; i > -1; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(j + "|" + (j + n - i) + "  ");
            }
            System.out.println();
        }
    }

    public static void insert(int[] a, int b, int i) {
        int key = a[i];
        for (int j = i; j - b > -1 && a[j - b] > key; j -= b) {
            swap(a, j, j - b);
        }
    }

    public static void shell(int[] a) {
        int j = 1;
        int k = 6;
        while (k * j + 1 < a.length) {
            j = k * j + 1;
        }
        while (j > 0) {
            for (int i = j; i < a.length; i++) {
                insert(a, j, i);
            }
            j = (j - 1) / k;
        }
    }


    public static void shell(int[] a, int l, int r) {
        int j = l + 1;
        int k = 6;
        while (k * j + 1 <= r) {
            j = k * j + 1;
        }
        while (j > l) {
            for (int i = j; i <= r; i++) {
                insert(a, j, i);
            }
            j = (j - 1) / k;
        }
    }

    public static void she(int[] a) {
        int k[] = new int[200];
        k[0] = 1;
        k[1] = 5;
        int cnt = 0;
        for (int j = 2; k[j - 2] < a.length; j += 2) {
            k[j] = (int) (4 * k[j - 2] + 9 * pow(2, j / 2) - 3);
            cnt++;
        }
        for (int j = 3; k[j - 2] < a.length; j += 2) {
            k[j] = (int) (4 * k[j - 2] + 3 * pow(2, (j + 3) / 2) - 3);
            cnt++;
        }
        while (cnt > -1) {
            for (int i = k[cnt]; i < a.length; i++) {
                insert(a, k[cnt], i);
            }
            cnt--;
        }
    }

    public static int fast2(int[] a, int left, int right) {
        int flag = a[left];
        boolean swap = true;
        while (left != right) {
            if (swap) {
                if (a[right] < flag) {
                    swap(a, left, right);
                    swap = false;
                    left++;
                } else {
                    right--;
                }
            } else {
                if (a[left] > flag) {
                    swap(a, left, right);
                    swap = true;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return left;
    }

    public static int fast3(int a[], int left, int right) {
        int flag = a[left];
        while (left != right) {
            while (a[right] > flag && left < right) {
                right--;
            }
            swap(a, left, right);
            while (a[left] <= flag && left < right) {
                left++;
            }
            swap(a, right, left);
        }
        return right;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] fast(int a[], int left, int right) {
        int pivot = a[left];
        int l = left;
        int r = right;
        int i = left;
        while (i <= r) {
            if (a[i] > pivot) {
                swap(a, r, i);
                r--;
            } else if (a[i] == pivot) {
                i++;
            } else {
                swap(a, l, i);
                l++;
                i++;
            }
        }
        int fast[] = new int[]{l, r};
        return fast;
    }

    public static void quick(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        three(a, l, l + (r - l) / 2);
        three(a, l + (r - l) / 2, r);
        int[] p = fast(a, l, r);
        quick(a, l, p[0] - 1);
        quick(a, p[1] + 1, r);
    }

    public static void three(int[] a, int l, int r) {
        int mid = l + (r - l) / 2;
        if (a[l] < a[mid] && a[l] < a[r]) {
            if (a[mid] > a[r]) {
                swap(a, l, r);
            } else {
                swap(a, l, mid);
            }
        }
        if (a[l] > a[mid] && a[l] > a[r]) {
            if (a[mid] < a[r]) {
                swap(a, l, r);
            } else {
                swap(a, l, mid);
            }
        }
    }

    public static int rand(int l, int r) {
        Random x = new Random();
        int mid = l + x.nextInt(r - l + 1);
        return mid;
    }

    public static void merge(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        merge(a, left, mid);
        merge(a, mid + 1, right);
        guibin(a, left, right);
    }

    public static void guibin(int[] a, int l, int r) {
        int[] temp = new int[r - l + 1];
        int m = (l + r) / 2;
        int i = l;
        int j = m + 1;
        int k = 0;
        while (i <= m && j <= r) {
            if (a[i] < a[j]) {
                temp[k] = a[i];
                k++;
                i++;
            } else {
                temp[k] = a[j];
                k++;
                j++;
            }
        }
        while (i <= m) {
            temp[k] = a[i];
            k++;
            i++;
        }
        while (j <= r) {
            temp[k] = a[j];
            k++;
            j++;
        }
        for (k = l; k <= r; k++) {
            a[k] = temp[k - l];
        }
    }

    public static void guibin2(int[] a, int l, int r) {
        int[] temp = new int[r - l + 1];
        for (int k = l; k <= r; k++) {
            temp[k - l] = a[k];
        }
        int m = (r - l) / 2;
        int i = 0;
        int j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i == m + 1 || (j != temp.length && temp[i] > temp[j])) {
                a[k] = temp[j];
                j++;
            } else {
                a[k] = temp[i];
                i++;
            }
        }
    }


    public static void health(int a[], int n, int m) {
        int temp;
        int l = m * 2 + 1;
        int r = m * 2 + 2;
        if (l <= n && a[l] > a[m]) {
            temp = l;
        } else {
            temp = m;
        }
        if (r <= n && a[r] > a[temp]) {
            temp = r;
        }
        if (m != temp) {
            swap(a, m, temp);
            health(a, n, temp);
        }
    }

    public static void build(int[] a) {
        int i = (a.length - 1) / 2;
        while (i >= 0) {
            health(a, a.length - 1, i);
            i--;
        }
    }


    public static void heap(int[] a) {
        build(a);
        for (int i = a.length - 1; i > 0; i--) {
            swap(a, 0, i);
            health(a, i - 1, 0);
        }
    }

    public static void heal(int a[], int n, int m) {
        int temp = m;
        int l = m * 2 + 1;
        int r = m * 2 + 2;
        if ((r <= n && l <= n) && (a[m] < a[l] && a[m] < a[r])) {
            if (a[l] < a[r]) {
                temp = l;
            } else {
                temp = r;
            }
        }
        if ((r <= n && l <= n) && (a[m] > a[l] && a[m] > a[r])) {
            if (a[l] > a[r]) {
                temp = l;
            } else {
                temp = r;
            }
        }
        if (m != temp) {
            swap(a, m, temp);
            heal(a, n, temp);
        }
    }

    public static void zhong(int[] a, int l, int r) {
        int i = (r - 1) / 2;
        while (i >= l) {
            heal(a, r, i);
            i--;
        }
    }

    static long[][] pows = new long[200][200];

    public static long pow(int a, int b) {
        if (pows[a][b] != 0) {
            return pows[a][b];
        }
        if (b == 0) {
            pows[a][b] = 1;
            return 1;
        }
        if (b == 1) {
            pows[a][b] = a;
            return a;
        }
        if (b % 2 == 0) {
            pows[a][b] = (pow(a, b / 2) * pow(a, b / 2));
            return pow(a, b / 2) * pow(a, b / 2);
        } else {
            pows[a][b] = (pow(a, b - 1) * a);
            return pow(a, b - 1) * a;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{-74, 48, -20, 2, 10, -84, -5, -9, 11, -24, -91, 2, -71, 64, 63, 80, 28, -30, -58, -11, -44, -87, -22, 54, -74, -10, -55, -28, -46, 29, 10, 50, -72, 34, 26, 25, 8, 51, 13, 30, 35, -8, 50, 65, -6, 16, -2, 21, -78, 35, -13, 14, 23, -3, 26, -90, 86, 25, -56, 91, -13, 92, -25, 37, 57, -20, -69, 98, 95, 45, 47, 29, 86, -28, 73, -44, -46, 65, -84, -96, -24, -12, 72, -68, 93, 57, 92, 52, -45, -2, 85, -63, 56, 55, 12, -85, 77, -39};
//        a = new int[]{5, 2, 3, 1};
//        a = new int[]{5, 1, 1, 2, 0, 0};
//        a = new int[]{4, 5, 2, 1, 3, 6, 7, 8, 9, 10};
        merge(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
