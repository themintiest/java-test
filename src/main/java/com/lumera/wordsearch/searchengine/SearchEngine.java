package com.lumera.wordsearch.searchengine;

import com.lumera.wordsearch.searchengine.evaluator.SearchEvaluator;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private SearchEngine() {}

    /**
     * Search word by evaluator.
     *
     * @param resources the resource of words.
     * @param searchEvaluator the search evaluator.
     * @return list of words that are matching with criteria.
     */
    public static List<String> search(List<String> resources, SearchEvaluator searchEvaluator) {
        List<String> result = new ArrayList<>();
        for (String item : resources) {
            if (searchEvaluator.evaluate(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
