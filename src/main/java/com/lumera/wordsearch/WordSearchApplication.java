package com.lumera.wordsearch;

import com.lumera.wordsearch.searchengine.SearchEngine;
import com.lumera.wordsearch.searchengine.SearchEngineCreator;
import com.lumera.wordsearch.searchengine.evaluator.SearchEvaluator;

import java.util.List;
import java.util.Scanner;

import static com.lumera.wordsearch.WordlistKt.readWordList;

/**
 * Entry point of application.
 */
public class WordSearchApplication {

    private static List<String> words;


    public static void run() {
        while (true) {
            try {
                System.out.println("Input query: ");
                Scanner scanner = new Scanner(System.in);
                String text = scanner.nextLine();
                SearchEvaluator searchEvaluator = SearchEngineCreator.builder()
                        .withMinLength(3)
                        .withMaxLength(8)
                        .withClass(null)
                        .madeUpBy("abcde")
                        .build();
                List<String> result = SearchEngine.search(words, searchEvaluator);
                for (String word : result) {
                    System.out.println(word);
                }
            } catch (RuntimeException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        words = readWordList("wordlist.txt");
        try {
            run();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
