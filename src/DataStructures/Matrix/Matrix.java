package DataStructures.Matrix;


import Common.Types.Size;
import Evklid.EuclidAdv;

import java.util.ArrayList;

public class Matrix<T> {
    //<editor-fold desc="Fields">
    private Integer rows;
    private Integer columns;
    private ArrayList<ArrayList<T>> items;
    //</editor-fold>

    //<editor-fold desc="Constructors">
    public Matrix() {
        this.rows = 0;
        this.columns = 0;
    }

    public Matrix(ArrayList<ArrayList<T>> items) {

        this.rows = 0;
        this.columns = 0;
        if (items != null) {
            this.rows = items.size();
            if (items.size() > 0)
                this.columns = items.get(0).size();
            Init(this.rows, this.columns);
            for (int i = 0; i < this.rows; i++)
                for (int j = 0; j < this.columns; j++)
                    this.Set(i, j, items.get(i).get(j));
        }
    }

    /**
     * конструктор Матрицы
     *
     * @param size - размер матрицы
     */
    public Matrix(Integer size) {
        Init(size, size);
    }

    /**
     * конструктор Матрицы
     *
     * @param rows    - количество строк
     * @param columns - количество столбцов
     */
    public Matrix(Integer rows, Integer columns) {
        Init(rows, columns);
    }

    /**
     * @param matrix матрица
     */
    public Matrix(Matrix matrix) {
        this.columns = new Integer(matrix.columns);
        this.rows = new Integer(matrix.rows);
        this.items = matrix.GetItems();
    }

    /**
     * @param items элементы матрицы
     */
    public Matrix(T[][] items) {
        if (items.length > 0) {
            Init(items.length, items[0].length);
            for (int i = 0; i < this.rows; i++)
                for (int j = 0; j < this.columns; j++)
                    this.Set(i, j, items[i][j]);
        } else
            Init(0, 0);
    }

    public Matrix(String str) {
        String[] rows = str.split("\n");
        if (rows.length > 0) {
            Init(rows.length, rows[0].split(" ").length);
            for (int i = 0; i < rows.length; i++) {
                String[] items = rows[i].split(" ");
                for (int j = 0; j < items.length; j++)
                    this.Set(i, j, (T) items[j]);
            }
        }
    }
    //</editor-fold>

    //<editor-fold desc="Setters">

    /**
     * Заносит value в указанную ячейку матрицы
     *
     * @param row    - строка
     * @param column - столбец
     * @param value  - значение
     */
    public void Set(int row, int column, T value) {
        if (Check(row, this.rows) && Check(column, columns))
            items.get(row).set(column, value);
    }
    //</editor-fold>

    //<editor-fold desc="Getters">

    public ArrayList<ArrayList<T>> GetItems() {
        ArrayList<ArrayList<T>> copy = new ArrayList<>();
        for (int i = 0; i < this.items.size(); i++) {
            copy.add(new ArrayList<>());
            for (int j = 0; j < this.items.get(0).size(); j++)
                copy.get(i).add(this.items.get(i).get(j));
        }
        return copy;
    }

    /**
     * @param row
     * @param column
     * @return
     */
    public T Get(int row, int column) {
        if (Check(row, this.rows) && Check(column, columns)) {
            return items.get(row).get(column);
        }
        return null;
    }

    public ArrayList<T> GetRow(int index) {
        if (Check(index, rows))
            return this.items.get(index);
        return new ArrayList<>();
    }

    public ArrayList<T> GetColumn(int index) {
        ArrayList<T> column = new ArrayList<>();
        if (Check(index, columns))
            for (int i = 0; i < rows; i++)
                column.add(this.items.get(i).get(index));
        return column;
    }

    /**
     * @param row
     * @param column
     * @return
     */
    public Double GetNum(int row, int column) {
        T item = this.Get(row, column);
        if (item.getClass().getName() == Integer.class.getName() || item.getClass().getName() == Double.class.getName())
            return ((Number) this.Get(row, column)).doubleValue();
        if (item.getClass().getName() == String.class.getName())
            return Double.valueOf((String) this.Get(row, column));
        return 0.0;
    }

