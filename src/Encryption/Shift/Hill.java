package Encryption.Shift;

import Common.Exceptions.NotImplementedException;
import DataStructures.Matrix.Matrix;
import Encryption.Encryption;
import Helpers.Alphabets;

import java.util.Random;

/**
 * Шифрование методом Хилла
 *
 * @see <a href="https://goo.gl/W75WwN">Шифр Хилла</a>
 * @see <a href="https://goo.gl/PYifif">Шифр Хилла. Подробный разбор</a>
 */
public class Hill extends Encryption {

    private String alphabet;
    private Matrix keyMatrix;

    public Hill() {
        this.alphabet = Alphabets.GetAlphabet(Alphabets.Alphabet.Latin) + ",!?";
    }

    public Hill(String alphabet) {
        this.alphabet = alphabet;
    }

    public Matrix GetKey() {
        return keyMatrix;
    }

    @Override
    public String EncryptFunction(String value, Integer key) {
        return null;
    }

    @Override
    public String EncryptFunction(String value, String key) {
        Matrix<Double> keyMatrix = new Matrix<>(value.length());
        Random random = new Random();
        for (int i = 0; i < value.length(); i++)
            for (int j = 0; j < value.length(); j++) {
                int rand = random.nextInt();
                if (rand == 0)
                    rand++;
                keyMatrix.Set(i, j, (double) (Math.abs(rand) % alphabet.length()));
            }
        Matrix<Double> messageMatrix = new Matrix<>(value.length(), 1);
        for (int i = 0; i < value.length(); i++)
            messageMatrix.Set(i, 0, (double) (alphabet.indexOf(value.charAt(i)) % alphabet.length()));
        this.keyMatrix = keyMatrix;
        return (keyMatrix.Mul(messageMatrix).Mod(alphabet.length())).toString();
    }

    @Override
    public String DecryptFunction(String value, Integer key) {
        return null;
    }

    @Override
    public String DecryptFunction(String value, String key) {
        Matrix matrixValue = new Matrix(value);
        Matrix matrixKey = new Matrix(key);
        try {
            //TODO:проверить на ошибки
            return matrixKey.Inverse(this.alphabet.length()).Mul(matrixValue).Mod(this.alphabet.length()).toString();
        } catch (Exception ex) {
            System.out.println((ex.getMessage()));
            return null;
        }
    }

    @Override
    public String Encrypt(String value, String key) {
        return EncryptFunction(value, key);
    }

    @Override
    public String Encrypt(String value, Integer key) throws NotImplementedException {
        return null;
    }

    @Override
    public String Decrypt(String encryptedValue, String key) {
        return DecryptFunction(encryptedValue, key);
    }

    @Override
    public String Decrypt(String encryptedValue, Integer key) throws NotImplementedException {
        return null;
    }
}
