package com.lumera.wordsearch.searchengine.evaluator;

public abstract class AbstractSearchEvaluator implements SearchEvaluator {

    public abstract boolean evaluate(String item);

    @Override
    public SearchEvaluator and(SearchEvaluator other) {
        return new CombinedSearchEvaluator(this, other);
    }
}
