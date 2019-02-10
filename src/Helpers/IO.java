package Helpers;

import java.util.Scanner;

public class IO<T> {
    public void Print(T[] values) {
        for (int i = 0; i < values.length; i++)
            System.out.println(values[i].toString());
    }

    public void Print(T value) {
        System.out.println(value.toString());
    }

    public String GetLine() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public Integer GetInt() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public Double GetDouble() {
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

}
