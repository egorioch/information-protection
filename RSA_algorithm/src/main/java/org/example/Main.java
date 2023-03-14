package org.example;

import org.example.logic.Decrypt;
import org.example.logic.Encrypt;
import org.example.util.Printer;
import org.example.workfiles.MyFileReader;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    private static final HashMap<Character, Integer> alphabet = MyFileReader.alphabet();
    private static final String message = "Я СПРОСИЛ У ЯСЕНЯ";

    //произведние p * q
    private int n;

    private int e;
    private int d;

    public static void main(String[] args) {
//        System.out.println("count: " + countRelativePrimeNumbers(91, 1));
        //System.out.println("open e:" + openExhibitor(72));
        final int p = 7;
        final int q = 13;
        int n = p * q;
        int euler_function_result = (p-1) * (q - 1);
        int e = openExhibitor(euler_function_result);
        int d = define_d(euler_function_result, e);

        System.out.println("euler_fun_result = " + euler_function_result);


        ArrayList<Integer> encryptionList = Encrypt.encryptionList(message, e, n);
        System.out.println("Зашифрованное сообщение: ");
        Printer.printArrayList(encryptionList);

        String decryptMessage = Decrypt.decryptionMessage(encryptionList, d, n);
        System.out.println("Расшифрованное сообщение:" + decryptMessage);

    }

    /**
     * определяет, являются ли числа взаимно-простыми
     */
    public static boolean defineRelativelyPrimeNumber(int a, int b) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).equals(BigInteger.ONE);
    }

    /**
     * определяем число взаимнопростых чисел между a и b
     */
    public static int countRelativePrimeNumbers(int a, int b) {
        int count = 0;
        while(b != a)
            if (defineRelativelyPrimeNumber(a, b++))
                count++;

        return count;
    }

    /**
     * определяем открытую эскпоненту e (взаимное-простое с euler_function_result число)
     * (взаимно простое со значением функции эйлера)
     */
    public static int openExhibitor(int a) {
        int b = 3;
        while (b < a) {
            if (defineRelativelyPrimeNumber(a, b)) {
                return b;
            }
            b++;
        }

        return 1;
    }


    /**
     * d = (k*euler_function(n) + 1) / e
     * @param euler_function_n - значение фукнции эйлера
     * @param e - открытая экспонента
     */
    public static int define_d(int euler_function_n, int e) {
        int k = 1;
        double d = (double)(k*euler_function_n + 1) / e;
        System.out.println("Primary d: " + d);

        while(d != Math.round(d)) {
            System.out.println("Math.round(d): " + Math.round(d));
            k++;
            d = (double)(k*euler_function_n + 1) / e;
            System.out.println("end-loop d: " + d);
        }

        return (int)d;
    }











}
