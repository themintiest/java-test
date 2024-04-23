package com.lumera.wordsearch.searchengine.evaluator;

/**
     When introducing a new search rule, simply create a new search evaluator that implements this interface.
     The only requirement is to implement the evaluate method, ensuring that the new rule functions correctly.
 */
public interface SearchEvaluator {
    boolean evaluate(String input);

    default SearchEvaluator and(SearchEvaluator other) {
        return new CombinedSearchEvaluator(this, other);
    }
}
