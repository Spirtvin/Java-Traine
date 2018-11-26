package DataStructures.Matrix;

import java.util.ArrayList;


public class Matrix<T> {
    private Integer rows;
    private Integer columns;
    private ArrayList<ArrayList<T>> items;

    public Matrix() {
        this.rows = 0;
        this.columns = 0;
    }

    public Matrix(Integer size) {
        Init(size, size);
    }

    public Matrix(Integer rows, Integer columns) {
        Init(rows, columns);
    }

    private void Init(Integer rows, Integer columns) {
        if (rows > 0 && columns > 0) {
            this.rows = rows;
            this.columns = columns;
            items = new ArrayList<ArrayList<T>>();
            for (int i = 0; i < rows; i++) {
                items.add(new ArrayList<>());
                for (int j = 0; j < columns; j++)
                    items.get(i).add((T) (new Object()));
            }
        }
    }

    public boolean Check(int value, int limit) {
        return (value > -1 && value < limit);
    }

    public T Get(int row, int column) {
        if (Check(row, this.rows) && Check(column, columns)) {
            if(Integer.class == getClass())
            return (double) items.get(row).get(column);
        }
        return null;
    }

    public void Set(int row, int column, T value) {
        if (Check(row, this.rows) && Check(column, columns))
            items.get(row).set(column, value);
    }

    public Double GetDeterminant() {
        double result = 0;
        double koeff = 1;
        if (this.rows < 2)
            return result;
        if (this.rows == 2)
            result = (Double) this.Get(0, 0) * (Double) this.Get(1, 1) - (Double) this.Get(1, 0) * (Double) this.Get(0, 1);
        else
            for (int i = 0; i < items.size(); i++) {
                koeff = i % 2 == 1 ? -1 : 1;
                result += koeff * (Double) this.Get(0, i) * this.GetMinor(this, 0, i).GetDeterminant();
            }
        return result;
    }

    private Matrix GetMinor(Matrix matrix, int row, int column) {
        int minorLength = matrix.rows - 1;
        Matrix minor = new Matrix(minorLength, minorLength);
        int dI = 0, dJ = 0;
        for (int i = 0; i <= minorLength; i++) {
            dJ = 0;
            for (int j = 0; j <= minorLength; j++) {
                if (i == row)
                    dI = 1;
                else {
                    if (j == column)
                        dJ = 1;
                    else
                        minor.Set(i - dI, j - dJ, matrix.Get(i, j));
                }
            }
        }
        return minor;
    }

    public T GetSum() {
        Double sum = 0.0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                sum += (Double) this.Get(i, j);
        return (T) sum;
    }

    public T GetAvg() {
        Double sum = (Double) this.GetSum();
        Integer count = this.rows * this.columns;
        sum /= count;
        return (T) sum;
    }

    public void Transponate() {
        int n = 3;
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = n * i + j;
            }
        }

        // часть 2 - выводит на экран начальную матрицу
        System.out.println("Начальная матрица");
        System.out.println("------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
            System.out.println();
        }

        // часть 3 - транспонирование матрицы
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        // часть 4 - выводит на экран транспонированную матрицу
        System.out.println();
        System.out.println("Новая матрица");
        System.out.println("------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d", a[i][j]);
            }
            System.out.println();
        }

    }

    public Matrix Add(Matrix matrix1, Matrix matrix2) {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                matrix1.Set(i, j, (Double) matrix1.Get(i, j) + (Double) matrix2.Get(i, j));
        return matrix1;
    }

    public Matrix Sub(Matrix matrix1, Matrix matrix2) {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                matrix1.Set(i, j, (Double) matrix1.Get(i, j) - (Double) matrix2.Get(i, j));
        return matrix1;
    }

    public Matrix Mul() {
        return new Matrix();
    }

    public Matrix Div() {
        return new Matrix();
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                str += String.format("%s ", this.Get(i, j).toString());
            str += '\n';
        }
        return str;
    }
}

