package Encryption.Block.Blocks;

import Encryption.Binary;

//TODO: доделать S block
//http://protect.htmlweb.ru/des.htm
//см. пояснения к табл. 4
public class SBlock extends Block {
    /**
     * Функция  шифрования
     *
     * @param value - шифруемое значение
     * @return номер элемента в таблице шифрования, не само зашифрованное число
     */
    @Override
    public Integer Encrypt(Integer value) {
        try {
            Boolean[] bits = new Binary(value).ToNBit(6).GetBits();
            Integer rowNumber = new Binary(new Boolean[]{bits[0], bits[5]}).ToInt();
            Integer columnNnumber = new Binary(new Boolean[]{bits[1], bits[2], bits[3], bits[4]}).ToInt();
            return rowNumber * 16 + columnNnumber;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
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
