package com.lumera.wordsearch.searchengine.evaluator;

public class MaxLengthEvaluator implements SearchEvaluator {
    private final Integer maxLength;

    public MaxLengthEvaluator(Integer maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public boolean evaluate(String item) {
        return item.length() <= maxLength;
    }
}
