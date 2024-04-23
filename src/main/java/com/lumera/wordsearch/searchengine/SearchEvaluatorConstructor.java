package com.lumera.wordsearch.searchengine;

import com.lumera.wordsearch.searchengine.evaluator.*;

public class SearchEvaluatorConstructor {

    private SearchEvaluatorConstructor() {}

    public static SearchEvaluatorConstructorBuilder builder() {
        return new SearchEvaluatorConstructorBuilder();
    }

    public static class SearchEvaluatorConstructorBuilder {
        private Integer minLength;
        private Integer maxLength;

        private String startsWith;

        private String endsWith;

        private String withClass;

        private String containsOnly;

        public SearchEvaluatorConstructorBuilder withMinLength(Integer minLength) {
            this.minLength = minLength;
            return this;
        }

        public SearchEvaluatorConstructorBuilder withMaxLength(Integer maxLength) {
            this.maxLength = maxLength;
            return this;
        }

        public SearchEvaluatorConstructorBuilder startsWith(String startsWith) {
            this.startsWith = startsWith;
            return this;
        }

        public SearchEvaluatorConstructorBuilder endsWith(String endsWith) {
            this.endsWith = endsWith;
            return this;
        }

        public SearchEvaluatorConstructorBuilder withClass(String className) {
            this.withClass = className;
            return this;
        }

        public SearchEvaluatorConstructorBuilder containsOnly(String letters) {
            this.containsOnly = letters;
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
            if (containsOnly != null) {
                searchEvaluator = searchEvaluator.and(new ContainsOnlyEvaluator(containsOnly));
            }
            return searchEvaluator;
        }
    }
}
