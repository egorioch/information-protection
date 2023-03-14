package org.example.logic;

import org.example.util.Convert;

import java.math.BigInteger;
import java.util.ArrayList;

import static org.example.util.Convert.getNumericValuesAlphabet;

public class Decrypt {


    /**
     *
     * @param key_letter шифрованный символ
     * @param d составляющая закрытого ключа (d, n)
     * @param n произведение p * q
     * @return расшифрованное число-символ
     */
    public static int decryption(int key_letter, int d, int n) {
        return BigInteger
                .valueOf(key_letter)
                .modPow(BigInteger.valueOf(d), BigInteger.valueOf(n)).intValue();
    }


    public static ArrayList<Integer> decryptionList(ArrayList<Integer> encryptValues, int d, int n) {
        ArrayList<Integer> decryptValues = new ArrayList<>();

        for (var value: encryptValues) {
            decryptValues.add(decryption(value, d, n));
        }

        return decryptValues;
    }

    /**
     * функция делегирующая логику методу класса Convert
     * @return расшифрованную строку
     */
    public static String decryptionMessage (ArrayList<Integer> encryptValues, int d, int n) {
        ArrayList<Integer> decryptValues = decryptionList(encryptValues, d, n);

        return Convert.getSymbolsValuesAlphabet(decryptValues);
    }


}
