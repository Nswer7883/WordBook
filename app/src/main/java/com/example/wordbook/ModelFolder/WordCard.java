package com.example.wordbook.ModelFolder;

public class WordCard {
    private final String spelling;
    private final String meaning;
    //    private final String wordClass;
    private final String description;

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
}