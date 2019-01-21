package Encryption.Block.Blocks;

import Helpers.Converter;

import java.util.ArrayList;
import java.util.HashMap;

public class PBlock extends Block {
    private HashMap<Integer, Integer> key;

    public PBlock() {
        key = new HashMap<>();
        for (int i = 0; i < Integer.SIZE; i += Byte.SIZE)
            key.put(i, Integer.SIZE - 1 - i);
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
        else
            while (value > 0) {
                result.add(value % 2);
                value = value >> 1;
            }
        for (int i = 0; i != (result.size() / 2); i++) {
            int tmpIndex = result.size() - 1 - i;
            Integer tmp = result.get(tmpIndex);
            result.set(tmpIndex, result.get(i));
            result.set(i, tmp);
        }
        return Converter.ArrayLists.Convert(result);
    }

    /**
     * Переводит число из двоичного кода в десятичный
     *
     * @param values
     * @return
     */
    public Integer BinToInt(ArrayList<Integer> values) {
        Integer result = 0;
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) == 1)
                result += 1;
            if (i != values.size() - 1)
                result = result << 1;
        }
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
        return null;
    }

    /**
     * Функция  дешифрования
     *
     * @param value - дешифруемое значение
     * @return результат деширования
     */
    @Override
    public Integer Decrypt(Integer value) {
        return null;
    }
}
