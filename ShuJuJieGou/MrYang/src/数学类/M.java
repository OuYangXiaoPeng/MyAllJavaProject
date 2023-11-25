package ÊýÑ§Àà;

public class M {
    int row, col;
    long[][] a;

    M(){

    }
    M(long[][] mat) {
        this.row = mat.length;
        this.col = mat[0].length;
        this.a = mat;
    }

    void set(long[][] mat) {
        this.a = mat;
    }

    M transpose() {
        long[][] transpose = new long[this.col][this.row];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                transpose[j][i] = this.a[i][j];
            }
        }
        return new M(transpose);
    }

    M add(M mat) {
        long[][] add = new long[this.row][this.col];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                add[i][j] = this.a[i][j] + mat.a[i][j];
            }
        }
        return new M(add);
    }

    M subtract(M mat) {
        long[][] subtract = new long[this.row][this.col];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                subtract[i][j] = this.a[i][j] - mat.a[i][j];
            }
        }
        return new M(subtract);
    }


    M multiply(M mat) {
        long[][] multiply = new long[this.row][mat.col];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < mat.col; j++) {
                int s = 0;
                for (int k = 0; k < this.col; k++) {
                    s += this.a[i][k] * mat.a[k][j];
                }
                multiply[i][j] = s;
            }
        }
        return new M(multiply);
    }

    M multiply2(M mat) {
        M TMat = mat.transpose();
        long[][] multiply = new long[this.row][TMat.row];
        for (int i = 0; i < this.row; i++) {
            for (int k = 0; k < TMat.row; k++) {
                int s = 0;
                for (int j = 0; j < this.col; j++) {
                    s += this.a[i][j] * TMat.a[k][j];
                }
                multiply[i][k] = s;
            }
        }
        return new M(multiply);
    }

    M pow(int n) {
        long[][] mat;
        mat = this.a;
        M m = new M(mat);
        if (n == 0) {
            mat = new long[1][1];
            mat[0][0] = 1;
            return new M(mat);
        }
        if (n == 1) {
            return m;
        }
        if (n % 2 == 0) {
            M temp = m.pow(n / 2);
            return temp.multiply2(temp);
        } else {
            return m.pow(n - 1).multiply(m);
        }
    }

    void show() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                System.out.print(this.a[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
