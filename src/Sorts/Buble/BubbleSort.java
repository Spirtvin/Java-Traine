package Sorts.Buble;

import Sorts.Sort;

import java.util.ArrayList;

public class BubbleSort extends Sort {

    @Override
    public <E> ArrayList<E> Sort(ArrayList<E> items, Direction direction) {
        for (int i = 0; i < items.size(); i++)
            for (int j = 0; j < items.size(); j++)
                if (direction == Direction.asc) {
                    if ((Integer) items.get(i) < (Integer) items.get(j)) {
                        E tmp = items.get(j);
                        items.set(j, items.get(i));
                        items.set(i, tmp);
                    }

                } else if (Compare(items.get(i),items.get(j),direction)) {
                    E tmp = items.get(j);
                    items.set(j, items.get(i));
                    items.set(i, tmp);
                }
        return items;
    }

    @Override
    public <E> ArrayList<E> Sort(ArrayList<E> items, int start, int end, Direction direction) {
       return  Sort(Copy(items),direction);
    }

    public BubbleSort() {
        name = this.getClass().getName();
    }

}
