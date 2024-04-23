package com.lumera.wordsearch.utils;

import com.lumera.wordsearch.constants.Criteria;
import com.lumera.wordsearch.searchengine.SearchEvaluatorConstructor;
import com.lumera.wordsearch.searchengine.evaluator.SearchEvaluator;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class AppUtils {

    private AppUtils() {}

    /**
     * Parsing query that input from the console application.
     *
     * @param query the query that was inputted.
     * @return a criteria map.
     */
    public static Map<Criteria, String> parseQuery(String query) {
        Map<Criteria, String> criteriaMap = new HashMap<>();
        String [] criteriaPairs = query.split(" ");
        for (String pair : criteriaPairs) {
            String [] splitCriteria = pair.split("=");
            if (splitCriteria.length < 2) {
                throw new RuntimeException("Invalid criteria input.");
            }
            Criteria criteria = Criteria.from(splitCriteria[0]);
            criteriaMap.put(criteria, splitCriteria[1]);
        }
        return criteriaMap;
    }

    /**
     * Parsing query to a search evaluator that can be used by search engine.
     *
     * @param query the query that was inputted from console application.
     * @return a search criteria.
     */
    public static SearchEvaluator toEvaluator(String query) {
        Map<Criteria, String> criteriaMap = parseQuery(query);
        return SearchEvaluatorConstructor.builder()
                .withClass(criteriaMap.get(Criteria.CLASS))
                .withMinLength(Optional.ofNullable(criteriaMap.get(Criteria.MINLENGTH)).map(AppUtils::parseNumber).orElse(null))
                .withMaxLength(Optional.ofNullable(criteriaMap.get(Criteria.MAXLENGTH)).map(AppUtils::parseNumber).orElse(null))
                .startsWith(criteriaMap.get(Criteria.STARTSWITH))
                .endsWith(criteriaMap.get(Criteria.ENDSWITH))
                .containsOnly(criteriaMap.get(Criteria.CONTAINSONLY))
                .build();
    }

    public static Integer parseNumber(String value) {
        if (StringUtils.isNumeric(value)) {
            return Integer.parseInt(value);
        }
        throw new RuntimeException(String.format("Value %s is not a number.", value));
    }


}
