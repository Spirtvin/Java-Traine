package Evklid;

/**
 * Расширенный алгорит Евклида
 */
public class EuclidAdv {
    /**
     * Ище НОД для двух чисел
     * расширенным алгоритмом Евклида
     *
     * @param a первое число
     * @param b второе число
     * @return Массив значений
     * <p>[ GCD, X, Y ]</p>
     * <p>для урванения: X*a+Y*b=1</p>
     * @see <a href="http://e-maxx.ru/algo/reverse_element">Обратный элемент в кольце по модулю</a>
     * @see <a href="http://www.e-maxx-ru.1gb.ru/algo/extended_euclid_algorithm">Расширенный алгоритм Евклида</a>
     */
    public static Integer[] GCD(int a, int b) {
        Integer[] res = new Integer[3]; // d, x, y
        if (b == 0) {
            res[0] = a;
            res[1] = 1;
            res[2] = 0;
            return res;
        }
        res = GCD(b, a % b);
        int s = res[2];
        res[2] = res[1] - (a / b) * res[2];
        res[1] = s;
        return res;
    }
}
