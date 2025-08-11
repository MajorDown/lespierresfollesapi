package com.lespierresfolles.api.models.enums;

public enum MegalithType {
    DOLMEN("Dolmen"),
    MENHIR("Menhir"),
    TUMULUS("Tumulus"),
    AUTRE("Autre");

    private final String label;

    MegalithType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
