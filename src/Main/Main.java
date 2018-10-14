package Main;

import Games.XOGame.Core.XO;
import DataStructures.Stack.Dynamic.DynamicStack;
import DataStructures.Stack.Static.StaticStack;
import DataStructures.Stack.Static.Tests;
import Games.XOGame.Forms.InputForm;
import Helpers.Forms;
import Helpers.IOConsole;
import Sorts.Buble.BubbleSort;
import Sorts.Merge.MergeSort;
import Sorts.Quick.QuickSort;
import Sorts.Sort;
import Sorts.Test;

import javax.swing.*;

/**
 * точка входа
 */
public class Main {

    /**
     * тестирование всех сортировок
     */
    public static void SortsTest() {
        Sort sorts[] = {
                new QuickSort(),
                new MergeSort(),
                new BubbleSort(),
        };
        for (Sort sort : sorts) {
            Test test = new Test(sort);
            test.Start(1000);
        }
    }

    public static void StructuresTest() {
        StaticStack staticStack = new StaticStack(10);
        Tests testStatic = new Tests(staticStack);
        testStatic.Start();
        DynamicStack dynamicStack = new DynamicStack();
        DataStructures.Stack.Dynamic.Tests testDynamic = new DataStructures.Stack.Dynamic.Tests(dynamicStack);
        testDynamic.Start();
    }

    public static void GameXOTest() {
        try {
            Games.XOGame.Core.Tests test = new Games.XOGame.Core.Tests(new XO(4, new IOConsole()));
            test.Start();
        } catch (Exception ex) {
            System.out.println(ex);
            //System.out.println(ex.getMessage());
        }
    }


    public static void main(String args[]) {
        //SortsTest();
        //StructuresTest();
        GameXOTest();
        try {
//            JFrame frame = new JFrame("XO Game!");
//            frame.setContentPane(new Games.XOGame.Forms.Main().panel1);
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.pack();
//            frame.setVisible(true);

//            Forms formsHelper = new Forms();
//            JFrame input = formsHelper.Create(
//                    new Games.XOGame.Forms.InputForm("Готово", "Размер поля", "",
//                    new Games.XOGame.Forms.Main().panel1).MainPanel,
//                    "Укажите размер поля"
//            );
//            formsHelper.Show(input);
            //TODO:привязать форму main к игре
            Games.XOGame.Forms.Main mainForm = new Games.XOGame.Forms.Main();
//            XO game = new XO(new IOConsole());
//            game.Start();
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}

