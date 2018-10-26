package Threads.Trains;

import jline.ConsoleReader;

import javax.swing.*;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class Train extends Thread {
    Integer pos;
    String name;
    Integer length;
    Semaphore semaphore;
    JProgressBar railRoad;

    public Train(String name, Integer length, JProgressBar railRoad, Semaphore semaphore) {
        this.pos = 0;
        this.name = name;
        this.length = length;
        this.semaphore = semaphore;
        this.railRoad = railRoad;
    }

    public void Move() throws InterruptedException {
        railRoad.setMaximum(this.length*2);
        for (int i = 0; i < this.length*2; i++) {
            this.pos = i;
            railRoad.setValue(this.pos);
            Thread.sleep(100);
        }
        railRoad.setValue(0);
    }

    public void clearConsole() throws IOException, InterruptedException {
        ConsoleReader reader = new ConsoleReader();
        reader.clearScreen();
        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    private void Print() throws InterruptedException, IOException {
        for (int i = 0; i < 100; i++) {
            this.pos = i;
            clearConsole();
            System.out.println(toString());
            Thread.sleep(100);
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < pos; i++)
            str += ' ';
        for (int i = 0; i < length; i++)
            str += '#';
        return str;
    }

    public void run() {
        if (semaphore == null) {
            try {
                Move();
                //Print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

        }
    }
}
