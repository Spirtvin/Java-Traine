package Encryption;

import Common.Exceptions.NotImplementedException;

/**
 * Метод шифрования
 */
public abstract class Encryption {

    /**
     * Получает таблицу ASCII символов
     *
     * @return
     */
    public String GetASCIITable() {
        String str = "";
        for (int i = 32; i < 255; i++)
            str += String.format("%c %d\n", i, i);
        return str;
    }

    enum Alphabet {
        Cyrillic,
        Latin
    }

    /**
     * Получает алфавит определенного типа
     *
     * @param type
     * @return
     */
    public String GetAlphabet(Alphabet type) {
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

    /**
     * Создает метод шифрования
     */
    public Encryption() {
    }

    /**
     * Функция шифрования
     *
     * @param value значение
     * @param key   ключ
     * @return
     */
    public abstract String EncryptFunction(String value, Integer key);

    /**
     * Функция шифрования
     *
     * @param value значение
     * @param key   ключ
     * @return
     */
    public abstract String EncryptFunction(String value, String key);

    /**
     * функция дешифрования
     *
     * @param value значение
     * @param key   ключ
     * @return
     */
    public abstract String DecryptFunction(String value, Integer key);

    /**
     * функция дешифрования
     *
     * @param value значение
     * @param key   ключ
     * @return
     */
    public abstract String DecryptFunction(String value, String key);

    /**
     * Шифрует указанное значение
     *
     * @param value значение
     * @param key   ключ
     * @return
     */
    public abstract String Encrypt(String value, String key);

    /**
     * Шифрует указанное значение
     *
     * @param value значение
     * @param key   ключ
     * @return
     */
    public abstract String Encrypt(String value, Integer key) throws NotImplementedException;

    /**
     * Дешифрует указанное значение
     *
     * @param encryptedValue зашифрованное значение
     * @param key            ключ
     * @return
     */
    public abstract String Decrypt(String encryptedValue, String key);

    /**
     * Дешифрует указанное значение
     *
     * @param encryptedValue зашифрованное значение
     * @param key            ключ
     * @return
     */
    public abstract String Decrypt(String encryptedValue, Integer key) throws NotImplementedException;
}
