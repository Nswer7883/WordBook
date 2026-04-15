package com.example.wordbook.ViewModelFolder;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wordbook.ModelFolder.WordCard;
import com.example.wordbook.ModelFolder.WordDB;

import java.util.List;

public class WordBookVM extends ViewModel {
    private MutableLiveData<WordCard> _wordCard;
    private MutableLiveData<String> _spelling = new MutableLiveData<>(),
            _meaning = new MutableLiveData<>(), _wordClass,
            _description = new MutableLiveData<>();
    private MutableLiveData<List<WordCard>> _wordList = new MutableLiveData<>();
    public LiveData<WordCard> wordCard = _wordCard;
    public LiveData<List<WordCard>> wordList = _wordList;
    public LiveData<String> spelling = _spelling, meaning = _meaning, wordClass = _wordClass, description = _description;

    public LiveData<WordCard> getWordCard() {
        return wordCard;
    }

    public LiveData<List<WordCard>> getWordList() {
        return wordList;
    }

    public void setSpelling(String spelling) {
        _spelling.setValue(spelling);
    }
    public void setMeaning(String meaning) {
        _meaning.setValue(meaning);
    }
    public void setDescription(String description) {
        _description.setValue(description);
    }

    public void makeWordCard() {
        wordDB.makeNewWord(_spelling.getValue(), _meaning.getValue(), _description.getValue());
    }

    private WordDB wordDB = new WordDB();

    public void loadWords() {
        new Thread(() -> {
            List<WordCard> wordCardList =  wordDB.getWords();
            _wordList.postValue(wordCardList);
        }).start();
    }
}
