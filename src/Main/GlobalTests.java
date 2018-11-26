package Main;

import Console.IOConsole;
import DataStructures.Matrix.Matrix;
import DataStructures.Stack.Dynamic.DynamicStack;
import DataStructures.Stack.Static.StaticStack;
import Encryption.Caesar;
import Encryption.Viginer;
import GUI_Forms.IOForm;
import Games.XOGame.Core.XO;
import Games.XOGame.Forms.Main;
import Sorts.Buble.BubbleSort;
import Sorts.Merge.MergeSort;
import Sorts.Quick.QuickSort;
import Sorts.Sort;
import Sorts.Test;

import java.util.ArrayList;
import java.util.Random;
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

    /**
     *
     */
    public static void Forms() {
//        Runnable r1 =new Runnable() {
//            @Override
//            public void run() {
//                InputForm inputForm = new InputForm();
//            }
//        };
//        Runnable r2 =new Runnable() {
//            @Override
//            public void run() {
//                InputForm inputForm = new InputForm();
//            }
//        };
//        Thread t1 =new Thread(r1);
//        Thread t2 =new Thread(r2);
//        t1.start();
//        t2.start();
        //InputForm inputForm2 = new InputForm();
        Main main = new Main();

    }

    /**
     *
     */
    public class XOCOnsole extends IOConsole {
        XOCOnsole() throws Exception {
            XO game = new XO(this);
            game.Start();
        }
    }

    /**
     *
     */
    public void Game() {
        try {
            IOConsole ioConsole = new IOConsole();
            IOForm ioForm = new IOForm();
            //XO game = new XO(ioForm);
            Main main = new Main();
            //game.Start();
            //new XOCOnsole();
        } catch (Exception ex) {
            System.out.println(ex);
        }
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

    public static void Matrix() {
        int size = 3;
        Matrix<Integer> matrix = new Matrix<>(size, size);
        Double counter = 1.0;
        Random r = new Random();
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                matrix.Set(i, j,  r.nextInt());
        System.out.println(matrix);
        System.out.println(matrix.GetDeterminant());
    }

    enum Alphabet {
        Cyrillic,
        Latin
    }

    private static String GetAlphabet(Alphabet type) {
        String str = "";
        if (type == Alphabet.Cyrillic) {
            for (int i = (int) 'а'; i <= (int) 'я'; i++)
                str += (char) i;
        } else {
            for (int i = (int) 'a'; i <= (int) 'z'; i++)
                str += (char) i;
        }
        return str;
    }

    private static ArrayList<String> GetTestList() {
        ArrayList<String> list = new ArrayList<>();
        list.add(GetAlphabet(Alphabet.Cyrillic));
        list.add(GetAlphabet(Alphabet.Latin));
        list.add("bur");
        list.add("папа");
        list.add("mama");
        list.add("lol kek cheburek");
        return list;
    }

    private static void Caesar() {
        ArrayList<String> values = GetTestList();
        Caesar encryption = new Caesar();
        for (String str : values) {
            String encryptedValue = encryption.Encrypt(str, 2);
            System.out.println(encryptedValue);
            System.out.println(encryption.Decrypt(encryptedValue, 2));
        }
    }

    private static void Viginer() {
        String key = "";
        ArrayList<String> values = GetTestList();
        Viginer encryption = new Viginer();
        for (String str : values) {
            String encryptedValue = encryption.Encrypt(str, key);
            //System.out.println(str);
            System.out.println(encryptedValue);
            System.out.println(encryption.Decrypt(encryptedValue, key));
        }
//        String str = "";
//        for (int i = (int) 'a'; i <= (int) 'z'; i++)
//            str += (char) i;
//        System.out.println("Исходное сообщение:");
//        System.out.println(str);
//        Viginer encryption = new Viginer();
//        for (int i = (int) 'a'; i <= (int) 'z'; i++) {
//            String key = String.valueOf((char) i);
//            String encryptedValue = encryption.Encrypt(str, key);
//            System.out.println("Зашифрованное сообщение:");
//            System.out.println(key + ":" + encryptedValue);
//            System.out.println("Дешифрованное сообщение:");
//            System.out.println(key + ":" + encryption.Decrypt(encryptedValue, key));
//        }
    }
//https://ru.wikipedia.org/wiki/Шифр_Хилла

    /**
     * Тесты для шифрования
     */
    public static void Encryption() {
        Viginer();
    }
}