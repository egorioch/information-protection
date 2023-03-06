package org.example;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/resources/docFile.doc");
        final int key = 255;

        /** Задание I
         * Создать программу, определяющую длину файла в байтах.
         * @file -- .doc
         */
        //lengthOfFileInBytes(file);

        /** Задание II
         * подсчитывать частоту появления каждого байта в произвольном файле
         */
        //frequencyOfByteInFile(fileToByte("src/main/resources/codeName.txt"));

        /** Задание III
         * Шифратор и дешифратор
         */
        ArrayList<Integer> arrayList = byteNRead("src/main/resources/codeName.txt");

        ArrayList<Integer> encryptedList = simpleByteReplacementEncryption(arrayList, key);
        System.out.println("Зашифрованные значения: ");
        PrinterView.convertArrayListToStringAndPrint(encryptedList);
        PrinterView.printConverted(encryptedList);

        ArrayList<Integer> decryptedList = simpleByteReplacementDecryption(encryptedList, key);
        System.out.println("Расшифрованные значения: ");
        PrinterView.convertArrayListToStringAndPrint(decryptedList);
        PrinterView.printConverted(decryptedList);
    }

    /**
     * @param path - путь для чтения
     * @return лист с символами Unicode
     */
    public static ArrayList<Integer> byteNRead(String path) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        try (FileReader reader = new FileReader(path)) {
            // читаем посимвольно
            int c;
            while ((c = reader.read()) != -1) {
                arrayList.add(c);
            }
        } catch (IOException exc) {
            exc.getStackTrace();
        }

        return arrayList;
    }

    /**
     * @param file -- определяет длину файла
     */
    private static void lengthOfFileInBytes(File file) {
        WordExtractor extractor = null;
        try {
            System.out.println("length of file in bytes: " + file.length());

            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            HWPFDocument document = new HWPFDocument(fis);
            extractor = new WordExtractor(document);
            String[] fileData = extractor.getParagraphText();
            //System.out.println("summary info: " + extractor.getSummaryInformation());
            for (int i = 0; i < fileData.length; i++) {
                if (fileData[i] != null)
                    System.out.println(fileData[i]);
            }

        } catch (Exception exep) {
            exep.printStackTrace();
        }
    }

    public static int[] fileToByte(String path) {
        //т.к. массив байтов [-128..127] происходит переполнение, поэтому храним в int[]
        try {
            byte[] array = Files.readAllBytes(Paths.get(path));
            int[] intByteArray = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                intByteArray[i] = array[i];
            }
            /*for (var b : intByteArray) {
                System.out.print(b + " ");
            }*/
            return intByteArray;
        } catch (IOException exc) {
            exc.getStackTrace();
        }

        return null;
    }

    /**
     * @param array - лист с символами Unicode
     */
    public static void frequencyOfByteInFile(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (var b : array) {
            if (map.containsKey(b)) {
                map.put(b, map.get(b) + 1);
            } else {
                map.put(b, 1);
            }
        }

        PrinterView.printMap(map);
    }

    /**
     * @param listOfBytes - данные с файла
     * @param key - ключ для шифрования
     * @return лист с зашифрованными значениями
     */
    private static ArrayList<Integer> simpleByteReplacementEncryption(ArrayList<Integer> listOfBytes, int key) {
        ArrayList<Integer> encryptedList = new ArrayList<>();
        for (var b : listOfBytes) {
            encryptedList.add(b + key);
        }

        return encryptedList;
    }

    /**
     * @param encryptedList - лист с зашифрованными значениями
     * @param key - ключ для шифрования
     * @return расшифрованный лист
     */
    private static ArrayList<Integer> simpleByteReplacementDecryption(ArrayList<Integer> encryptedList, int key) {
        ArrayList<Integer> decryptedList = new ArrayList<>();
        for (var b : encryptedList) {
            decryptedList.add(b - key);
        }

        return decryptedList;
    }


}