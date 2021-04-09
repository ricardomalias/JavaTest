package com.ricardomalias.test.helper;

import java.text.Normalizer;
import java.util.stream.IntStream;

public class PalindromeHelper {
    private final boolean caseSensitive;
    private final boolean ignoreSpace;

    public PalindromeHelper(boolean caseSensitive, boolean ignoreSpace) {
        this.caseSensitive = caseSensitive;
        this.ignoreSpace = ignoreSpace;
    }

    public boolean isPalindrome(String txt) {

        txt =  Normalizer.normalize(txt, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .replaceAll("([!,?\\-.&])", "");

        if (ignoreSpace) {
            txt = txt.replaceAll("\\s+", "");
        }

        if (!caseSensitive) {
            txt = txt.toLowerCase();
        }

        String text = txt;

        return IntStream.range(0, text.length() / 2)
                .noneMatch(i -> text.charAt(i) != text.charAt(text.length() - i - 1));
    }
}
