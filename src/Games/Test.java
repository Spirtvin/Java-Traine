package Games;

import Common.Constants.Messages;

import java.util.ArrayList;

/**
 * базовый тест для игр
 */
public abstract class Test {
    /**
     * тестируемая игра
     */
    public Game game;
    /**
     * список ошибок в тестах
     */
    public ArrayList<String> errors = new ArrayList<>();

    /**
     * создает тест
     *
     * @param gameToTest игра для теста
     */
    public Test(Game gameToTest) {
        game = gameToTest;
    }

    public void Assert(boolean actual, boolean expected) {
        if (actual != expected)
            errors.add(String.format(Messages.Tests.testError, expected, actual));
    }

    public void Assert(String name, boolean actual, boolean expected) {
        if (actual != expected)
            errors.add(String.format(Messages.Tests.testErrorWithName, name, expected, actual));
    }

    /**
     * тетсты ввода/вывода
     */
    public abstract void IOTests();

    /**
     * тесты игровой логики
     */
    public abstract void LogicTests();

    /**
     * запускает все тесты
     */
    public void Start() {
        IOTests();
        LogicTests();
        if (errors.size() == 0)
            System.out.println(Messages.Tests.success);
        else
            for (int i = 0; i < errors.size(); i++)
                System.out.println(errors.get(i));

    }
}
