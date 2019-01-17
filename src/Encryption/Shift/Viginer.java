package Encryption.Shift;

import Common.Exceptions.NotImplementedException;

public class Viginer extends Caesar {

    public String GetKey(String value, String key) {
        String tempKey = key;
        int index = 0;
        while (value.length() > tempKey.length()) {
            index = (index) % key.length();
            tempKey += key.charAt(index);
            index++;
        }
        while (value.length() < tempKey.length()) {
            tempKey = tempKey.substring(0, tempKey.length() - 1);
        }
        return tempKey;
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
        return super.EncryptFunction(value, key);
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
        key = GetKey(value, key);
        for (int i = 0; i < key.length(); i++) {
            super.GetSymbolInfo(key.charAt(i));
            int offset = (int) key.charAt(i) - start;
            str += EncryptFunction(String.valueOf(value.charAt(i)), offset);
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
        return super.DecryptFunction(value, key);
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
        String str = "";
        key = GetKey(value, key);
        for (int i = 0; i < key.length(); i++) {
            super.GetSymbolInfo(key.charAt(i));
            int offset = (int) key.charAt(i) - start;
            str += DecryptFunction(String.valueOf(value.charAt(i)), offset);
        }
        return str;
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
    public String Encrypt(String value, Integer key) throws NotImplementedException {
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
        throw new NotImplementedException();
    }


}
