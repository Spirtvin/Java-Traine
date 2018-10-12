package Sorts.Merge;

import Sorts.Sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Сортировка слиянием
 */
public class MergeSort extends Sort {

    public <E> ArrayList<E> Sort(ArrayList<E> items, Direction direction) {
        Integer[] copy = new Integer[items.size()];
        copy = items.toArray(copy);
        copy = SortOuter(copy);
        return Convert(copy);
    }

    @Override
    public <E> ArrayList<E> Sort(ArrayList<E> items, int start, int end, Direction direction) {
        ArrayList<E> copy = Copy(items, start, end);
        return Sort(copy, direction);
    }

    public static Integer[] SortOuter(Integer[] array1) {
        Integer[] buffer1 = Arrays.copyOf(array1, array1.length);
        Integer[] buffer2 = new Integer[array1.length];
        Integer[] result = SortInner(buffer1, buffer2, 0, array1.length);
        return result;
    }

    public static Integer[] SortInner(Integer[] buffer1, Integer[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        // уже отсортирован.
        int middle = startIndex + (endIndex - startIndex) / 2;
        Integer[] sorted1 = SortInner(buffer1, buffer2, startIndex, middle);
        Integer[] sorted2 = SortInner(buffer1, buffer2, middle, endIndex);

        // Слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        Integer[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }

    public MergeSort() {
        name = this.getClass().getName();
    }

}