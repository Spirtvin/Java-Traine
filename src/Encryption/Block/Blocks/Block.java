package Encryption.Block.Blocks;


/**
 * Блок шифрования
 */
public abstract class Block {
    public int size = Integer.SIZE - 1;



    /**
     * @param values
     * @return
     */
    public Integer[] To32Bit(Integer[] values) {
        Integer[] result = new Integer[size];
        for (int i = 0; i < size; i++)
            result[i] = 0;
        for (int i = 0; i < values.length; i++)
            result[result.length - 1 - i] = values[values.length - 1 - i];
        return result;
    }

    /**
     * Функция  шифрования
     *
     * @param value - шифруемое значение
     * @return результат шифрования
     */
    public abstract Integer Encrypt(Integer value);

    /**
     * Функция  дешифрования
     *
     * @param value - дешифруемое значение
     * @return результат деширования
     */
    public abstract Integer Decrypt(Integer value);

    /**
     * Функция  шифрования
     *
     * @param values - шифруемый массив
     * @return результат шифрования
     */
    public Integer[] Encrypt(Integer[] values) {
        for (int i = 0; i < values.length; i++)
            values[i] = Encrypt(values[i]);
        return values;
    }

    /**
     * Функция  шифрования
     *
     * @param values - дешифруемый массив
     * @return результат шифрования
     */
    public Integer[] Decrypt(Integer[] values) {
        for (int i = 0; i < values.length; i++)
            values[i] = Decrypt(values[i]);
        return values;
    }

    /**
     * Функция  шифрования
     *
     * @param value - шифруемая строка
     * @return результат шифрования
     */
    public String Encrypt(String value) {
        String str = "";
        for (int i = 0; i < value.length(); i++)
            str += Encrypt((int) value.charAt(i));
        return str;
    }

    /**
     * Функция  шифрования
     *
     * @param value - дешифруемая строка
     * @return результат шифрования
     */
    public String Decrypt(String value) {
        String str = "";
        for (int i = 0; i < value.length(); i++)
            str += Decrypt((int) value.charAt(i));
        return str;
    }
}
