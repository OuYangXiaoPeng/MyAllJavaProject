package ÊýÑ§Àà;

public class C {
    long x, y;

    F m, n;

    C() {
    }

    C(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public C(F m, F n) {
        this.m = m;
        this.n = n;
    }

    long pow(long a, long b) {
        if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a;
        } else if (b % 2 == 0) {
            long temp = pow(a, b / 2);
            return temp * temp;
        } else {
            return pow(a, b - 1) * a;
        }
    }

    long A(long n, long m) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else if (m == 0) {
            return 1;
        } else if (m == 1) {
            return n;
        } else if (m % 2 == 0) {
            long k = m / 2;
            long temp1 = A(n, k);
            long temp2 = A(n - k, k);
            return temp1 * temp2;
        } else {
            return A(n - 1, m - 1) * n;
        }
    }

    long C(long n, long m) {
        if (n == 0 || m == 0 || n == m) {
            return 1;
        }
        if (m > n - m) {
            return C(n, n - m);
        }
        return A(n, m) / A(m, m);
    }

    void set(long x, long y) {
        this.x = x;
        this.y = y;
    }

    long getx() {
        return this.x;
    }


    long gety() {
        return this.y;
    }

    C add(C z) {
        long m = 0, n = 0;
        long a, b, c, d;
        a = this.x;
        b = this.y;
        c = z.getx();
        d = z.gety();
        m = a + c;
        n = b + d;
        return new C(m, n);
    }

    C subtract(C z) {
        long m = 0, n = 0;
        long a, b, c, d;
        a = this.x;
        b = this.y;
        c = z.getx();
        d = z.gety();
        m = a - c;
        n = b - d;
        return new C(m, n);
    }

    C multiply(C z) {
        long m = 0, n = 0;
        long a, b, c, d;
        a = this.x;
        b = this.y;
        c = z.getx();
        d = z.gety();
        m = a * c - b * d;
        n = a * d + b * c;
        return new C(m, n);
    }

    C divide(C z) {
        F a = new F(this.x, 1);
        F b = new F(this.y, 1);
        F c = new F(z.getx(), 1);
        F d = new F(z.gety(), 1);
        F m, n;
        m = ((a.multiply(c)).add(b.multiply(d))).devide((c.multiply(c)).add(d.multiply(d)));
        n = ((b.multiply(c)).sub(a.multiply(d))).devide((c.multiply(c)).add(d.multiply(d)));
        return new C(m, n);
    }

    C pow(long n) {
        long a = this.x;
        long b = this.y;
        C Z = new C(a, b);
        if (n == 0) {
            Z = new C(1, 0);
            return Z;
        } else if (n == 1) {
            return Z;
        } else {
            C temp = Z.pow(n - 1);
            return Z.multiply(temp);
        }
    }

    C pow2(long n) {
        long t1 = 0;
        long t2 = 0;
        long a = this.getx();
        long b = this.gety();
        long aa, bb, cc, dd;
        C Z;
        if (n == 0) {
            t1 = 1;
            t2 = 0;
            Z = new C(t1, t2);
            return Z;
        }
        for (long i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                aa = C(n, i);
                bb = pow(a, n - i);
                cc = pow(b, i);
                dd = pow(-1, i / 2);
                t1 = t1 + aa * bb * cc * dd;
            } else {
                aa = C(n, i);
                bb = pow(a, n - i);
                cc = pow(b, i);
                dd = pow(-1, (i - 1) / 2);
                t2 = t2 + aa * bb * cc * dd;
            }
        }
        Z = new C(t1, t2);
        return Z;
    }

    C pow3(long n) {
        long a = this.x;
        long b = this.y;
        C Z = new C(a, b);
        if (n == 0) {
            Z = new C(1, 0);
            return Z;
        } else if (n == 1) {
            return Z;
        } else if (n % 2 == 0) {
            C temp = Z.pow3(n / 2);
            return temp.multiply(temp);
        } else {
            return Z.pow3(n - 1).multiply(Z);
        }
    }

    void show() {
        if (this.y < 0) {
            System.out.println(this.x + "" + this.y + "i");
        } else if (this.y == 0) {
            System.out.println(this.x);
        } else {
            System.out.println(this.x + "+" + this.y + "i");
        }
    }

    void show2() {
        if (this.n.getx() < 0) {
            System.out.println(this.m + "" + this.n + "i");
        } else if (this.n.getx() == 0) {
            System.out.println(this.m);
        } else {
            System.out.println(this.m + "+" + this.n + "i");
        }
    }
}
