package com.lumera.wordsearch.searchengine.evaluator;

public class MinLengthEvaluator implements SearchEvaluator {

    private final Integer minLength;

    public MinLengthEvaluator(Integer minLength) {
        this.minLength = minLength;
    }

    @Override
    public boolean evaluate(String item) {
        return item.length() >= minLength;
    }
}
