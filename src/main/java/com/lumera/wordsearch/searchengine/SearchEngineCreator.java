package com.lumera.wordsearch.searchengine;

import com.lumera.wordsearch.searchengine.evaluator.ClassEvaluator;
import com.lumera.wordsearch.searchengine.evaluator.DefaultEvaluator;
import com.lumera.wordsearch.searchengine.evaluator.EndsWithEvaluator;
import com.lumera.wordsearch.searchengine.evaluator.MadeUpEvaluator;
import com.lumera.wordsearch.searchengine.evaluator.MaxLengthEvaluator;
import com.lumera.wordsearch.searchengine.evaluator.MinLengthEvaluator;
import com.lumera.wordsearch.searchengine.evaluator.SearchEvaluator;
import com.lumera.wordsearch.searchengine.evaluator.StartsWithEvaluator;

public class SearchEngineCreator {

    private SearchEngineCreator() {}

    public static SearchEngineCreatorBuilder builder() {
        return new SearchEngineCreatorBuilder();
    }

    public static class SearchEngineCreatorBuilder {
        private Integer minLength;
        private Integer maxLength;

        private String startsWith;

        private String endsWith;

        private String withClass;

        private String madeUpByLetters;

        public SearchEngineCreatorBuilder withMinLength(Integer minLength) {
            this.minLength = minLength;
            return this;
        }

        public SearchEngineCreatorBuilder withMaxLength(Integer maxLength) {
            this.maxLength = maxLength;
            return this;
        }

        public SearchEngineCreatorBuilder startsWith(String startsWith) {
            this.startsWith = startsWith;
            return this;
        }

        public SearchEngineCreatorBuilder endsWith(String endsWith) {
            this.endsWith = endsWith;
            return this;
        }

        public SearchEngineCreatorBuilder withClass(String className) {
            this.withClass = className;
            return this;
        }

        public SearchEngineCreatorBuilder madeUpBy(String letters) {
            this.madeUpByLetters = letters;
            return this;
        }

        public SearchEvaluator build() {
            SearchEvaluator searchEvaluator = new DefaultEvaluator();

            if (minLength != null) {
                searchEvaluator = searchEvaluator.and(new MinLengthEvaluator(minLength));
            }
            if (maxLength != null) {
                searchEvaluator = searchEvaluator.and(new MaxLengthEvaluator(maxLength));
            }
            if (startsWith != null) {
                searchEvaluator = searchEvaluator.and(new StartsWithEvaluator(startsWith));
            }
            if (endsWith != null) {
                searchEvaluator = searchEvaluator.and(new EndsWithEvaluator(endsWith));
            }
            if (withClass != null) {
                searchEvaluator = searchEvaluator.and(new ClassEvaluator(withClass));
            }
            if (madeUpByLetters != null) {
                searchEvaluator = searchEvaluator.and(new MadeUpEvaluator(madeUpByLetters));
            }
            return searchEvaluator;
        }
    }
}
