package com.example.wordbook.ModelFolder;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class WordDB {
    private List<WordCard> wordList = new ArrayList<>();
    public List<WordCard> getWords() {

        return wordList;
    }


    public void makeNewWord(String spell, String mean, String describe) {
        if (spell != null && mean != null && describe != null) {
            WordCard wc = new WordCard(spell, mean, describe);
            wordList.add(wc);
            //wordList.forEach(word -> Log.v("user", word.getSpelling()));
        }
    }
}
