package Encryption.Block.Blocks;

import Helpers.Arrays;
import Helpers.Converter;

import java.util.ArrayList;
import java.util.HashMap;

public class PBlock extends Block {
    private int size = Integer.SIZE - 1;
    private HashMap<Integer, Integer> key;

    public PBlock() {
        key = new HashMap<>();
        for (int i = 0; i < size; i++)
            key.put(i, size - 1 - i);
    }

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

    private Integer[] To32Bit(Integer[] values) {
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
    @Override
    public Integer Encrypt(Integer value) {
        Integer[] valueBin = To32Bit(IntToBin(value));
        Integer[] result = new Integer[valueBin.length];
        for (int i = 0; i < result.length; i++)
            result[i] = 0;
        for (int i = 0; i < valueBin.length; i++) {
            result[i] = valueBin[key.get(i)];
        }
        return BinToInt(result);
    }


    /**
     * Функция  дешифрования
     *
     * @param value - дешифруемое значение
     * @return результат деширования
     */
    @Override
    public Integer Decrypt(Integer value) {
        Integer[] valueBin = To32Bit(IntToBin(value));
        Integer[] result = new Integer[valueBin.length];
        for (int i = 0; i < result.length; i++)
            result[i] = 0;
        for (int i = 0; i < valueBin.length; i++)
            result[key.get(i)] = valueBin[i];
        return BinToInt(result);

    }
}
