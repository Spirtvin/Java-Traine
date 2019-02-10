package Encryption.Block.DES;

import Helpers.FileIO;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;

public class FeistelFunction {
    private String[] fileNames = {"e", "ip0", "ip1", "s1", "s2", "s3", "s4", "s5", "s6", "s7", "s8", "p"};
    private HashMap<String, HashMap<Integer, Integer>> tables = new HashMap<>();


    public FeistelFunction() throws IOException {
        String pathToProject = Paths.get("").toAbsolutePath().toString();
        for (int i = 0; i < this.fileNames.length; i++)
            tables.put(this.fileNames[i], GetHashMap(pathToProject + "\\src\\Encryption\\Block\\DES\\tables\\" + this.fileNames[i] + ".txt"));
    }

    public HashMap<Integer, Integer> GetHashMap(String fileName) throws IOException {
        String[] items = FileIO.GetText(fileName).split(" ");
        HashMap<Integer, Integer> result = new HashMap<>();
        int index = 0;
        for (int i = 0; i < items.length; i++) {
            items[i] = items[i].replaceAll("\r\n", "");
            if (!items[i].equals(""))
                result.put(index++, Integer.valueOf(items[i]));
        }
        return result;
    }

    public Integer Encrypt(int value) {
//        SBlock sBlock = new SBlock();
//        Integer[] bits = sBlock.ToNBit(sBlock.IntToBin(value), 48);
//        Integer[] encryptedValues = new Integer[8];
//        for (int i = 0, f = 0; i < 48; f++, i += 6) {
//            Integer partValue = sBlock.BinToInt(new Integer[]{bits[i], bits[i + 1], bits[i + 2], bits[i + 3], bits[i + 4], bits[i + 5]});
//            int tableValue = sBlock.Encrypt(partValue);
//            int encrytedValue = tables.get("s" + (f + 1)).get(tableValue);
//            encryptedValues[f] = encrytedValue;
//        }
//        Integer[] result = new Integer[32];
//        for (int i = 0; i < 8; i++) {
//            Integer[] bitValue = sBlock.ToNBit(sBlock.IntToBin(encryptedValues[i]), 4);
//            for (int j = 0; j < 4; j++)
//                result[i * 4 + j] = bitValue[j];
//        }
        return null;
//        SBlock sBlock = new SBlock();
//        int tableValue = sBlock.Encrypt(value);
//        int encrytedValue = tables.get("s1").get(tableValue);
//        return encrytedValue;
    }

}