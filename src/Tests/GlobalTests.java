package Tests;

import Common.Constants.Paths;
import Console.IOConsole;
import DataStructures.Matrix.Matrix;
import Encryption.Binary;
import Encryption.Block.Blocks.PBlock;
import Encryption.Block.DES.DES;
import Encryption.Block.DES.FeistelFunction;
import Encryption.Hack.Helper;
import Encryption.Shift.Caesar;
import Encryption.Shift.Hill;
import Encryption.Shift.Viginer;
import GUI_Forms.IOForm;
import Games.XOGame.Core.XO;
import Games.XOGame.Forms.Main;
import Helpers.Alphabets;
import Helpers.Converter;
import Helpers.FileIO;
import Helpers.Rand;
import Sorts.Buble.BubbleSort;
import Sorts.Merge.MergeSort;
import Sorts.Quick.QuickSort;
import Sorts.Sort;
import Sorts.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

import static Helpers.Alphabets.GetAlphabet;

/**
 * Тесты для классов
 *
 * @see <a href="https://docs.google.com/document/d/18NGW8EXk3RCwCqGvtAM17UXJaT2oEFonLt2Ne-hbrWE/mobilebasic">Лабараторные</a>
 */
public class GlobalTests {

    private static <T> void Check(String testName, T actual, T expected) {
        String message;
        boolean equals = false;
        Class<?> c1 = expected.getClass();
        Class<?> c2 = expected.getClass();
        if (c1 == c2) {
            if (c1.equals(Integer[].class))
                equals = Arrays.equals(Converter.Arrays.Convert((Integer[]) expected), Converter.Arrays.Convert((Integer[]) actual));
            else
                equals = expected.equals(actual);
        }
        if (equals)
            message = String.format("%s PASSED!", testName);
        else
            message = String.format("%s FAILED! actual:%s expected:%s", testName, actual, expected);
        System.out.println(message);
    }

    private static ArrayList<String> GetTestList() {
        ArrayList<String> list = new ArrayList<>();
        list.add(GetAlphabet(Alphabets.Alphabet.Cyrillic));
        list.add(GetAlphabet(Alphabets.Alphabet.Latin));
        list.add("bur");
        list.add("папа");
        list.add("mama");
        list.add("lol kek cheburek");
        return list;
    }

    public static class DataStructuresTest {
        /**
         * тесты структур данных
         */
        public static void Structures() {
//            DataStructures.Stack.Static.StaticStack staticStack = new DataStructures.Stack.Static.StaticStack(10);
//            DataStructures.Stack.Static.StaticStack testStatic = new DataStructures.Stack.Static.StaticStack(staticStack);
//            testStatic.Start();
//            DynamicStack dynamicStack = new DynamicStack();
//            DataStructures.Stack.Dynamic.Tests testDynamic = new DataStructures.Stack.Dynamic.Tests(dynamicStack);
//            testDynamic.Start();
        }

