package ÊýÑ§Àà;

public class F {
    long x;
    long y;

    void set(long x, long y) {
        this.x = x;
        this.y = y;
    }

    F() {
    }


    F(long x, long y) {
        this.x = x;
        if (y == 0) {
            throw new ArithmeticException("??????????");
        } else {
            this.y = y;
        }
        change();
    }

    F change() {
        long gcd = this.gcd(this.x, this.y);
        this.x /= gcd;
        this.y /= gcd;
        if (y < 0) {
            y *= -1;
            x *= -1;
        }
        return this;
    }

    long gcd(long a, long b) {
        long mod = a % b;
        if (mod == 0) {
            return b;
        } else {
            return gcd(b, mod);
        }
    }

    long getx() {
        return x;
    }

    long gety() {
        return y;
    }

    F add(F scd) {
        return new F(this.x * scd.y + scd.x * this.y, this.y * scd.y);
    }

    F sub(F scd) {
        return new F(this.x * scd.y - scd.x * this.y, this.y * scd.y);
    }

    F multiply(F scd) {
        return new F(this.x * scd.x, this.y * scd.y);
    }

    F devide(F scd) {
        return new F(this.x * scd.y, this.y * scd.x);
    }

    F pow(int n) {
        if (n == 0) {
            return new F(1, 0);
        }
        if (n == 1) {
            return this;
        }
        if (n % 2 == 0) {
            F temp = this.pow(n / 2);
            return temp.multiply(temp);
        } else {
            return this.pow(n - 1).multiply(this);
        }
    }

    public String toString() {
        if (y != 1) {
            return String.format("%d/%d", this.x, this.y);
        } else {
            return String.format("%d", this.x);
        }
    }
}

