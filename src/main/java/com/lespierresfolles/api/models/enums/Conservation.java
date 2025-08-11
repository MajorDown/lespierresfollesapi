package com.lespierresfolles.api.models.enums;

public enum Conservation {
    BON_ETAT("Bon état"),
    ETAT_MOYEN("État moyen"),
    MAUVAIS_ETAT("Mauvais état"),
    DETRUIT("Détruit");

    private final String label;

    Conservation(String label) {
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
