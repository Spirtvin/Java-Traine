package Games;

/**
 * Базовый класс игры
 */
public abstract class Game {
    /**
     * номер текущего игрока
     */
    public int player = 0;

    /**
     * количество игроков
     */
    public int playersCount = 2;

    /**
     * счетчик ходов
     */
    public int stepCount = 0;

    /**
     * Переключает на следующего игрока
     */
    public void GetNextPlayer() {
        player = (player + 1) % playersCount;
        stepCount++;
    }

    /**
     * Запускает игру
     */
    public abstract void Start();
    /**
     * проверяет достижение определенного условия окончания игры
     * например, при нехватке места на поле
     * @return
     */
    public abstract boolean Finish();

    /**
     * Выводит информацию игр в строку
     *
     * @return
     */
    public abstract String toString();

}
