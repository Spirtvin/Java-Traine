package Encryption.Block.Blocks;

import java.util.HashMap;

public class PBlock extends Block {

    private HashMap<Integer, Integer> key;

    public PBlock() {
        key = new HashMap<>();
        for (int i = 0; i < size; i++)
            key.put(i, size - 1 - i);
    }


    /**
     * Функция  шифрования
     *
     * @param value - шифруемое значение
     * @return результат шифрования
     */
    @Override
    public Integer Encrypt(Integer value) {
//        Integer[] valueBin = To32Bit(IntToBin(value));
//        Integer[] result = new Integer[valueBin.length];
//        for (int i = 0; i < result.length; i++)
//            result[i] = 0;
//        for (int i = 0; i < valueBin.length; i++) {
//            result[i] = valueBin[key.get(i)];
//        }
//        return BinToInt(result);
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
//        Integer[] valueBin = To32Bit(IntToBin(value));
//        Integer[] result = new Integer[valueBin.length];
//        for (int i = 0; i < result.length; i++)
//            result[i] = 0;
//        for (int i = 0; i < valueBin.length; i++)
//            result[key.get(i)] = valueBin[i];
//        return BinToInt(result);
        return null;
    }
}
