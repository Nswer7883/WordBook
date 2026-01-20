package com.example.wordbook.ViewModelFolder;

import java.util.Map;

public class WordCard {
    private final String spelling;
    private final String meaning;
    private final String wordClass;
    private final String[] attributes;

    public WordCard(String spelling, String meaning, String wordClass, String[] attributes) {
        this.spelling = spelling;
        this.meaning = meaning;
        this.wordClass = wordClass;
        this.attributes = attributes;
    }

    public String getSpelling() {
        return spelling;
    }
    public String getMeaning() {
        return meaning;
    }
    public String getWordClass() {
        return wordClass;
    }
    public String[] getAttributes() {
        return attributes;
    }
}
