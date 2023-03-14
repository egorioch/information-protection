package org.example.util;

import org.example.workfiles.MyFileReader;

import java.util.ArrayList;
import java.util.HashMap;

public class Convert {
    private static final HashMap<Character, Integer> alphabet = MyFileReader.alphabet();

    public static ArrayList<Integer> getNumericValuesAlphabet(String message) {
        ArrayList<Integer> numericList = new ArrayList<>();

        for (var symbol: message.toCharArray()) {
            if (alphabet.containsKey(symbol)) {
                numericList.add(alphabet.get(symbol));
            }
        }

        return numericList;
    }
}
