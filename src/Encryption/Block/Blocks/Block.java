package Encryption.Block.Blocks;


import Helpers.Arrays;
import Helpers.Converter;

import java.util.ArrayList;

/**
 * Блок шифрования
 */
public abstract class Block {
    public int size = Integer.SIZE - 1;

    /**
     * Переводит число в двоичный вид
     *
     * @param value значение для перевода
     * @return
     */
    public Integer[] IntToBin(Integer value) {
        ArrayList<Integer> result = new ArrayList<>();
        if (value == 0)
            result.add(0);
        else {
            value = Math.abs(value);
            while (value > 0) {
                result.add(value % 2);
                value = value >> 1;
            }
        }
        return new Arrays<Integer>().Reverse(Converter.ArrayLists.Convert(result));
    }

    /**
     * Переводит число из двоичного кода в десятичный
     *
     * @param values
     * @return
     */
    public Integer BinToInt(Integer[] values) {
        Integer result = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == 1)
                result += 1;
            if (i != values.length - 1)
                result = result << 1;
        }
        return result;
    }

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

    public Integer[] ToNBit(Integer[] values, int size) {
        if (size > 0) {
            Integer[] result = new Integer[size];
            for (int i = 0; i < size; i++)
                result[i] = 0;
            for (int i = 0; i < values.length; i++)
                result[result.length - 1 - i] = values[values.length - 1 - i];
            return result;
        }
        return new Integer[]{};

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
