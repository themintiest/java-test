package com.lumera.wordsearch.constants;

public enum Criteria {
    CLASS, MINLENGTH, MAXLENGTH, STARTSWITH, ENDSWITH, CONTAINSONLY;

    public static Criteria from(String name) {
        for (Criteria item : Criteria.values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        throw new RuntimeException(String.format("Criteria with name = %s does not exist.", name));
    }
}
