package com.lumera.wordsearch;

import com.lumera.wordsearch.searchengine.SearchEngine;
import com.lumera.wordsearch.searchengine.evaluator.ClassEvaluator;
import com.lumera.wordsearch.searchengine.evaluator.EndsWithEvaluator;
import com.lumera.wordsearch.searchengine.evaluator.MaxLengthEvaluator;
import com.lumera.wordsearch.searchengine.evaluator.MinLengthEvaluator;
import com.lumera.wordsearch.searchengine.evaluator.SearchEvaluator;
import com.lumera.wordsearch.searchengine.evaluator.StartsWithEvaluator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchEngineTest {

    @Test
    public void testWithClassAndMinLengthAndMaxLength() {
        // Given
        final String className = "palindrome";
        final int minLength = 3;
        final int maxLength = 3;
        final List<String> words = Arrays.asList("xax", "abc", "xxaxx");

        SearchEvaluator classEvaluator = new ClassEvaluator(className);
        SearchEvaluator minLengthEvaluator = new MinLengthEvaluator(minLength);
        SearchEvaluator maxLengthEvaluator = new MaxLengthEvaluator(maxLength);

        // When
        SearchEvaluator searchEvaluator = classEvaluator
                .and(minLengthEvaluator)
                .and(maxLengthEvaluator);
        List<String> results = SearchEngine.search(words, searchEvaluator);

        // Then
        Assert.assertEquals(results, Collections.singletonList("xax"));
    }

    @Test
    public void testWithClassAndStartsWithAndEndsWith() {
        // Given
        final String className = "palindrome";
        final String startsWith = "x";
        final String endsWith = "x";

        final List<String> words = Arrays.asList("xax", "abc", "xxaxx", "bab", "xabcx");

        SearchEvaluator classEvaluator = new ClassEvaluator(className);
        SearchEvaluator startsWithEvaluator = new StartsWithEvaluator(startsWith);
        SearchEvaluator endsWithEvaluator = new EndsWithEvaluator(endsWith);

        // When
        SearchEvaluator searchEvaluator = classEvaluator
                .and(startsWithEvaluator)
                .and(endsWithEvaluator);
        List<String> results = SearchEngine.search(words, searchEvaluator);

        // Then
        Assert.assertEquals(results, Arrays.asList("xax", "xxaxx"));
    }
}
