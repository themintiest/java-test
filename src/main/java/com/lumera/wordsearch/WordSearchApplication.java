package com.lumera.wordsearch;

import com.lumera.wordsearch.searchengine.SearchEngine;
import com.lumera.wordsearch.searchengine.evaluator.SearchEvaluator;
import com.lumera.wordsearch.utils.AppUtils;

import java.time.Instant;
import java.util.List;
import java.util.Scanner;

import static com.lumera.wordsearch.utils.FileUtils.readFile;

/**
 * Entry point of application.
 */
public class WordSearchApplication {

    private static final String EXIT_MODE = "exit";

    private static List<String> words;


    public static void run() {
        while (true) {
            try {
                System.out.println("Input query (or type exit if you want to exit app): ");
                Scanner scanner = new Scanner(System.in);
                String text = scanner.nextLine();
                if (text.equalsIgnoreCase(EXIT_MODE)) {
                    System.exit(0);
                }
                SearchEvaluator searchEvaluator = AppUtils.toEvaluator(text);
                Instant startTime = Instant.now();
                List<String> results = SearchEngine.search(words, searchEvaluator);
                System.out.println();
                System.out.println(results);
                System.out.println();
                Instant endTime = Instant.now();
                long time = endTime.toEpochMilli() - startTime.toEpochMilli();
                System.out.printf("Found and showed %s result(s) in %s milliseconds%n", results.size(), time);
            } catch (RuntimeException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        try {
            words = readFile("wordlist.txt");
            run();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
