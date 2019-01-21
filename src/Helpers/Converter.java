package Helpers;

import java.util.ArrayList;

public class Converter {
    public static class ArrayLists {
        public static Integer[] Convert(ArrayList<Integer> values) {
            Integer[] result = new Integer[values.size()];
            for (int i = 0; i < values.size(); i++)
                result[i] = values.get(i);
            return result;
        }

        public static ArrayList<Integer> Convert(Integer[] values) {
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < values.length; i++)
                result.add(values[i]);
            return result;
        }
    }

    public static class Arrays {
        public static int[] Convert(Integer[] values) {
            int[] result = new int[values.length];
            for (int i = 0; i < values.length; i++)
                result[i] = values[i].intValue();
            return result;
        }
    }
}
