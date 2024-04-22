package com.lumera.wordsearch.searchengine.evaluator;


import java.util.Arrays;
import java.util.List;

public class CombinedSearchEvaluator implements SearchEvaluator {
    List<SearchEvaluator> searchEvaluators;

    public CombinedSearchEvaluator(SearchEvaluator searchEvaluator, SearchEvaluator other) {
        searchEvaluators = Arrays.asList(searchEvaluator, other);
    }

    @Override
    public boolean evaluate(String item) {
        // All rules must pass for the composite rule to pass
        return searchEvaluators.stream().allMatch(rule -> rule.evaluate(item));
    }
}
