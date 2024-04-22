package com.lumera.wordsearch.searchengine.evaluator;

import org.junit.Assert;
import org.junit.Test;

public class ContainsOnlyEvaluatorTest {
    @Test
    public void testWhenCorrectCase() {
        // Given
        final String letters = "abcde";
        final String word = "bad";

        SearchEvaluator searchEvaluator = new ContainsOnlyEvaluator(letters);
        boolean result = searchEvaluator.evaluate(word);

        // Then
        Assert.assertTrue(result);
    }

    @Test
    public void testWhenInCorrectCase() {
        // Given
        final String letters = "abcde";
        final String word = "chung";

        SearchEvaluator searchEvaluator = new ContainsOnlyEvaluator(letters);
        boolean result = searchEvaluator.evaluate(word);

        // Then
        Assert.assertFalse(result);
    }
}
