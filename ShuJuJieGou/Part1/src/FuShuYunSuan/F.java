package FuShuYunSuan;

public class F {
    int x;
    int y;

    F() {
        x = 0;
        y = 1;
        clear();
    }


    F(int x) {
        this.x = x;
        y = 1;
        clear();
    }


    F(int x, int y) {
        this.x = x;
        this.y = y;
        clear();
    }

    void clear() {
        int gcd = gcd(x, y);
        x /= gcd;
        y /= gcd;
        if (y < 0) {
            x *= -1;
            y *= -1;
        }
    }

    // a / b + c / d = (ad + bc) / bd
    F add(F src) {
        int a = x;
        int b = y;
        int c = src.x;
        int d = src.y;
        int newX = a * d + b * c;
        int newY = b * d;
        return new F(newX, newY);
    }

    // a / b - c / d = (ad - bc) / bd
    F sub(F src) {
        int newX = x * src.y - src.x * y;
        int newY = y * src.y;
        return new F(newX, newY);
    }

    F mul(F src) {
        int newX = x * src.x;
        int newY = y * src.y;
        return new F(newX, newY);
    }

    F div(F src) {
        int newX = x * src.y;
        int newY = y * src.x;
        return new F(newX, newY);
    }

    //gcd(a, b) = gcd(b, a % b)
    int gcd(int a, int b) {
        int mod = a % b;

        if (mod == 0) {
            return b;
        }
        return gcd(b, mod);
    }

    double getDouble() {
        return (double) x / y;
    }

    double compare(F src) {
        double v1 = this.getDouble();
        double v2 = src.getDouble();
        return (v1 - v2);
    }

    public String show() {
        String result = "";
        if (y == 1) {
            result = x + "";
        } else {
            result = "(" + x + " / " + y + ")";
        }
        return result;
    }

    @Override
    public String toString() {
        return show();
    }
}
