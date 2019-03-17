package Encryption.Block.DES;

import Common.Exceptions.NotImplementedException;
import Encryption.Binary;
import Helpers.Arrays;
import Helpers.FileIO;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * Функция Фейстеля
 *
 * @see <a href="https://ru.wikipedia.org/wiki/Сеть_Фейстеля">Сеть Фейстеля</a>
 */
@SuppressWarnings("ALL")
public class FeistelNetwork {
    /**
     * Именя файлов, содержащих таблицы битов
     */
    public String[] fileNames = {"e", "ip0", "ip1", "s1", "s2", "s3", "s4", "s5", "s6", "s7", "s8", "p"};

    /**
     * Таблицы перестановок
     */
    public HashMap<String, HashMap<Integer, Integer>> tables = new HashMap<>();

    /**
     * Создает сеть Фейстеля
     *
     * @throws IOException
     */
    public FeistelNetwork() throws IOException {
        String pathToProject = Paths.get("").toAbsolutePath().toString();
        for (int i = 0; i < this.fileNames.length; i++)
            tables.put(this.fileNames[i], GetHashMap(pathToProject + "\\src\\Encryption\\Block\\DES\\tables\\" + this.fileNames[i] + ".txt"));
    }

    /**
     * Составляет таблицу перестановок
     *
     * @param fileName
     * @return
     * @throws IOException
     */
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

    public Long Encrypt(Long value, Binary keys[]) throws Exception {
        Binary binValue = new Binary(value);

        binValue = binValue.Swap(this.tables.get("ip0"));

        Binary left = binValue.GetHighest();
        Binary right = binValue.GetLowest();
        for (int i = 0; i < keys.length; i++) {
            Binary temp = left;
            left = this.EncryptFunction(left, keys[i]);
            left = left.XOR(right);
            right = left;
        }
        binValue.SetHighest(right);
        binValue.SetLowest(left);

        binValue = binValue.Swap(this.tables.get("ip1"));

        return binValue.ToLong();
    }

    public Long Decrypt(Long value, Binary keys[]) throws Exception {
        Arrays<Binary> arraysHelper = new Arrays<>();
        keys = arraysHelper.Reverse(keys);
        return Encrypt(value, keys);
    }


    /**
     * @param part 32-битный вектор вектор(левая или правая чать)
     * @param key  48-битный ключ
     * @return
     */
    public Binary EncryptFunction(Binary block, Binary key) throws Exception {
        throw new NotImplementedException();
    }
}
