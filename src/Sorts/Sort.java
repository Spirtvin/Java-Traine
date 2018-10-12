package Sorts;

import java.util.ArrayList;

public abstract class Sort {


    //<editor-fold desc="Fields">

    /**
     * напрвление сортировки
     */
    public enum Direction {
        /**
         * по возростанию.
         */
        asc,
        /**
         * по убыванию
         */
        desc
    }

    /**
     * название сортировки
     */
    public String name;
    //</editor-fold>

    //<editor-fold desc="Methods">
    public <E> boolean Compare(E a, E b, Direction direction) {
        return Compare((Integer) a, (Integer) b, direction);
    }

    public boolean Compare(Integer a, Integer b, Direction direction) {
        boolean result = false;
        if (a > b)
            result = true;
        if (direction == Direction.desc)
            return !result;
        return result;
    }

    public <E> ArrayList<E> Copy(ArrayList<E> items, int from, int to) {
        ArrayList<E> copy = new ArrayList<>();
        if (from > -1 && from < to && to > -1) {
            for (int i = from; i <= to; i++)
                copy.add(items.get(i));
        }
        return copy;
    }

    public <E> ArrayList<E> Copy(ArrayList<E> items) {
        return Copy(items, 0, items.size() - 1);
    }

    public <E> ArrayList<E> Convert(Integer[] a) {
        ArrayList<E> result = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
            result.add((E) a[i]);
        return result;
    }

    public abstract <E> ArrayList<E> Sort(ArrayList<E> items, Direction direction);

    public abstract <E> ArrayList<E> Sort(ArrayList<E> items, int start, int end, Direction direction);
    //</editor-fold>
}
