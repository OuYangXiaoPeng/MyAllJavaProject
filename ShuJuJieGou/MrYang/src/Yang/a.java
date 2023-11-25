package Yang;

public class a {

    public static long pow(long a, long b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        long temp = pow(a, b - 1);
        return temp * a;
    }

    public static long pow2(long a, long b) {
        if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a;
        } else if (b % 2 == 0) {
            long temp = pow(a, b / 2);
            return temp * temp;
        } else {
            long temp = pow(a, (b - 1) / 2);
            return temp * temp * a;
        }
    }

    public static long pow3(long a, long b) {
        if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a;
        } else if (b == 2) {
            return a * a;
        } else if (b % 3 == 0) {
            long temp = pow(a, b / 3);
            return temp * temp * temp;
        } else if (b % 3 == 1) {
            long temp = pow(a, (b - 1) / 3);
            return temp * temp * temp * a;
        } else {
            long temp = pow(a, (b - 2) / 3);
            return temp * temp * temp * a * a;
        }
    }

    public static long f(long n) {
        if (n == 0) {
            return 1;
        }
        long temp = f(n - 1);
        return temp * n;
    }

    public static long F(long n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        long temp1 = F(n - 1);
        long temp2 = F(n - 2);
        return temp1 + temp2;
    }

    public static long H(long n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 3;
        }
        long temp1 = H(1);
        long temp2 = 2 * H(n - 1);
        return temp1 + temp2;
    }

    public static long YSF(long n, long k) {
        if (n <= 2) {
            if (k % 2 == 0) {
                return 1;
            } else
                return 2;
        }
        long temp1 = YSF(n - 1, k) + k;
        long temp2 = temp1 % n;
        if (temp2 == 0) {
            temp2 = n;
        }
        return temp2;
    }

    public static long C(long n, long m) {
        if (n == 0 || m == 0 || n == m) {
            return 1;
        }
        if (m / 2 > n) {
            return C(n, n - m);
        }
        long temp1 = C(n - 1, m);
        long temp2 = C(n - 1, m - 1);
        return temp1 + temp2;
    }

    public static long CTL(long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        long s = 0;
        for (long i = 0; i < n; i++) {
            s = s + CTL(i) * CTL(n - 1 - i);
        }
        return s;
    }

    public static long CTL2(long n) {
        long temp = C(2*n,n);
        return temp/(n + 1);
    }

    public static void main(String[] args) {
        long begin, end;

        begin = System.currentTimeMillis();
        System.out.println("6^25=" + pow(2, 60));
        end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - begin));

        begin = System.currentTimeMillis();
        System.out.println("6^25快速冥算法：" + pow2(2, 60));
        end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - begin));

        begin = System.currentTimeMillis();
        System.out.println("6^25快快速冥算法：" + pow3(2, 60));
        end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - begin));

        System.out.println("4!=" + f(4));
        System.out.println("斐波那契数第4个数：" + F(4));
        System.out.println("汉罗塔4层：" + H(4));


        System.out.println("C(4,2)=" + C(4, 2));
        System.out.println("CTL(5)=" + CTL(5));
        System.out.println("CTL2(5)=" + CTL2(5));

        System.out.println("100个人围成一圈，1,2,3报数，报3的die.\n最后活下来的是：" + YSF(100, 3) + "号");
    }
}
