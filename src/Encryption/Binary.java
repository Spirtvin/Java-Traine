package Encryption;

import Common.Constants.Messages;
import Encryption.TruthTables.Tables;
import Helpers.Arrays;
import Helpers.Converter;

public class Binary {

    private Arrays<Boolean> helper = new Arrays<Boolean>();

    private Boolean[] bits;

    public Binary() {
        this.bits = new Boolean[]{};
    }

    public Binary(Boolean[] bits) {
        this.bits = bits;
    }

    public Binary(Integer value) throws Exception {
        this.bits = this.IntToBin(value).GetBits();
    }

    public Boolean Get(int index) throws Exception {
        if (helper.Check(this.bits, index))
            return this.bits[index];
        else
            throw new Exception(Messages.Exceptions.indexIncorrect);
    }

    public Boolean[] GetBits() {
        return this.bits;
    }

    public void Set(int index, Boolean value) throws Exception {
        if (helper.Check(this.bits, index))
            this.bits[index] = value;
        else
            throw new Exception(Messages.Exceptions.indexIncorrect);

    }

    public void Set(int index, Integer value) throws Exception {
        if (value > -1 && value < 2)
            this.Set(index, value);
        else
            throw new Exception(Messages.Exceptions.valueIncorrect);
    }

    public Integer GetLength() {
        return this.bits.length;
    }

    public Binary ToNBit(int size) throws Exception {
        if (size > 0) {
            if (size == this.GetLength())
                return new Binary(this.bits);
            Boolean[] result = new Boolean[size];
            for (int i = 0; i < size; i++)
                result[i] = false;
            for (int i = 0; i < this.bits.length; i++)
                result[result.length - 1 - i] = this.bits[this.bits.length - 1 - i];
            return new Binary(result);
        } else
            throw new Exception(Messages.Exceptions.sizeNegative);
    }

    public Binary XOR(Binary value) throws Exception {
        Integer length = Math.max(this.GetLength(), value.GetLength());
        Binary b1 = this.ToNBit(length);
        Binary b2 = value.ToNBit(length);
        Binary result = new Binary();
        result = result.ToNBit(length);
        for (int i = 0; i < length; i++)
            result.Set(i, Tables.XOR(b1.Get(i), b2.Get(i)));
        return result;
    }

    public Binary AND(Binary value) throws Exception {
        Integer length = Math.max(this.GetLength(), value.GetLength());
        Binary b1 = this.ToNBit(length);
        Binary b2 = value.ToNBit(length);
        Binary result = new Binary();
        result = result.ToNBit(length);
        for (int i = 0; i < length; i++)
            result.Set(i, Tables.AND(b1.Get(i), b2.Get(i)));
        return result;
    }

    public Binary OR(Binary value) throws Exception {
        Integer length = Math.max(this.GetLength(), value.GetLength());
        Binary b1 = this.ToNBit(length);
        Binary b2 = value.ToNBit(length);
        Binary result = new Binary();
        result = result.ToNBit(length);
        for (int i = length - 1; i >= 0; i--)
            result.Set(i, Tables.OR(b1.Get(i), b2.Get(i)));
        return result;
    }

    /**
     * Переводит число в двоичный вид
     *
     * @param value значение для перевода
     * @return
     */
    private Binary IntToBin(Integer value) throws Exception {
        Binary result = new Binary();
        result = result.ToNBit(Integer.SIZE);
        int i = Integer.SIZE - 1;
        while (value > 0) {
            result.Set(i, Converter.Integers.Convert(value % 2));
            value = value >> 1;
            i--;
        }
        return result;
    }

    /**
     * Переводит число из двоичного кода в десятичный
     *
     * @param values
     * @return
     */
    public Integer BinToInt(Binary value) throws Exception {
        Integer result = 0;
        int i = value.GetLength() - 1;
        while (i > -1) {
            result += Converter.Booleans.Convert(value.Get(i));
            result = result << 1;
        }
        return result;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < this.bits.length; i++) {
            if (i % 4 == 0 && i > 0)
                str += " ";
            str += Converter.Booleans.Convert(this.bits[i]);
        }
        return str;
    }
}
