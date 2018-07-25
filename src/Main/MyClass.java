package Main;

import DataStructures.BinaryTree.BinaryTree;
import DataStructures.LinkedList.ListItem;
import DataStructures.LinkedList.OWLL;
import DataStructures.LinkedList.TWLL;
import DataStructures.Stack.DynamicStack;
import DataStructures.Queue.MyQueue;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class MyClass {

    public static void TestBinaryTree() {
        Random r = new Random();
        ArrayList<Integer> values = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++)
            values.add(r.nextInt() % 100);
        BinaryTree tree = new BinaryTree(values);
        tree.BinaryAdd(values);
    }

    public static void TestTWLL() {
        TWLL list = new TWLL();
        for (int i = 0; i < 5; i++)
            list.AddFirst(i);
        System.out.print(list.ToString());
        for (int i = 0; i < 5; i++)
            list.Delete(i);
        System.out.print(list.ToString());
    }

    public static void TestOWLL() {
        OWLL list = new OWLL();
        list.AddLast(1);
        System.out.print(list.ToString());
        list.AddLast(2);
        System.out.print(list.ToString());
        list.AddLast(3);
        System.out.print(list.ToString());
        ListItem res = list.Search(1);
        list.Delete(3);
        System.out.print(list.ToString());
        list.Delete(2);
        System.out.print(list.ToString());
        list.Delete(0);
        System.out.print(list.ToString());
        list.AddLast(99);
        System.out.print(list.ToString());
    }

    public static boolean Search(Stack stack, int value) {
        Stack copy = new Stack();
        copy.addAll(stack);
        while (copy.size() > 0)
            if ((int) copy.pop() == value)
                return true;
        return false;
    }

    public static void TestStack() {
        Stack stack = new Stack();
        for (int i = -2; i < 6; i++)
            stack.push(i);
        System.out.print(Search(stack, -33) + "\n");
        for (int i = 0; i < 10; i++)
            if (stack.empty())
                stack.pop();
        System.out.print(stack.pop());
        System.out.print(stack);
        stack.pop();


        System.out.print(stack);


    }

    public static void TestQueue() {
        try {
            MyQueue st = new MyQueue();
            for (int i = 0; i < 10; i++)
                st.Enqueue(i);
            System.out.print(st.ToString());
            for (int i = 0; i < 5; i++)
                st.Dequeue();
            System.out.print(st.ToString());
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }

    public static void TestDynamicStack() {
        DynamicStack st = new DynamicStack();
        System.out.print("Test pop\n");
        try {
            st.Push(-123);
            st.Push(1);
            st.Push(0);
            st.Find(-1);
            System.out.print(st.Pop() == 0);
            System.out.print("\n");
            for (int i = 0; i < 99; i++)
                st.Pop();
        } catch (Exception ex) {
            System.out.print(ex);
        }
        System.out.print("Test peek\n");
        try {
            //TODO:
            //по подобию pop
            //но не копировать полностью
            st.Peek();
            st.Peek();
            st.Pop();
            st.Pop();
            st.Find(-1);
            for (int i = 0; i < 99; i++) {
                double test = 0.50;
                st.Push((int) test);
            }
        } catch (Exception ex) {
            System.out.print(ex);
        }
        System.out.print("Test push\n");
        try {
            //TODO:добавить тест для push
            for (int i = 0; i < 12; i++)
                st.Push(i);
            System.out.print(st.ToString());
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }

    public static void Play() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int value = rand.nextInt(100);
        int num, count = 0;
        String replay;
        do {
            count = count + 1;
            num = sc.nextInt();
            if (num > value)
                System.out.print("Ваше число больше\n");
            if (num < value)
                System.out.print("Ваше число меньше\n");
            if (count == 5)
                System.out.print("Уже целых 5 попыток! Интуицыя вас подводит :(\n");
        }
        while (num != value);
        System.out.print("Поздравляем, вы угадали!\n");
        if (count == 1) {
            System.out.print("Вы сделали это с первой попытки!\n");
        } else {
            if (count >= 5) {
                System.out.print("На это у вас ушло ");
                System.out.print(count);
                System.out.print(" потпыток. Но играть в лотерею я вам не советую.\n");
            } else {
                System.out.print("На это у вас ушло ");
                System.out.print(count);
                System.out.print(" потпыток\n");
            }
        }
        System.out.print("Хотите сыграть ещё раз? Да/Нет\n");
        replay = sc.nextLine();
        replay = sc.nextLine();
        if (replay.equals("да"))
            Play();
    }

    public static boolean IsPolyndrom(String str) {
        for (int i = 0; i < str.length() / 2; i++)
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        return true;
    }

    /**
     * проверка строки на полиндром
     *
     * @param str строка для проверки
     * @return true - если строка палиндром
     */
    public static boolean IsPolyndrom2(String str) {
        String str2 = "";
        for (int i = str.length() - 1; i >= 0; i--)
            str2 += str.charAt(i);
        return str2.equals(str);
    }

    /**
     * Сортировка пузырьком
     *
     * @param a массив для сортировки
     * @return отсортированный массив
     */
    public static int[] BubleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i] < a[j]) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
        return a;
    }

    public static void Print(int[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i]);
    }


    public static void main(String args[]) {
        //TestDynamicStack();
        //TestQueue();
        //TestOWLL();
        //TestTWLL();
        TestBinaryTree();

    }
}

