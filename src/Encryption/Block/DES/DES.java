package Encryption.Block.DES;


import Encryption.Block.Blocks.PBlock;

import java.io.IOException;

public class DES extends FeistelFunction {

    public DES() throws IOException {
        super();
    }

    public Integer[] EncryptFunction(Integer[] value, Integer key) {
        PBlock tmp = new PBlock();
        Integer[] encryptValue;
        encryptValue = tmp.Encrypt(value);
        Integer[] left = {};
        for (int i = 0; i < 16; i++) {
            encryptValue[i] = encryptValue[i] * (key + i);
        }
        for (int i = 0; i < encryptValue.length / 2; i++)
            left[i] = encryptValue[i];
        for (int i = 0; i < encryptValue.length / 2; i++)
            for (int j = encryptValue.length / 2; j < encryptValue.length; j++)
                encryptValue[i] = encryptValue[j];
        for (int i = encryptValue.length / 2; i < encryptValue.length; i++)
            encryptValue[i] = left[i];

        return encryptValue;
    }

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
