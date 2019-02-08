package Encryption.Block.Blocks;

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
//        Integer[] tmp = IntToBin(value);
//        tmp = ToNBit(tmp, 6);
//        Integer rowNumber = BinToInt(new Integer[]{tmp[0], tmp[tmp.length - 1]});
//        Integer columNnumber = BinToInt(new Integer[]{tmp[1], tmp[2], tmp[3], tmp[4]});
//        return rowNumber * 16 + columNnumber;
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
