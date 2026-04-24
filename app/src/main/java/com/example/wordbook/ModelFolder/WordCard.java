package com.example.wordbook.ModelFolder;

public class WordCard {
    private String spelling;
    private String meaning;
    //    private final String wordClass;
    private String description;

    public WordCard(String spelling, String meaning, String description) {
        this.spelling = spelling;
        this.meaning = meaning;
        //this.wordClass = wordClass;
        this.description = description;
    }

    public String getSpelling() {
        return spelling;
    }
    public String getMeaning() {
        return meaning;
    }
    //    public String getWordClass() {
    //        return wordClass;
    //    }
    public String getDescription() {
        return description;
    }

    public void setSpelling(String spell) {
        spelling = spell;
    }

    public void setMeaning(String mean) {
        meaning = mean;
    }

    public void setDescription(String describe) {
        description = describe;
    }
}