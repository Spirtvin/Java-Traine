package Encryption.Block.Blocks;

import Common.Constants.Messages;
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
        return null;
    }

    public Long Encrypt(Binary value) throws Exception {
        if (value.GetLength() != 6)
            throw new Exception(Messages.Exceptions.sizeIncorrect);
        Long rowNumber = new Binary(value.Get(new int[]{0, 5})).ToLong();
        Long columnNumber = new Binary(value.Get(1, 4)).ToLong();
        return rowNumber * 16 + columnNumber;
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
