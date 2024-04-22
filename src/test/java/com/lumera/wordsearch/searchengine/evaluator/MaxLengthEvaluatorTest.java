package com.lumera.wordsearch.searchengine.evaluator;

import org.junit.Assert;
import org.junit.Test;

public class MaxLengthEvaluatorTest {
    
    @Test
    public void testWhenCorrectCase() {
        // Given
        final int maxLength = 5;
        final String word = "chung";

        SearchEvaluator searchEvaluator = new MaxLengthEvaluator(maxLength);
        boolean result = searchEvaluator.evaluate(word);

        // Then
        Assert.assertTrue(result);
    }

    @Test
    public void testWhenInCorrectCase() {
        // Given
        final int maxLength = 5;
        final String word = "chungvu";

        SearchEvaluator searchEvaluator = new MaxLengthEvaluator(maxLength);
        boolean result = searchEvaluator.evaluate(word);

        // Then
        Assert.assertFalse(result);
    }
}