    /**
     * @return - возврощает детерминант
     */
    public Double GetDeterminant() {
        double result = 0;
        Double koeff = new Double(1);
        if (this.rows < 2)
            return result;
        if (this.rows == 2) {
            result = this.GetNum(0, 0) * this.GetNum(1, 1)
                    - this.GetNum(1, 0) * this.GetNum(0, 1);
        } else {
            for (int i = 0; i < items.size(); i++) {
                koeff = i % 2 == 1 ? -1.0 : 1.0;
                Double item = this.GetNum(0, i);
                Double determinant = this.GetMinor(0, i).GetDeterminant();
                result += koeff * item * determinant;
            }
        }
        return result;
    }

    /**
     * @param row    - количество строк
     * @param column - колиество столбцов
     * @return - минор
     */
    public Matrix GetMinor(int row, int column) {
        Matrix minor = new Matrix(this);
        minor = minor.DeleteRow(row);
        minor = minor.DeleteColumn(column);
        return minor;
    }

    public Size GetSize() {
        return new Size(rows, columns);
    }

    /**
     * @return - сумма элементов матрицы
     */
    public T GetSum() {
        Double sum = 0.0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                sum += (Double) this.Get(i, j);
        return (T) sum;
    }

    /**
     * @return
     */
    public T GetAvg() {
        Double sum = (Double) this.GetSum();
        Integer count = this.rows * this.columns;
        sum /= count;
        return (T) sum;
    }
    //</editor-fold>

    //<editor-fold desc="Logic">

    /**
     * Получает обрутную матрицу
     *
     * @return обратная матрица
     * @see <a href="https://goo.gl/vChSuC">Калькулятор обратной матрицы</a>
     */
    public Matrix Inverse() {
        if (this.GetDeterminant() == 0)
            return null;
        Double k = 1.0 / this.GetDeterminant();
        return this.Transpose().AlgebraicAddition().Mul(k);
    }

    /**
     * Получает обрутную матрицу по модулю числа
     *
     * @param value
     * @return обратная матрица по модулю
     * @throws Exception
     * @see <a href="https://goo.gl/AXAUYi">Калькулятор обратной матрицы по модулю</a>
     */
    public Matrix Inverse(int value) throws Exception {
        Matrix result = this.AlgebraicAddition().Mod(value);
        Integer det = this.GetDeterminant().intValue();
        det = GetInverse(det, value);
        result = result.Mul(det.doubleValue()).Mod(value).Transpose();
        for (int i = 0; i < result.rows; i++)
            for (int j = 0; j < result.columns; j++)
                if ((Double) result.Get(i, j) < 0.0)
                    result.Set(i, j, (Double) result.Get(i, j) + value);
        return result;
    }

