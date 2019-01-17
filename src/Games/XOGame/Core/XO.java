package Games.XOGame.Core;

import Common.Constants.Messages;
import Games.Enums.CellValues;
import Games.Field.GameField;
import Games.Game;
import Interfaces.IO;
import Interfaces.IOType;

public class XO extends Game {

    //<editor-fold desc="Fields">
    GameField field;
    IO io;
    //</editor-fold>

    //<editor-fold desc="Methods">

    /**
     * Создаёт игровое поле.
     *
     * @param size размер поля
     * @throws Exception
     */
    void Init(int size, IO io) throws Exception {
        field = new GameField(size);
        this.io = io;
    }

    /**
     * получает метку текущего  игрока(X/O)
     *
     * @return метка тещуего игрока(X/O)
     */
    CellValues GetMark() {
        if (player == 0)
            return CellValues.x;
        if (player == 1)
            return CellValues.o;
        return CellValues.inCorrect;
    }

    /**
     * Запрашивает число у пользователя.
     *
     * @param message - инструкция по вводу.
     * @return
     */
    Integer GetInt(String message) {
        try {
            return Integer.parseInt((String) io.In(message));
        } catch (Exception ex) {
            System.out.println("Некорректное знчение!");
            return GetInt(message);
        }
    }

    /**
     * Получает координаты от игрока.
     *
     * @return - массив {строка, столбец}
     */
    Integer[] GetCords() {
        while (!this.io.GetDataReady()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (this.io.GetType() == IOType.console) {
            Integer[] cords = new Integer[]{
                    GetInt("Укажите строку:") - 1,
                    GetInt("Укажите столбец:") - 1
            };
            return cords;
        }
        if (this.io.GetType() == IOType.form) {
            try {
                return (Integer[]) io.In("Укажите координаты:");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * возвращает строку уведомления о ходе
     * текущего игрока
     *
     * @return
     */
    String GetCurrentPlayerStr() {
        if (player == 0)
            return Messages.Games.firstPlayer;
        return Messages.Games.secondPlayer;
    }

    /**
     * ставит метку игрока (Х/О)
     */
    boolean SetMark() {
        Integer[] cords = GetCords();
        if (!field.SetCell(cords, GetMark()))
            return SetMark();
        return true;
    }

    /**
     * Проверка на победу одного из игорокуов (Проверяет линию)
     *
     * @return true - если пора прекращать игру
     */
    boolean CheckWinToLine() {
        int count = 0;
        for (int i = 0; i < (Integer) field.GetSize().height; i++) {
            count = 0;
            CellValues value = field.GetCell(i, 0);
            for (int j = 0; j < (Integer) field.GetSize().width; j++)
                if (field.GetCell(i, j) == value && value != CellValues.empty)
                    count++;
            if (count == (Integer) field.GetSize().width)
                return true;
        }

        for (int i = 0; i < (Integer) field.GetSize().height; i++) {
            count = 0;
            CellValues value = field.GetCell(0, i);
            for (int j = 0; j < (Integer) field.GetSize().width; j++)
                if (field.GetCell(j, i) == value && value != CellValues.empty)
                    count++;
            if (count == (Integer) field.GetSize().width)
                return true;
        }
        return false;
    }

    /**
     * Проверка на победу одного из игроков (Проверяет горизонталь)
     *
     * @return
     */
    boolean CheckWinToDiagonal() {
        int count = 0;
        int size = (Integer) field.GetSize().height;
        CellValues value = field.GetCell(0, 0);
        for (int i = 0; i < size; i++) {
            if (field.GetCell(i, i) == value && value != CellValues.empty)
                count++;
        }
        if (count == size)
            return true;

        count = 0;
        value = field.GetCell(0, size - 1);
        for (int i = 0; i < size; i++) {
            if (field.GetCell(i, size - 1 - i) == value && value != CellValues.empty)
                count++;
        }
        return count == size;
    }

    /**
     * @return
     */
    boolean CheckWin() {
        boolean line = CheckWinToLine();
        boolean diag = CheckWinToDiagonal();
        //System.out.println(line);
        //System.out.println(diag);
        return CheckWinToLine() || CheckWinToDiagonal();
    }

    /**
     * запускает игру
     */
    public void Start() {
        try {
            //Init(GetInt(Messages.Games.inputFieldSize), this.io);
            while (!CheckWin()) {
                int move = player + 1;
                io.Out(new Object[]{this.field, "Ход игрока" + move}, "");
                //OutputForm<String> out = new OutputForm<>("Ok","Ход игрока" + move);
                SetMark();
                GetNextPlayer();
            }
            io.Out(this.field, "");
            if (!Finish()) {
                io.Out(new Object[]{this.field, String.format(Messages.Games.playerWon, player)}, "");
                //OutputForm<String> out = new OutputForm<>("Ok",String.format(Messages.Games.playerWon, player));
            } else
                io.Out(new Object[]{this.field, Messages.Games.draw}, "");
            //io.Out(Messages.Games.draw, "");
        } catch (Exception ex) {
            io.Out(new Object[]{this.field, ex.getMessage()}, "");
            //io.Out(ex, "ОШИБКА!");
            //io.Out(ex.getMessage(), "Сообщение:");
        }
    }

    /**
     * проверяет достижение определенного условия окончания игры
     * например, при нехватке места на поле
     *
     * @return
     */
    @Override
    public boolean Finish() {
        return field.GetCellsCount() == stepCount;
    }

    /**
     * Выводит информацию игр в строку
     *
     * @return
     */
    public String toString() {
        String str = "";
        if (!Finish())
            str += GetCurrentPlayerStr();
        str += "\n";
        str += this.field.toString();
        return str;
    }
    //</editor-fold>

    //<editor-fold desc="Constructor">

    /**
     * Для size размера
     */
    public XO(IO io) throws Exception {
        Init(3, io);
    }

    /**
     * Для любого размера поля
     *
     * @param size - ращмер поля
     */
    public XO(int size, IO io) throws Exception {
        Init(size, io);
    }
    //</editor-fold>

}