        public static Matrix GetMatrix() {
            Matrix matrix = new Matrix();
            Scanner scan = new Scanner(System.in);
            int rows = 0;
            int columns = 0;
            Double value = 0.0;
            System.out.print("Введите количество сторк: ");
            rows = scan.nextInt();
            System.out.print("Введите количество столбцов: ");
            columns = scan.nextInt();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(String.format("Введите элемент[%d,%d]: ", i, j));
                    value = scan.nextDouble();
                    matrix.Set(i, j, value);
                }
            }
            return matrix;
        }

        /**
         * тесты для матрицы
         */
        public static void Matrix() throws Exception {
            int size = 3;
//        Matrix<Integer> matrix = new Matrix<>(size, size);
//        Double counter = 1.0;
//        Random r = new Random();
//        for (int i = 0; i < size; i++)
//            for (int j = 0; j < size; j++)
//                matrix.Set(i, j, r.nextInt() % 100);
//        System.out.println(matrix);
//        System.out.println(matrix.GetDeterminant());
            Double[][] items = {
//                {1.0, -2.0, 3.0},
//                {0.0, 4.0, -1.0},
//                {5.0, 0.0, 0.0}
                    {6.0, 24.0, 1.0},
                    {13.0, 16.0, 10.0},
                    {20.0, 17.0, 15.0}

//                {2.0, -3.0, 1.0},
//                {5.0, 4.0, -2.0}
            };

            Double[][] items2 = {
                    {0.0},
                    {2.0},
                    {19.0}

//                {1.0, 0.0, 5.0},
//                {-2.0, 4.0, 0.0},
//                {3.0, -1.0, 0.0}

//                {-7.0, 5.0},
//                {2.0, -1.0},
//                {4.0, 3.0}
            };


            //Matrix matrix = GetMatrix();
            Matrix key = new Matrix<Double>(items);
            System.out.println(key);
            Matrix message = new Matrix<Double>(items2);
            System.out.println(message);
            Matrix encryptedMessage = key.Mul(message).Mod(26);
            System.out.println(encryptedMessage);
            System.out.println(key.Inverse(26).Mul(encryptedMessage).Mod(26));
        }
    }

    public static class Games {
        /**
         * тесты крестиков-ноликов
         */
        public static void GameXOTests() {
            try {
                //Games.XOGame.Core.Tests test = new Games.XOGame.Core.Tests(new XO(4, new IOConsole()));
                //test.Start();
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
    }

    public static class Forms {

    }

    public static class Sorts {
        /**
         * тестирование всех сортировок
         */
        public static void Sorts() {
            Sort[] sorts = {
                    new QuickSort(),
                    new MergeSort(),
                    new BubbleSort(),
            };
            for (Sort sort : sorts) {
                Test test = new Test(sort);
                test.Start(1000);
            }
        }
    }

    public static class Streams {
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
    }

    public static class Encryptions {

        /**
         *
         */
        public static void Caesar() {
            try {
                ArrayList<String> values = GetTestList();
                Caesar encryption = new Caesar();
                for (String str : values) {
                    String encryptedValue = encryption.Encrypt(str, 2);
                    System.out.println(encryptedValue);
                    System.out.println(encryption.Decrypt(encryptedValue, 2));
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }

        }

        /**
         *
         */
        public static void Viginer() {
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

        /**
         * <a href="https://ru.wikipedia.org/wiki/Шифр_Хилла">Шифр Хилла</a>
         */
        public static void Hill() {
            String message = "asdasd";
            Hill hill = new Hill();
            String encryptedMessage = hill.Encrypt(message, "");
            System.out.println(encryptedMessage);
            String decryptMessage = hill.Decrypt(encryptedMessage, hill.GetKey().toString());
            System.out.println(decryptMessage);
        }

        /**
         *
         */
        public static void EncyptionHackHelper() {
            try {
                Rand rand = new Rand();
                String originalMessage = FileIO.GetText(Paths.inputFile).toLowerCase();
                Caesar caesar = new Caesar();
                String encryptedMessage = caesar.Encrypt(originalMessage, rand.NextInt(1, 100));


                //String[] paths = {Paths.rusLanguage, Paths.engLanguage};
                //Helper helper = new Helper(paths);
                Helper helper = new Helper();
                HashMap<Character, Double> originalFrequency = helper.GetFrequency(originalMessage);
                helper = new Helper(originalFrequency);
                System.out.println("ORIGINAL:");
                System.out.println(originalMessage);
                System.out.println("ENCRYPTED:");
                System.out.println(encryptedMessage);
                System.out.println("DECRYPTED:");
                System.out.println(helper.Hack(encryptedMessage));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         *
         */
        public static void PBlock() {
            PBlock block = new PBlock();
            ArrayList<Integer> test = new ArrayList();
//            test.add(1);
//            test.add(0);
//            test.add(1);
//            test.add(0);
//            Check("ToBin", block.ToBin(10), new Integer[]{1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1});
//            Check("ToInt", block.ToInt(test), 10);
//            Integer[] tmp = block.ToBin(654356);
//            Integer tmp1 = block.ToInt(tmp);
//            System.out.println(tmp1);
            Integer tmp = block.Encrypt(15);
            System.out.println(tmp);
            Integer tmp1 = block.Decrypt(tmp);
            System.out.println(tmp1);


        }

        /**
         *
         */
        public static void DES() {
            Integer[] value = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            try {
                DES des = new DES();
                System.out.println(des.EncryptFunction(value, 4));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void Feistel() {
            try {
                FeistelFunction fiestel = new FeistelFunction();
                System.out.println(fiestel.Encrypt(8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void Binary() throws Exception {
//            for (int i = 0; i < 1024; i++) {
//              Binary binary = new Binary(20);
//                System.out.println(binary);
//            }
            Binary binary1 = new Binary(25);
            Binary binary2 = new Binary(18);
            //System.out.println(binary1.AND(binary2));
            //System.out.println(binary1.OR(binary2));
            //System.out.println(binary1.XOR(binary2));
            System.out.println(binary1);
            System.out.println(binary1.LeftShift());
            System.out.println(binary1.RightShift());
        }


    }


}