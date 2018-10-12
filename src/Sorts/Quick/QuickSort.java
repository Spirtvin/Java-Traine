package Sorts.Quick;

import Sorts.Sort;

import java.util.ArrayList;

public class QuickSort extends Sort {

    @Override
    public <E> ArrayList<E> Sort(ArrayList<E> items, Direction direction) {
        return null;
    }

    //http://www.javenue.info/post/45

    @Override
    public <E> ArrayList<E> Sort(ArrayList<E> items, int start, int end, Direction direction) {
        ArrayList<E> copy = Copy(items);
        QSort(copy, start, end, direction);
        return copy;

    }

    public <E> void QSort(ArrayList<E> items, int start, int end, Direction direction) {
        int mIndex = start + (end - start) / 2;
        if (end <= start || start < 0 || end < 0 || mIndex < 0 || end - start < 1)
            return;
        int mElem = (Integer) items.get(mIndex);
        int low = start, high = end;
        while (low < high) {
            //while (low < mIndex && (Integer) items.get(low) <= mElem)
            while (low < mIndex && !Compare(items.get(low), mElem, direction))
                low++;
            //while (high > mIndex && (Integer) items.get(high) >= mElem)
            while (high > mIndex && Compare(items.get(high), mElem, direction))
                high--;
            if (low < high) {
                E swapTmp = items.get(low);
                items.set(low, items.get(high));
                items.set(high, swapTmp);
                if (low == mIndex)
                    mIndex = high;
                else if (high == mIndex)
                    mIndex = low;
            }
        }
        QSort(items, start, mIndex-1 , direction);
        QSort(items, mIndex + 1, end, direction);
    }

    public QuickSort() {
        name = this.getClass().getName();
    }
}
