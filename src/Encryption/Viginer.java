package Encryption;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Viginer extends Caesar {

    public Integer Count(String value, String key) {
        Integer res = 0;
        Integer count = 1;
        Integer start = 0;
        if (value.length() > 0) {
            char c = value.charAt(0);
            if (c >= 'a' && c <= 'z') {
                start = (int) 'a';
                count = 26;
            }
            if (c >= 'а' && c <= 'я') {
                start = (int) 'а';
                count = 32;
            }
        }
        for (int i = 0; i < count; i++) {
            if (key.charAt(0) == start + i)
                res = start + i;
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
    public String EncryptFunction(String value, Integer key) {
        throw new NotImplementedException();

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
        String str = "";
        String tempKey = key;
        int index = 0;
        while (value.length() >= tempKey.length()) {
            index = (index) % key.length();
            tempKey += key.charAt(index);
            index++;
        }
        for (int i = 0; i < tempKey.length(); i++) {
            //TODO: доделать шифр
            //super.Encrypt(ОДИН СИМВОЛ ИСХОДНОЙ СТРОКИ!!!,ТЕКУЩЕЕ СМЕЩЕНИЕ!!!!);

        }
        return str;
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
        return null;
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
        return null;
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
        return EncryptFunction(value, key);
    }


    /**
     * Шифрует указанное значение
     *
     * @param value значение
     * @param key   ключ
     * @return
     */
    @Override
    public String Encrypt(String value, Integer key) {
        throw new NotImplementedException();
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
        return null;
    }

    /**
     * Дешифрует указанное значение
     *
     * @param encryptedValue зашифрованное значение
     * @param key            ключ
     * @return
     */
    @Override
    public String Decrypt(String encryptedValue, Integer key) {
        throw new NotImplementedException();
    }


}
