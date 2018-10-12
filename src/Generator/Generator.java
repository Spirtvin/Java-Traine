package Generator;

import java.util.ArrayList;
import java.util.Random;

public class Generator {
    public ArrayList<Integer> GetAsc(int count) {
        ArrayList list = new ArrayList();
        for (int i = 0; i <= count; i++)
            list.add(i);
        return list;
    }

    public ArrayList<Integer> GetDesc(int count) {
        ArrayList list = new ArrayList();
        for (int i = count; i >= 0; i--)
            list.add(i);
        return list;
    }

    public ArrayList<Integer> GetRandom(int count) {
        ArrayList list = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < count; i++)
            list.add(random.nextInt() % 100);
        return list;
    }
}
