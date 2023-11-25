package FuShuYunSuan;

//Complex类是复数类型的具体实现
//Complex——自定义的类、数据结构、数据类型
public class Complex{
    //成员变量
    public F real, imag;

    public Complex() {
        real = new F();
        imag = new F();
    }

    public Complex(int real) {
        this.real = new F(real);
        imag = new F();
    }

    public Complex(F real) {
        this.real = real;
        imag = new F();
    }

    public Complex(int real, int imag) {
        this.real = new F(real);
        this.imag = new F(imag);
    }

    public Complex(F real, F imag) {
        this.real = real;
        this.imag = imag;
    }

    public Complex add(Complex z) {
        F newReal = this.real.add(z.real);
        F newImag = this.imag.add(z.imag);
        return new Complex(newReal, newImag);
    }

    public Complex minus(Complex z) {
        F newReal = this.real.sub(z.real);
        F newImag = this.imag.sub(z.imag);
        return new Complex(newReal, newImag);
    }

    // (a + bi) * (c + di) = (ac - bd) + (ad + bc)i
    public Complex multiply(Complex z) {
        F a, b, c, d;
        a = this.real;
        b = this.imag;
        c = z.real;
        d = z.imag;
        F newReal = a.mul(c).sub(b.mul(d));
        F newImag = a.mul(d).add(b.add(c));
        return new Complex(newReal, newImag);
    }


    // (a + bi) / (c + di) = (a + bi) * (c - di) / (c + di) * (c - di)
    // [(ac + bd) / (cc + dd)] + [(ad - bc) / (cc + dd)]i
    public Complex divide(Complex z) {
        F a, b, c, d;
        a = this.real;
        b = this.imag;
        c = z.real;
        d = z.imag;
        F temp = c.mul(c).add(d.mul(d));
        F newReal = a.mul(c).add(b.mul(d)).div(temp);
        F newImag = a.mul(d).sub(b.add(c)).div(temp);
        return new Complex(newReal, newImag);
    }

    public String show() {
        String result = "";
        if (imag.getDouble() < 0) {
            result = real + " - " + imag.mul(new F(-1)) + "i";
        } else if (imag.getDouble() > 0) {
            result = real + " + " + imag + "i";
        } else {
            result = real + "";
        }
        return result;
    }

    @Override
    public String toString() {
        return show();
    }
}
