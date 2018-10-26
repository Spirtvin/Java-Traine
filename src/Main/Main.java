package Main;

import DataStructures.Stack.Dynamic.DynamicStack;
import DataStructures.Stack.Static.StaticStack;
import DataStructures.Stack.Static.Tests;
import Games.XOGame.Core.XO;
import Helpers.IOConsole;
import Sorts.Buble.BubbleSort;
import Sorts.Merge.MergeSort;
import Sorts.Quick.QuickSort;
import Sorts.Sort;
import Sorts.Test;
import java.util.concurrent.Semaphore;

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

    /**
     * тесты структур данных
     */
    public static void StructuresTest() {
        StaticStack staticStack = new StaticStack(10);
        Tests testStatic = new Tests(staticStack);
        testStatic.Start();
        DynamicStack dynamicStack = new DynamicStack();
        DataStructures.Stack.Dynamic.Tests testDynamic = new DataStructures.Stack.Dynamic.Tests(dynamicStack);
        testDynamic.Start();
    }

    /**
     * тесты крестиков-ноликов
     */
    public static void GameXOTest() {
        try {
            Games.XOGame.Core.Tests test = new Games.XOGame.Core.Tests(new XO(4, new IOConsole()));
            test.Start();
        } catch (Exception ex) {
            System.out.println(ex);
            //System.out.println(ex.getMessage());
        }
    }

    public static void SemaphoreTest() {
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


    //TODO:привязать форму main к игре
    public static void main(String args[]) {
        /*GameXOTest();
        try {
            new Games.XOGame.GUI_Forms.Main();
        } catch (Exception ex) {
            System.out.println(ex);
        }*/
        //SemaphoreTest();
        //Train train = new Train("T1", 15, null);
        //train.start();
        new Threads.Trains.Forms.Main();
    }
}

