package com.lumera.wordsearch.searchengine.evaluator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.lumera.wordsearch.utils.FileUtils.readFile;

public class MinLengthEvaluatorTest {

    @Test
    public void testWhenCorrectCase() {
        // Given
        final int minLength = 5;
        final String word = "chung";

        SearchEvaluator searchEvaluator = new MinLengthEvaluator(minLength);
        boolean result = searchEvaluator.evaluate(word);

        // Then
        Assert.assertTrue(result);
    }

    @Test
    public void testWhenInCorrectCase() {
        // Given
        final int minLength = 5;
        final String word = "vu";

        SearchEvaluator searchEvaluator = new MinLengthEvaluator(minLength);
        boolean result = searchEvaluator.evaluate(word);

        // Then
        Assert.assertFalse(result);
    }
}
