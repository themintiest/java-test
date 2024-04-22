package com.lumera.wordsearch.searchengine.evaluator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MadeUpEvaluator implements SearchEvaluator {

    private final String letters;

    public MadeUpEvaluator(String letters) {
        this.letters = letters;
    }

    @Override
    public boolean evaluate(String input) {
        Set<String> letterSet = new HashSet<>(Arrays.asList(letters.toLowerCase().split("")));
        String [] inputChars = input.toLowerCase().split("");
        for (String item : inputChars) {
            if (!letterSet.contains(item)) {
                return false;
            }
        }
        return true;
    }
}
