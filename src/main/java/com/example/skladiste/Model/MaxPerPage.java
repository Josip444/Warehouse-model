package com.example.skladiste.Model;

public enum MaxPerPage {
    MAX_PER_PAGE(5);

    private final int value;

    MaxPerPage(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
