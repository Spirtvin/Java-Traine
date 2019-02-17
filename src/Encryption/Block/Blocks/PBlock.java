package Encryption.Block.Blocks;

import Encryption.Binary;

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
        try {
            Binary binary = new Binary(value).ToNBit(Integer.SIZE);
            Boolean[] bits = binary.GetBits();
            for (int i = 0; i < bits.length; i++) {
                Boolean temp = bits[i];
                bits[i] = bits[key.get(i)];
                bits[key.get(i)] = temp;
            }
            return new Binary(bits).ToInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        try {
            Binary binary = new Binary(value).ToNBit(Integer.SIZE);
            Boolean[] bits = binary.GetBits();
            for (int i = 0; i < bits.length; i++) {
                Boolean tmp = bits[key.get(i)];
                bits[key.get(i)] = bits[i];
                bits[i] = tmp;
            }
            return new Binary(bits).ToInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
