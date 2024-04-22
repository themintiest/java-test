package com.lumera.wordsearch.searchengine.evaluator;

import com.lumera.wordsearch.constants.WordClass;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ClassEvaluator implements SearchEvaluator {

    private final String className;

    public ClassEvaluator(String className) {
        this.className = className;
    }

    @Override
    public boolean evaluate(String input) {
        if (WordClass.ISOGRAM.name().equalsIgnoreCase(className)) {
            return isIsogram(input);
        }
        if (WordClass.PALINDROME.name().equalsIgnoreCase(className)) {
            return isPalindrome(input);
        }
        if (WordClass.SEMORDNILAP.name().equalsIgnoreCase(className)) {
            return isSemordnilap(input);
        }
        throw new RuntimeException("The class does not support for searching.");
    }

    private boolean isIsogram(String input) {
        String[] data = input.split("");
        Set<String> stringSet = new HashSet<>(Arrays.asList(data));
        return stringSet.size() == input.length();
    }

    private boolean isPalindrome(String input) {
        int i = 0, j = input.length() - 1;
        while (i < j) {
            if (input.charAt(i) != input.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isSemordnilap(String input) {
        String reverse = new StringBuilder(input).reverse().toString();
        return !input.equalsIgnoreCase(reverse);
    }
}
