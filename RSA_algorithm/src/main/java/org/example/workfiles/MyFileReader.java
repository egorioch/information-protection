package org.example.workfiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MyFileReader {
    private static final String path = "src/main/resources/alphabet.txt";

    /**
     * @return карту, у которой ключи - символы, а соотв. значения - числа
     */
    public static HashMap<Character, Integer> alphabet() {
        HashMap<Character, Integer> alphabetMap = new HashMap<>();
        int int_key = 1;
        for (var letter : contentExtractor().toCharArray()) {
            alphabetMap.put(letter, int_key++);
        }

        return alphabetMap;
    }

    /**
     * меняем местами ключи и значения карты функции alphabet
     */
    public static HashMap<Integer, Character> swappedAlphabet() {
        HashMap<Character, Integer> alphabet = alphabet();
        HashMap<Integer, Character> swappedAlphabet = new HashMap<>();

        for(Map.Entry<Character, Integer> entry : alphabet.entrySet())
            swappedAlphabet.put(entry.getValue(), entry.getKey());

        return swappedAlphabet;
    }

    /**
     *  Читает данные с файла
     * @return строку, "прочитанную" с файла
     */
    private static String contentExtractor() {
        StringBuilder alphabetString = new StringBuilder();

        try (FileReader reader = new FileReader(path)) {
            int c;
            while ((c = reader.read()) != -1) {
                alphabetString.append((char)c);
            }
        } catch (IOException exc) {
            exc.getStackTrace();
        }

        return alphabetString.toString();
    }
}
