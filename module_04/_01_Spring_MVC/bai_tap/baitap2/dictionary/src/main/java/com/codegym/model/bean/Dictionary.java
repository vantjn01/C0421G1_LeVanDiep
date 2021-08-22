package com.codegym.model.bean;

public class Dictionary {
    private String English;
    private String Vietnamese;

    public Dictionary(String english, String vietnamese) {
        English = english;
        Vietnamese = vietnamese;
    }

    public Dictionary() {
    }

    public String getEnglish() {
        return English;
    }

    public void setEnglish(String english) {
        English = english;
    }

    public String getVietnamese() {
        return Vietnamese;
    }

    public void setVietnamese(String vietnamese) {
        Vietnamese = vietnamese;
    }
}
