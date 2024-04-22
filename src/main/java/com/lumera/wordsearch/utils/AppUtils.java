package com.lumera.wordsearch.utils;

import com.lumera.wordsearch.constants.Criteria;
import com.lumera.wordsearch.searchengine.SearchEngineCreator;
import com.lumera.wordsearch.searchengine.evaluator.SearchEvaluator;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class AppUtils {

    private AppUtils() {}

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

    public static SearchEvaluator toEvaluator(String query) {
        Map<Criteria, String> criteriaMap = parseQuery(query);
        SearchEngineCreator.SearchEngineCreatorBuilder builder = SearchEngineCreator.builder();
        builder.withClass(criteriaMap.get(Criteria.CLASS));
        builder.withMinLength(Optional.ofNullable(criteriaMap.get(Criteria.MINLENGTH)).map(AppUtils::parseNumber).orElse(null));
        builder.withMaxLength(Optional.ofNullable(criteriaMap.get(Criteria.MAXLENGTH)).map(AppUtils::parseNumber).orElse(null));
        builder.startsWith(criteriaMap.get(Criteria.STARTSWITH));
        builder.endsWith(criteriaMap.get(Criteria.ENDSWITH));
        builder.containsOnly(criteriaMap.get(Criteria.CONTAINSONLY));
        return builder.build();
    }

    public static Integer parseNumber(String value) {
        if (StringUtils.isNumeric(value)) {
            return Integer.parseInt(value);
        }
        throw new RuntimeException(String.format("Value %s is not a number.", value));
    }


}
