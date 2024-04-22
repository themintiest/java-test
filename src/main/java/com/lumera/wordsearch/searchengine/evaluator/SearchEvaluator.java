package com.lumera.wordsearch.searchengine.evaluator;

public interface SearchEvaluator {
    boolean evaluate(String input);

    default SearchEvaluator and(SearchEvaluator other) {
        return new CombinedSearchEvaluator(this, other);
    }
}
