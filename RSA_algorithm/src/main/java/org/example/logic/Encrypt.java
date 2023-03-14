package org.example.logic;

import java.math.BigInteger;
import java.util.ArrayList;

import static org.example.util.Convert.getNumericValuesAlphabet;

public class Encrypt {


    /**
     * C_i = (T_i)^e * mod(n)
     * @param key_letter - числовый эквивалент символа в слове
     * @param e - открытая экспонента
     * @param n - произведение простых чисел p и q
     */
    public static int encryption(int key_letter, int e, int n) {
        return BigInteger
                .valueOf(key_letter)
                .modPow(BigInteger.valueOf(e), BigInteger.valueOf(n)).intValue();
    }

    /**
     *
     * @param message - сообщение для шифрование
     * @param e - открытая экспонента
     * @param n - произведение простых чисел p и q
     * @return лист шифрованных значений(шифрованное сообщение)
     */
    public static ArrayList<Integer> encryptionList(String message, int e, int n) {
        ArrayList<Integer> encryptValues = new ArrayList<>();

        for (var value: getNumericValuesAlphabet(message)) {
            encryptValues.add(encryption(value, e, n));
        }

        return encryptValues;
    }
}
