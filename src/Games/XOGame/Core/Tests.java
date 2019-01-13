package Games.XOGame.Core;

import Console.IOConsole;
import Constants.Messages;
import Games.Enums.CellValues;
import Games.Game;
import Games.Test;

public class Tests extends Test {
    XO xoGame;

    public Tests(Game gameToTest) {
        super(gameToTest);
        xoGame = (XO) this.game;
    }


    /**
     * проверка строк
     */
    private void CheckHorizontal() {
        try {
            xoGame.field.Clear();
            for (int i = 0; i < (Integer) xoGame.field.GetSize().height; i++)
                xoGame.field.SetCell(0, i, CellValues.o);
            Assert("CheckHorizontal", xoGame.CheckWinToLine(), true);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * проверка столбцов
     */
    private void CheckVertical() {
        try {
            xoGame.field.Clear();
            for (int i = 0; i < (Integer) xoGame.field.GetSize().height; i++)
                xoGame.field.SetCell(i, 0, CellValues.o);
            Assert("CheckVertical", xoGame.CheckWinToLine(), true);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * проверка главной диагонали
     */
    private void CheckDiagonal1() {
        try {

            xoGame.field.Clear();
            for (int i = 0; i < (Integer) xoGame.field.GetSize().height; i++)
                xoGame.field.SetCell(i, i, CellValues.o);
            Assert("CheckDiagonal1", xoGame.CheckWinToDiagonal(), true);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * проверка побочной
     */
    private void CheckDiagonal2() throws Exception {
        try {
            xoGame.field.Clear();
            for (int i = 0; i < (Integer) xoGame.field.GetSize().height; i++)
                xoGame.field.SetCell(i, (Integer) xoGame.field.GetSize().height - 1 - i, CellValues.x);
            Assert("CheckDiagonal2", xoGame.CheckWinToDiagonal(), true);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     *
     */
    private void CheckInput() {
        int row = 99;
        int col = 98;
        System.out.println(String.format(Messages.Tests.testIO, row, col));
        Integer[] cords = xoGame.GetCords();
        Assert("CheckInput", cords[0] == row - 1 && cords[1] == col - 1, true);
    }

    /**
     *
     */
    private void CheckCordInput() throws Exception {
        int row = 1;
        int col = 2;
        System.out.println(String.format(Messages.Tests.testIO, row, col));
        xoGame.SetMark();
        Assert("CheckCordInput", xoGame.field.GetCell(row - 1, col - 1) == CellValues.x, true);
    }


    /**
     * тетсты ввода/вывода
     */
    @Override
    public void IOTests() {
        try {
            game = new XO(new IOConsole());
            //CheckInput();
            //CheckCordInput();
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    /**
     * тесты игровой логики
     */
    @Override
    public void LogicTests() {
        try {
//            CheckDiagonal1();
//            CheckDiagonal2();
//            CheckHorizontal();
//            CheckVertical();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
