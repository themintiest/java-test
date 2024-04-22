package com.lumera.wordsearch.searchengine.evaluator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsOnlyEvaluator implements SearchEvaluator {

    private final String letters;

    public ContainsOnlyEvaluator(String letters) {
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
