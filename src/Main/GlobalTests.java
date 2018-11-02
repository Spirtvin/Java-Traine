package Main;

import DataStructures.Stack.Dynamic.DynamicStack;
import DataStructures.Stack.Static.StaticStack;
import GUI_Forms.IOConsole;
import GUI_Forms.InputForm;
import Games.XOGame.Core.XO;
import Sorts.Buble.BubbleSort;
import Sorts.Merge.MergeSort;
import Sorts.Quick.QuickSort;
import Sorts.Sort;
import Sorts.Test;

import java.util.concurrent.Semaphore;

public class GlobalTests {
    /**
     * тестирование всех сортировок
     */
    public static void Sorts() {
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

    /**
     * тесты структур данных
     */
    public static void Structures() {
        StaticStack staticStack = new StaticStack(10);
        DataStructures.Stack.Static.Tests testStatic = new DataStructures.Stack.Static.Tests(staticStack);
        testStatic.Start();
        DynamicStack dynamicStack = new DynamicStack();
        DataStructures.Stack.Dynamic.Tests testDynamic = new DataStructures.Stack.Dynamic.Tests(dynamicStack);
        testDynamic.Start();
    }

    /**
     * тесты крестиков-ноликов
     */
    public static void GameXO() {
        try {
            Games.XOGame.Core.Tests test = new Games.XOGame.Core.Tests(new XO(4, new IOConsole()));
            test.Start();
        } catch (Exception ex) {
            System.out.println(ex);
            //System.out.println(ex.getMessage());
        }
    }

    public static void Game() {
        //        GameXOTest();
//        try {
//            new Games.XOGame.Forms.Main();
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
    }

    /**
     * тест семафора
     */
    public static void Semaphore() {
        final Semaphore semaphore = new Semaphore(4);
        class MyThread extends Thread {
            String name;

            MyThread(String name) {
                this.name = name;
            }

            public void run() {
                try {
                    System.out.println(name + " access semaphore");
                    System.out.println(name + " semaphore permits: " + semaphore.availablePermits());
                    semaphore.acquire();
                    System.out.println(name + " thread got permit");
                    try {
                        for (int i = 1; i <= 5; i++) {
                            System.out.println(name + ": is perform operation" + i + " available permit:"
                                    + semaphore.availablePermits());
                            Thread.sleep(1000);
                        }
                    } finally {
                        System.out.println(name + " release semaphore");
                        semaphore.release();
                        System.out.println(name + " semaphore permits: " + semaphore.availablePermits());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        MyThread t1 = new MyThread("t1");
        t1.start();
        MyThread t2 = new MyThread("t2");
        t2.start();
        MyThread t3 = new MyThread("t3");
        t3.start();
        MyThread t4 = new MyThread("t4");
        t4.start();
        MyThread t5 = new MyThread("t5");
        t5.start();
        MyThread t6 = new MyThread("t6");
        t6.start();
    }

    public static void Forms() {
        Runnable r1 =new Runnable() {
            @Override
            public void run() {
                InputForm inputForm = new InputForm();
            }
        };
        Runnable r2 =new Runnable() {
            @Override
            public void run() {
                InputForm inputForm = new InputForm();
            }
        };
        Thread t1 =new Thread(r1);
        Thread t2 =new Thread(r2);
        t1.start();
        t2.start();

        //InputForm inputForm2 = new InputForm();
    }

}
