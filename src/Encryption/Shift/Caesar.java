package Encryption.Shift;

import Common.Exceptions.NotImplementedException;
import Encryption.Encryption;

/**
 * Шифр Цезаря
 */
public class Caesar extends Encryption {
    Integer start = 0;
    Integer count = 0;

    public void GetSymbolInfo(char c) {
        if (c >= 'A' && c <= 'Z') {
            start = (int) 'A';
            count = 26;
        }
        if (c >= 'a' && c <= 'z') {
            start = (int) 'a';
            count = 26;
        }
        if (c >= 'а' && c <= 'я') {
            start = (int) 'а';
            count = 32;
        }
        if (c >= 'А' && c <= 'Я') {
            start = (int) 'А';
            count = 32;
        }
        if (c >= ' ' && c <= '@') {
            start = (int) ' ';
            count = 32;
        } else
            count = 32;
    }


    /**
     * Функция шифрования
     *
     * @param value значение
     * @param key   ключ
     * @return
     */
    @Override
    public String EncryptFunction(String value, Integer key) {
        String res = "";
        for (int i = 0; i < value.length(); i++) {
            GetSymbolInfo(value.charAt(i));
            int offset = ((int) value.charAt(i) - start + key) % count;
            res += (char) (start + offset);
        }
        return res;
    }

    /**
     * Функция шифрования
     *
     * @param value значение
     * @param key   ключ
     * @return
     */
    @Override
    public String EncryptFunction(String value, String key) {
        return EncryptFunction(value, Integer.valueOf(key));
    }

    /**
     * функция дешифрования
     *
     * @param value значение
     * @param key   ключ
     * @return
     */
    @Override
    public String DecryptFunction(String value, Integer key) {
        String res = "";
        for (int i = 0; i < value.length(); i++) {
            GetSymbolInfo(value.charAt(i));
            int code = (int) value.charAt(i) - start;
            while (key > 0) {
                code = code - 1;
                if (code < 0)
                    code = count - 1;
                key--;
            }
            res += (char) (start + code);
        }
        return res;
    }

    /**
     * функция дешифрования
     *
     * @param value значение
     * @param key   ключ
     * @return
     */
    @Override
    public String DecryptFunction(String value, String key) {
        return DecryptFunction(value, key);
    }

    /**
     * Дешифрует указанное значение
     *
     * @param encryptedValue зашифрованное значение
     * @param key            ключ
     * @return
     */
    @Override
    public String Decrypt(String encryptedValue, String key) {
        return DecryptFunction(encryptedValue, key);
    }

    /**
     * Дешифрует указанное значение
     *
     * @param encryptedValue зашифрованное значение
     * @param key            ключ
     * @return
     */
    @Override
    public String Decrypt(String encryptedValue, Integer key) throws NotImplementedException {
        return DecryptFunction(encryptedValue, key);
    }

    /**
     * Шифрует указанное значение
     *
     * @param value значение
     * @param key   ключ
     * @return
     */
    @Override
    public String Encrypt(String value, String key) {
        return EncryptFunction(value, Integer.valueOf(key));
    }

    /**
     * Шифрует указанное значение
     *
     * @param value значение
     * @param key   ключ
     * @return
     */
    @Override
    public String Encrypt(String value, Integer key) throws NotImplementedException {
        return EncryptFunction(value, key);
    }


}
