package com.example.wordbook.ViewFolder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wordbook.ModelFolder.WordCard;
import com.example.wordbook.R;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    private ImageButton btnAdding;
    MainActivity mainActivity;
    RecyclerView card_recycler;
    Fragment addingFragment;
    WordsAdapter wordsAdapter;
    ArrayList<WordCard> cards;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);
        mainActivity = (MainActivity) getActivity();
        card_recycler = (RecyclerView) rootView.findViewById(R.id.recycler_words);

        wordsAdapter = new WordsAdapter();
        card_recycler.setAdapter(wordsAdapter);
        card_recycler.setLayoutManager(new LinearLayoutManager(mainActivity));

        btnAdding = rootView.findViewById(R.id.btn_adding);
        addingFragment = new AddingFragment();
        btnAdding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.changeMode(addingFragment);
            }
        });


        wordsAdapter.setCardList(cards);

        mainActivity.viewModel.getWordList().observe(getViewLifecycleOwner(), list -> {});

        return rootView;
    }
}
