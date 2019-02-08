package Encryption;

import Common.Constants.Messages;
import Helpers.Arrays;
import Helpers.Converter;

import java.util.ArrayList;

public class Binary {

    private Arrays<Boolean> helper;

    private Boolean[] bits;

    public Binary(Boolean[] bits) {
        this.bits = bits;
    }

    public Binary(Integer value) {

    }

    public Boolean Get(int index) throws Exception {
        if (helper.Check(this.bits, index))
            return this.bits[index];
        else
            throw new Exception(Messages.Exceptions.indexIncorrect);
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
        Boolean[] result = new Boolean[length];
        for (int i = 0; i < length; i++) {
            Integer v1 = Converter.Booleans.Convert(b1.Get(i));
            Integer v2 = Converter.Booleans.Convert(b2.Get(i));
            result[i] = Converter.Integers.Convert((v1 + v2) % 2);
        }
        return new Binary(result);
    }

    public Binary AND(Binary value) throws Exception {
        Integer length = Math.max(this.GetLength(), value.GetLength());
        Binary b1 = this.ToNBit(length);
        Binary b2 = value.ToNBit(length);
        Boolean[] result = new Boolean[length];
        for (int i = 0; i < length; i++) {
            Integer v1 = Converter.Booleans.Convert(b1.Get(i));
            Integer v2 = Converter.Booleans.Convert(b2.Get(i));
            result[i] = Converter.Integers.Convert(v1 * v2);
        }
        return new Binary(result);
    }

    !!!!!!!!!!!

    public Binary OR(Binary value) throws Exception {
        Integer length = Math.max(this.GetLength(), value.GetLength());
        Binary b1 = this.ToNBit(length);
        Binary b2 = value.ToNBit(length);
        Boolean[] result = new Boolean[length];
        for (int i = 0; i < length; i++) {
            Integer v1 = Converter.Booleans.Convert(b1.Get(i));
            Integer v2 = Converter.Booleans.Convert(b2.Get(i));
            result[i] = Converter.Integers.Convert((v1 + v2) % 2);
            //TODO: доделать перенос в старший разряд
        }
        return new Binary(result);
    }

    !!!!!!!!!!!!!!!


    /**
     * Переводит число в двоичный вид
     *
     * @param value значение для перевода
     * @return
     */
    private Integer[] IntToBin(Integer value) {
        ArrayList<Integer> result = new ArrayList<>();
        if (value == 0)
            result.add(0);
        else {
            value = Math.abs(value);
            while (value > 0) {
                result.add(value % 2);
                value = value >> 1;
            }
        }
        return new Arrays<Integer>().Reverse(Converter.ArrayLists.Convert(result));
    }

    /**
     * Переводит число из двоичного кода в десятичный
     *
     * @param values
     * @return
     */
    public Integer BinToInt(Integer[] values) {
        Integer result = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == 1)
                result += 1;
            if (i != values.length - 1)
                result = result << 1;
        }
        return result;
    }

}
