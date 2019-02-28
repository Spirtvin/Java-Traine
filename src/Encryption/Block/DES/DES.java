package Encryption.Block.DES;


import Common.Constants.Messages;
import Encryption.Binary;
import Encryption.Block.Blocks.SBlock;

import java.io.IOException;

/**
 * Шифрование DES
 *
 * @see <a href="https://ru.wikipedia.org/wiki/DES">Шифрование DES</a>
 */
public class DES extends FeistelNetwork {

    public DES() throws IOException {
        super();
    }

    /**
     * @param block 32-битный вектор вектор(левая или правая чать)
     * @param key   48-битный ключ
     * @return
     */
    public Binary EncryptFunction(Binary block, Binary key) throws Exception {
        Binary result = block.Swap(this.tables.get("e"));
        result = result.XOR(key);
        if (result.GetLength() != 48)
            throw new Exception(Messages.Exceptions.sizeNegative);
        SBlock sBlock = new SBlock();
        Binary temp = new Binary(0).ToNBit(32);
        for (int i = 0, f = 0, j = 0; i < result.GetLength(); f++, j += 4, i += 6) {
            Binary part = new Binary(result.Get(i, 6));
            Long tableValue = sBlock.Encrypt(part);
            Integer encryptedValue = tables.get("s" + (f + 1)).get(tableValue);
            Binary encryptedBits = new Binary(encryptedValue).ToNBit(4);
            temp.Set(j, encryptedBits.GetBits());
        }
        result = temp;
        return result.Swap(this.tables.get("p"));
    }


//    public Integer Encrypt(Integer value) {
//        try {
//            SBlock sBlock = new SBlock();
//            Boolean[] bits = new Binary(value).ToNBit(48).GetBits();
//            Integer[] encryptedValues = new Integer[8];
//            for (int i = 0, f = 0; i < 48; f++, i += 6) {
//                Integer partValue = new Binary(new Boolean[]{bits[i], bits[i + 1], bits[i + 2], bits[i + 3], bits[i + 4], bits[i + 5]}).ToInt();
//                int tableValue = sBlock.Encrypt(partValue);
//                int encrytedValue = tables.get("s" + (f + 1)).get(tableValue);
//                encryptedValues[f] = encrytedValue;
//            }
//            Boolean[] result = new Boolean[Integer.SIZE];
//            for (int i = 0; i < 8; i++) {
//                bits = new Binary(encryptedValues[i]).ToNBit(4).GetBits();
//                for (int j = 0; j < 4; j++)
//                    result[i * 4 + j] = bits[j];
//            }
//            return new Binary(result).ToInt();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public String EncryptFunction(String value, Integer key) {

        return null;
    }

    public String DecryptFunction(Integer[] value, Integer key) {

        return null;
    }

    public String DecryptFunction(String value, Integer key) {

        return null;
    }

}
