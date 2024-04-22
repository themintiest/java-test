package com.lumera.wordsearch.searchengine.evaluator;

public class EndsWithEvaluator implements SearchEvaluator {

    private final String endsWith;

    public EndsWithEvaluator(String endsWith) {
        this.endsWith = endsWith;
    }

    @Override
    public boolean evaluate(String input) {
        return input.endsWith(this.endsWith);
    }
}
