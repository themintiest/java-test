package com.lumera.wordsearch.searchengine.evaluator;

public class StartsWithEvaluator implements SearchEvaluator {

    private final String startsWith;

    public StartsWithEvaluator(String startsWith) {
        this.startsWith = startsWith;
    }

    @Override
    public boolean evaluate(String input) {
        return input.startsWith(this.startsWith);
    }
}
