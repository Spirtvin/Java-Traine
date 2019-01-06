package Evklid;


/**
 * Алгорит Евклида.
 */
public class EuclidStd {
    /**
     * Нахождение  НОД
     */
    public Integer GCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0 || a == 0)
            return 0;
        while (a != b && b != a)
            if (a > b)
                a = a - b;
            else
                b = b - a;
        return a;
    }
}
