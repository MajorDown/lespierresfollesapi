package com.lespierresfolles.api.models.enums;

public enum Material {
    INCONNU("Inconnu"),
    SILEX("Silex"),
    BASALTE("Basalte"),
    MARBRE("Marbre"),
    GRES("Grès"),
    SCHISTE("Schiste"),
    QUARTZITE("Quartzite"),
    GNEISS("Gneiss"),
    CALCAIRE("Calcaire"),
    GRANITE("Granite"),
    ANDESITE("Andésite"),
    DIORITE("Diorite");

    private final String label;

    Material(String label) {
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
