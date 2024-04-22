package com.lumera.wordsearch.searchengine.evaluator;

import org.junit.Assert;
import org.junit.Test;

public class ClassEvaluatorTest {

    @Test
    public void testWhenClassIsIsogramAndInputIsIsogram() {
        // Given
        final String className = "isogram";
        final String word = "abcde";

        // When
        boolean result = new ClassEvaluator(className).evaluate(word);

        // Then
        Assert.assertTrue(result);
    }

    @Test
    public void testWhenClassIsIsogramAndInputIsNotIsogram() {
        // Given
        final String className = "isogram";
        final String word = "abcdee";

        // When
        boolean result = new ClassEvaluator(className).evaluate(word);

        // Then
        Assert.assertFalse(result);
    }

    @Test
    public void testWhenClassIsPalindromeAndInputIsPalindrome() {
        // Given
        final String className = "palindrome";
        final String word = "xax";

        // When
        boolean result = new ClassEvaluator(className).evaluate(word);

        // Then
        Assert.assertTrue(result);
    }

    @Test
    public void testWhenClassIsPalindromeAndInputIsNotPalindrome() {
        // Given
        final String className = "palindrome";
        final String word = "abcde";

        // When
        boolean result = new ClassEvaluator(className).evaluate(word);

        // Then
        Assert.assertFalse(result);
    }

    @Test
    public void testWhenClassIsSemordnilapAndInputIsSemordnilap() {
        // Given
        final String className = "semordnilap";
        final String word = "stressed";

        // When
        boolean result = new ClassEvaluator(className).evaluate(word);

        // Then
        Assert.assertTrue(result);
    }

    @Test
    public void testWhenClassIsSemordnilapAndInputIsNotSemordnilap() {
        // Given
        final String className = "semordnilap";
        final String word = "xax";

        // When
        boolean result = new ClassEvaluator(className).evaluate(word);

        // Then
        Assert.assertFalse(result);
    }

    @Test(expected = RuntimeException.class)
    public void testWhenWrongClassName() {
        // Given
        final String className = "isogram1";
        final String word = "abcdee";

        // When
        boolean result = new ClassEvaluator(className).evaluate(word);

        // Then
        Assert.assertFalse(result);
    }
}
