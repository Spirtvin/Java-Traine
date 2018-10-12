package Games.NumGuessGame;

import Games.Game;

import java.util.Random;
import java.util.Scanner;

public class NumGuess extends Game {
    public NumGuess() {

    }
    /**
     * Запускает игру
     */
    @Override
    public void Start() {
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
            Start();
    }

    /**
     * проверяет достижение определенного условия окончания игры
     * например, при нехватке места на поле
     *
     * @return
     */
    @Override
    public boolean Finish() {
        return false;
    }

    /**
     * Выводит информацию игр в строку
     *
     * @return
     */
    @Override
    public String toString() {
        return null;
    }
}

