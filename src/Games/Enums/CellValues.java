package Games.Enums;

//алгоритм игры
//0.запустить игру
//1.получить координаты
//2.выбрать метку
//3.проверить клетку
//4.если клетка пустая,поставить метку
//5. если занята, пернуться в п.1
//6. после ходя одного из игроков проверять поля на победу
public enum CellValues {
    empty(0),
    x(1),
    o(2),
    inCorrect(3);
    private int value;

    CellValues(int i) {
        value = i;
    }

    public String toString() {
        if (value == 0)
            return "-";
        if (value == 1)
            return "X";
        if (value == 2)
            return "O";
        return "error";
    }

    public int GetValue() {
        return value;
    }
}
