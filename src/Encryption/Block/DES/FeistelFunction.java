package Encryption.Block.DES;

import Helpers.FileIO;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;

public class FeistelFunction {
    private String[] fileNames = {"e", "ip0", "ip1", "s1", "s2", "s3", "s4", "s5", "s6", "s7", "s8"};
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

}
