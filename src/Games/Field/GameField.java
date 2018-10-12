package Games.Field;

import Constants.Messages;
import Games.Enums.CellValues;
import com.sun.glass.ui.Size;

public class GameField {

    /**
     * минимальный размер поля
     */
    int minSize = 3;
    /**
     * максимальный размер поля
     */
    int maxSize = 100;
    /**
     * количество столбцов
     */
    int colsCount = 0;
    /**
     * количество строк
     */
    int rowsCount = 0;
    /**
     * количество клеток
     */
    int cellsCount = 0;
    /**
     * Матрица поля
     */
    CellValues[][] cells;

    public GameField(int rows, int cols) throws Exception {
        Init(rows, cols);
    }

    public GameField(int size) throws Exception {
        Init(size);
    }

    /**
     * Создаёт прямоугольное игровое поле.
     *
     * @param rows число строк
     * @param cols число столбцов
     * @throws Exception
     */
    void Init(int rows, int cols) throws Exception {
        if (!Check(rows, minSize - 1, maxSize + 1) && !Check(cols, minSize - 1, maxSize + 1))
            throw new IllegalArgumentException(String.format(Messages.Fields.sizeError, minSize, maxSize));
        rowsCount = rows;
        colsCount = cols;
        cells = new CellValues[rows][cols];
        cellsCount = 0;
        for (int i = 0; i < rowsCount; i++)
            for (int j = 0; j < colsCount; j++) {
                cells[i][j] = CellValues.empty;
                cellsCount++;
            }
    }

    /**
     * Создаёт квадратное игровое поле.
     *
     * @param size размер
     * @throws Exception
     */
    void Init(int size) throws Exception {
        Init(size, size);
    }

    /**
     * очищает поле, без удаления ячеек
     *
     * @throws Exception
     */
    public void Clear() throws Exception {
        Init(rowsCount, colsCount);
    }

    /**
     * проеряет принадлежность элемента заданному промежутку
     *
     * @param value значение
     * @param from  от(не включительно)
     * @param to    до(не включительно)
     * @return true - если элемент принадлежит заданному промежутуку
     */
    boolean Check(int value, int from, int to) {
        return (value > from && value < to);
    }

    /**
     * проеряет принадлежность элементов массива заданному промежутку
     *
     * @param values массив знаений
     * @param from   от(не включительно)
     * @param to     до(не включительно)
     * @return true - если все элементы принадлежат заданному промежутуку
     */
    boolean Check(Integer[] values, int from, int to) {
        for (int value : values)
            if (!Check(value, from, to))
                return false;
        return true;
    }

    /**
     * проверяет координаты на корректность
     *
     * @param cords строка и столбец
     * @return
     */
    boolean Check(Integer[] cords) {
        if (cords.length > 1 &&
                Check(cords[0], -1, rowsCount) &&
                Check(cords[1], -1, colsCount) &&
                cells[cords[0]][cords[1]] == CellValues.empty)
            return true;
        return false;
    }

    public boolean SetCell(Integer[] coords, CellValues value) {
        if (coords.length > 1)
            return SetCell(coords[0], coords[1], value);
        return false;
    }

    public boolean SetCell(int row, int col, CellValues value) {
        if (Check(row, -1, rowsCount) && Check(col, -1, colsCount) && cells[row][col] == CellValues.empty) {
            cells[row][col] = value;
            return true;
        }
        return false;
    }

    public CellValues GetCell(int row, int col) {
        if (Check(row, -1, rowsCount) && Check(col, -1, colsCount)) {
            return cells[row][col];
        }
        return CellValues.inCorrect;
    }

    public Size GetSize() {
        return new Size(rowsCount, colsCount);
    }

    public int GetCellsCount() {
        return cellsCount;
    }
}
