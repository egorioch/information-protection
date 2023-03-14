package org.example.util;

import org.example.workfiles.MyFileReader;

import java.util.ArrayList;
import java.util.HashMap;

public class Convert {
    private static final HashMap<Character, Integer> alphabet = MyFileReader.alphabet();
    private static final HashMap<Integer, Character> swappedAlphabet = MyFileReader.swappedAlphabet();

    /**
     * @param message сообщение для кодирования
     * @return возвращает лист значений(символ - эквивалетное число из алфавита)
     */
    public static ArrayList<Integer> getNumericValuesAlphabet(String message) {
        ArrayList<Integer> numericList = new ArrayList<>();

        for (var symbol: message.toCharArray()) {
            if (alphabet.containsKey(symbol)) {
                numericList.add(alphabet.get(symbol));
            }
        }

        return numericList;
    }

    public static String getSymbolsValuesAlphabet(ArrayList<Integer> numericList) {
        StringBuilder symbols = new StringBuilder();

        for (var number: numericList) {
            if (swappedAlphabet.containsKey(number)) {
                symbols.append(swappedAlphabet.get(number));
            }
        }

        return symbols.toString();
    }


}
