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

import com.example.wordbook.R;

public class ListFragment extends Fragment {
    private ImageButton btnAdding;
    MainActivity mainActivity;
    Fragment addingFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);
        btnAdding = rootView.findViewById(R.id.btn_adding);
        mainActivity = (MainActivity) getActivity();
        addingFragment = new AddingFragment();
        btnAdding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.changeMode(addingFragment);
            }
        });

        return rootView;
    }
}
