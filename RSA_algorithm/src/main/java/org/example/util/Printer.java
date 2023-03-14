package org.example.util;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Printer {
    public static void printArrayList(ArrayList<?> arrayList) {
        System.out.println(
                arrayList.stream().map(Object::toString)
                        .collect(Collectors.joining(", ")));
    }
}
