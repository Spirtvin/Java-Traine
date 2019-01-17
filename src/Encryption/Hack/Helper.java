package Encryption.Hack;

import Common.Constants.Integers;
import Helpers.FileIO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Helper {
    /**
     * список алфавитов
     */
    private ArrayList<HashMap<String, String>> alpabets = new ArrayList<>();

    /**
     *
     */
    public Helper() {
    }

    /**
     * @param fileNames пути до .txt файлов с частотностью букв для определенного алфафита
     * @see <a href="https://ru.wikipedia.org/wiki/Частотность">Частотность букв русского языка</a>
     */
    public Helper(String[] fileNames) throws IOException {
        for (String name : fileNames)
            alpabets.add(FileIO.GetHashMap(name));
    }

    public Helper(HashMap<Character, Double> alphabet) {
        Object[] keys = alphabet.keySet().toArray();
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            String key = keys[i].toString();
            String value = alphabet.get(key.charAt(0)).toString();
            map.put(key, value);
        }
        alpabets.add(map);
    }

    private Integer GetAlphabet(String character) {
        for (int i = 0; i < alpabets.size(); i++)
            if (alpabets.get(i).containsKey(character))
                return i;
        return Integers.notfoundIndex;
    }

    private Integer GetAlphabet(char c) {
        return GetAlphabet(c + "");
    }

    public HashMap<Character, Double> GetFrequency(String str) {
        HashMap<Character, Double> items = new HashMap<>();
        for (int i = 0; i < str.length(); i++)
            if (!items.containsKey(str.charAt(i)))
                items.put(str.charAt(i), 1.0);
            else
                items.put(str.charAt(i), items.get(str.charAt(i)).intValue() + 1.0);
        int length = str.length();
        while (str.length() > 0) {
            items.put(str.charAt(0), items.get(str.charAt(0)) / length);
            str = str.replace("" + str.charAt(0), "");
        }

        return items;
    }

    private HashMap<Character, Character> GetDictionary(HashMap<Character, Double> dictionary) {
        Object[] textCharacters = dictionary.keySet().toArray();
        HashMap<Character, Character> decryptedMap = new HashMap<>();
        for (int i = 0; i < textCharacters.length; i++) {
            char encryptedChar = Character.valueOf(textCharacters[i].toString().charAt(0));
            int index = GetAlphabet(encryptedChar);
            if (index != -1) {
                Object[] decryptedChars = alpabets.get(index).keySet().toArray();
                double dx = Double.MAX_VALUE;
                double fEncrypted = Double.valueOf(dictionary.get(encryptedChar));
                String resultChar = "-";
                for (int j = 0; j < decryptedChars.length; j++) {
                    String decryptedChar = decryptedChars[j].toString();
                    double fDecrypted = Double.valueOf(alpabets.get(index).get(decryptedChar));
                    if (Math.abs(fDecrypted - fEncrypted) < dx) {
                        resultChar = decryptedChar;
                        dx = Math.abs(fDecrypted - fEncrypted);
                    }
                }
                decryptedMap.put(encryptedChar, resultChar.charAt(0));
            } else {
                decryptedMap.put(encryptedChar, encryptedChar);
            }
        }
        return decryptedMap;
    }

    public String Hack(String encryptedStr) {
        HashMap<Character, Character> decryptedDictionary = GetDictionary(GetFrequency(encryptedStr));
        String decryptedStr = "";
        for (int i = 0; i < encryptedStr.length(); i++) {
            char c = encryptedStr.charAt(i);
            if (decryptedDictionary.containsKey(c))
                decryptedStr += decryptedDictionary.get(c);
            else
                decryptedStr += c;
        }
        return decryptedStr;
    }
}