    /**
     * @return - копия транспонированной матрицы
     */
    public Matrix Transpose() {
        Matrix copy = new Matrix(this);
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < columns; j++) {
                T temp = (T) copy.Get(i, j);
                copy.Set(i, j, copy.Get(j, i));
                copy.Set(j, i, temp);
            }
        }
        return copy;
    }

    /**
     * Находит алгебраическое дополнение матрицы
     */
    private Matrix AlgebraicAddition() {
        Matrix copy = new Matrix(this);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Matrix minor = this.GetMinor(i, j);
                Double det = this.GetMinor(i, j).GetDeterminant();
                T value = (T) (Object) (Math.pow(-1, i + j) * this.GetMinor(i, j).GetDeterminant());
                copy.Set(i, j, value);
            }
        }
        return copy;
    }

    //</editor-fold>

    //<editor-fold desc="Arithmetic">

    /**
     * @param matrix1
     * @param matrix2
     * @return
     */
    public Matrix Add(Matrix matrix1, Matrix matrix2) {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                matrix1.Set(i, j, (Double) matrix1.Get(i, j) + (Double) matrix2.Get(i, j));
        return matrix1;
    }

    /**
     * @param matrix1
     * @param matrix2
     * @return
     */
    public Matrix Sub(Matrix matrix1, Matrix matrix2) {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                matrix1.Set(i, j, (Double) matrix1.Get(i, j) - (Double) matrix2.Get(i, j));
        return matrix1;
    }

    /**
     * @return
     */
    public Matrix Mul(Matrix matrix) {
        if (matrix.rows.intValue() != this.columns.intValue())
            return null;
        Matrix resultMatrix = new Matrix<Double>(
                Math.min(matrix.rows, this.rows),
                Math.min(matrix.columns, this.columns)
        );
        Double tmpValue = 0.0;
        for (int i = 0; i < this.rows; i++)
            for (int j = 0; j < matrix.columns; j++) {
                for (int l = 0; l < this.columns; l++)
                    tmpValue += Double.valueOf(String.valueOf(this.Get(i, l))) * Double.valueOf(String.valueOf(matrix.Get(l, j)));
                resultMatrix.Set(i, j, tmpValue);
                tmpValue = 0.0;
            }
        return resultMatrix;
    }

    /**
     * @return Умножение матрицы на число
     */
    public Matrix Mul(Double value) {
        Matrix copy = new Matrix(this);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) {
                Double newValue = (Double) copy.Get(i, j) * value;
                copy.Set(i, j, newValue);
            }
        return copy;
    }

    /**
     * @return Обратная матрица по модулю
     */
    public Matrix Mod(int value) {
        Matrix result = new Matrix(this.items);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) {
                Double newValue = (Double) result.Get(i, j) % value;
                result.Set(i, j, newValue);
            }
        return result;
    }

    /**
     * @return
     */
    public Matrix Div() {
        return new Matrix();
    }
    //</editor-fold>

    //<editor-fold desc="Other">

    /**
     * @param rows
     * @param columns
     */
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

    /**
     * @param value
     * @param limit
     * @return
     */
    public boolean Check(int value, int limit) {
        return (value > -1 && value < limit);
    }

    private Matrix Delete(int row, int column) {
        if ((Check(row, this.items.size()) && Check(column, this.items.get(0).size()))) {
            ArrayList<ArrayList<T>> copyItems = this.items;
            copyItems.get(row).remove(column);
            if (copyItems.get(row).size() == 0)
                copyItems.remove(row);
            Matrix copy = new Matrix(copyItems);
            return copy;
        }
        return this;
    }

    /**
     * Удаляет строку
     *
     * @param index номер строки
     * @return
     */
    public Matrix DeleteRow(int index) {
        if (Check(index, rows)) {
            ArrayList<ArrayList<T>> copyItems = this.GetItems();
            copyItems.remove(index);
            return new Matrix(copyItems);
        }
        return this;
    }

    /**
     * Удаляет столбец
     *
     * @param index номер столбца
     * @return
     */
    public Matrix DeleteColumn(int index) {
        if (Check(index, columns)) {
            ArrayList<ArrayList<T>> copyItems = this.GetItems();
            for (int i = 0; i < rows; i++)
                copyItems.get(i).remove(index);
            return new Matrix(copyItems);
        }
        return this;
    }

    private Integer GetInverse(int m, int n) throws Exception {
        EuclidAdv euclidAdv = new EuclidAdv();
        Integer[] values = EuclidAdv.GCD(m, n);
        int g = values[0];
        int x = values[1];
        int y = values[2];
        if (g != 1)
            throw new Exception("No GCD!");
        else
            return (x % n + n) % n;
    }

    @Override
    public String toString() {
        String str = "";
        if (items != null)
            for (int i = 0; i < items.size(); i++) {
                for (int j = 0; j < items.get(i).size(); j++)
                    str += String.format("%s ", this.Get(i, j).toString());
                str += '\n';
            }
        return str;
    }
    //</editor-fold>
}

