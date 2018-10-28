package Threads.Trains;

import jline.ConsoleReader;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class Train extends Thread {
    Integer pos;
    public String name;
    Integer length;
    Semaphore semaphore;
    JProgressBar railRoad;
    JLabel lblName;
    DefaultListModel<String> modelLeft;
    DefaultListModel<String> modelRight;
    Direction direction;

    public Train(String name, Integer length, JProgressBar railRoad, JLabel lblName, DefaultListModel<String> modelLeft, DefaultListModel<String> modelRight, Semaphore semaphore, Direction direction) {
        this.pos = 0;
        this.name = name;
        this.length = length;
        this.semaphore = semaphore;
        this.railRoad = railRoad;
        this.lblName = lblName;
        this.modelLeft = modelLeft;
        this.modelRight = modelRight;
        this.direction = direction;
    }

    public void Move() throws InterruptedException {
        if (direction == Direction.Left)
            railRoad.setForeground(Color.BLUE);
        else
            railRoad.setForeground(Color.RED);
        this.lblName.setText(this.name);
        railRoad.setMaximum(this.length * 2);
        for (int i = 0; i < this.length * 2; i++) {
            this.pos = i;
            railRoad.setValue(this.pos);
            Thread.sleep(10);
        }
        railRoad.setValue(0);
        this.lblName.setText("");
        if (direction == Direction.Left) {
            modelLeft.addElement(this.name);
            modelRight.removeElement(this.name);
        } else {
            modelRight.addElement(this.name);
            modelLeft.removeElement(this.name);
        }
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
            try {
                semaphore.acquire();
                try {
                    Move();
                } finally {
                    semaphore.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
