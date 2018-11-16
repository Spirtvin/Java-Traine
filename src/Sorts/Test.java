package Sorts;

import Console.IOConsole;
import Generator.Generator;

import java.util.ArrayList;
import java.util.Collections;

public class Test extends Generator {

    /**
     *
     */
    private Sort sort;

    private IOConsole helper = new IOConsole();

    /**
     * @param message
     * @param ex
     */
    private void PrintException(String message, Exception ex) {
        // String str = String.format("%s:\n%s\n%s",message,ex.toString(),ex.getStackTrace());
        String str = String.format("%s:\n%s", message, ex.toString());
        System.out.println(str);
    }

    /**
     * @param results
     * @return
     */
    private boolean Check(ArrayList<Boolean> results) {
        for (int i = 0; i < results.size(); i++)
            if (results.get(i) == false)
                return false;
        return true;
    }

    /**
     * @param a
     * @param b
     * @return
     */
    private boolean Compare(ArrayList<Integer> a, ArrayList<Integer> b) {
        if (a.size() == b.size()) {
            for (int i = 0; i < a.size(); i++)
                if (a.get(i) != b.get(i))
                    return false;
            return true;
        } else
            return false;
    }

    private boolean CompareWithLog(ArrayList<Integer> a, ArrayList<Integer> b) {
        boolean result = Compare(a, b);
        if (!result) {
            helper.Out(a, "actual:");
            helper.Out(b, "expected:");
        }
        return result;
    }

    private ArrayList<Integer> Sort(ArrayList<Integer> sortList) {
        long start = System.currentTimeMillis();
        ArrayList<Integer> actual = sort.Sort(sortList, 0, sortList.size() - 1, Sort.Direction.asc);
        long end = System.currentTimeMillis();
        System.out.println("time(ms):" + (end - start));
        return actual;
    }

    /**
     * @param count
     * @return
     */
    public boolean Asc(int count) {
        ArrayList<Integer> sortList = GetAsc(count);
        ArrayList<Integer> actual = Sort(sortList);
        Collections.sort(sortList);
        return CompareWithLog(actual, sortList);
    }

    /**
     * @param count
     * @return
     */
    public boolean Desc(int count) {
        ArrayList<Integer> sortList = GetDesc(count);
        ArrayList<Integer> actual = Sort(sortList);
        Collections.sort(sortList);
        return CompareWithLog(actual, sortList);
    }

    /**
     * @param count
     * @return
     */
    public boolean Random(int count) {
        ArrayList<Integer> sortList = GetRandom(count);
        ArrayList<Integer> actual = Sort(sortList);
        Collections.sort(sortList);
        return CompareWithLog(actual, sortList);
    }

    /**
     * Запускает тетсы
     *
     * @param count количество элементов в массиве
     */
    public void Start(int count) {
        ArrayList<Boolean> results = new ArrayList<>();
        System.out.println("_________________________");
        System.out.println("Testing sort:" + sort.name);
        try {
            results.add(Asc(count));
            System.out.println("Ascending:" + results.get(results.size() - 1));
        } catch (Exception ex) {
            PrintException("Ascending", ex);
        }
        try {
            results.add(Desc(count));
            System.out.println("Descending:" + results.get(results.size() - 1));
        } catch (Exception ex) {
            PrintException("Descending", ex);
        }
        try {
            results.add(Random(count));
            System.out.println("Random:" + results.get(results.size() - 1));
        } catch (Exception ex) {
            PrintException("Random", ex);
        }
        if (Check(results))
            System.out.println("All tests passed!");
        else
            System.out.println("There're some errors!");
        System.out.println("_________________________");
    }

    public Test(Sort _sort) {
        sort = _sort;
    }
}
