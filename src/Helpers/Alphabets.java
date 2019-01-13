package Helpers;

public class Alphabets {
    public enum Alphabet {
        Cyrillic,
        Latin
    }

    public static String GetAlphabet(Alphabet type) {
        String str = "";
        if (type == Alphabet.Cyrillic) {
            for (int i = (int) 'а'; i <= (int) 'я'; i++)
                str += (char) i;
        } else {
            for (int i = (int) 'a'; i <= (int) 'z'; i++)
                str += (char) i;
        }
        return str;
    }

    public static String GetAlphabet(String character) {
        String str = "";
        if (character.length() > 0)
            return GetAlphabet(character.charAt(0));
        return str;
    }

    public static String GetAlphabet(char character) {
        String str = "";
        char c = character;
        if (c >= 'а' && c <= 'я')
            for (int i = (int) 'а'; i <= (int) 'я'; i++)
                str += (char) i;
        if (c >= 'a' && c <= 'z')
            for (int i = (int) 'a'; i <= (int) 'z'; i++)
                str += (char) i;
        return str;
    }

}
