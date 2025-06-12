package Work.ThreeWork.Triangle;

public class Triangle {
    private int a, b, c;

    public Triangle() {
    }

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getZhouChang() {
        return a + b + c;
    }

    public String isDengYao() {
        if (a == b && b == c) {
            return "是等边三角形";
        } else if (a == c || a == b || b == c) {
            return "是等腰三角形";
        } else {
            return "不是等腰三角形";
        }
    }

    public int maxBian() {
        return Math.max(a, Math.max(b, c));
    }

}
