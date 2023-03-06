package org.example;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class PrinterView {
    public static void printConverted(ArrayList<Integer> arrayList) {
        for (var i : arrayList) {
            int i_cast = i;
            System.out.print((char)i_cast);
        }

        System.out.println();
    }

    public static void printMap(HashMap<Integer, Integer> map) {
        for (var key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }

    //по сути нарушает [S]OLID
    public static void convertArrayListToStringAndPrint(ArrayList<Integer> arrayList) {
        System.out.println(
                arrayList
                .stream().map(Object::toString)
                .collect(Collectors.joining(" "))
        );
    }
}
