package com.ricardomalias.test.helper;

import java.text.Normalizer;
import java.util.Arrays;

public class LongestWord {
    private LongestWord() {
    }

    public static String run(String sen) {
        // code goes here
        sen = Normalizer.normalize(sen, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .replaceAll("(\\!|,|\\?|-|\\.|\\&)", "");

        String[] s = sen.split(" ");

        sen = Arrays.stream(s)
                .min((a, b) -> b.length() - a.length())
                .orElse(sen.split(" ")[0]);

        return sen;
    }
}
