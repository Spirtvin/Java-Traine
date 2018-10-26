package Helpers;

public class Str {
    public static boolean IsPolyndrom(String str) {
        for (int i = 0; i < str.length() / 2; i++)
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        return true;
    }

    /**
     * проверка строки на полиндром
     *
     * @param str строка для проверки
     * @return true - если строка палиндром
     */
    public static boolean IsPolyndrom2(String str) {
        String str2 = "";
        for (int i = str.length() - 1; i >= 0; i--)
            str2 += str.charAt(i);
        return str2.equals(str);
    }
}
