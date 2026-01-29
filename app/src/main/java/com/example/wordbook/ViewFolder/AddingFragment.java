package com.example.wordbook.ViewFolder;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.wordbook.R;

public class AddingFragment extends Fragment {

    private ImageButton btnCloseAdding;
    private MainActivity mainActivity;
    private ListFragment listFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_adding, container, false);
        btnCloseAdding = rootView.findViewById(R.id.btn_close_adding);
        mainActivity = (MainActivity) getActivity();
        listFragment = new ListFragment();
        btnCloseAdding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.changeMode(listFragment);
            }
        });
        return rootView;
    }
}
