package com.ricardomalias.test.helper;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeHelperTest {

    @Test
    public void isPalindromeCaseInsensitiveIgnoreSpace() {
        PalindromeHelper palindromeHelper = new PalindromeHelper(false, true);

        assertTrue(palindromeHelper.isPalindrome("Olé! Maracujá, caju, caramelo!"));
    }

    @Test
    public void isPalindromeCaseInsensitive() {
        PalindromeHelper palindromeHelper = new PalindromeHelper(false, false);

        assertTrue(palindromeHelper.isPalindrome("Ana"));
    }

    @Test
    public void isPalindromeCaseSensitive() {
        PalindromeHelper palindromeHelper = new PalindromeHelper(true, false);

        assertTrue(palindromeHelper.isPalindrome("ovo"));
    }

    @Test
    public void isPalindromeCaseSensitiveIgnoreSpace() {
        PalindromeHelper palindromeHelper = new PalindromeHelper(true, true);

        assertTrue(palindromeHelper.isPalindrome("anotaram a data da maratona."));
    }
}