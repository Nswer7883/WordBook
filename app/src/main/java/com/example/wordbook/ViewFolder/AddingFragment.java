package com.example.wordbook.ViewFolder;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wordbook.R;
import com.example.wordbook.ViewModelFolder.WordBookVM;

public class AddingFragment extends Fragment {

    private ImageButton btnCloseAdding;
    private Button btnCreate;
    private EditText etSpelling, etMeaning, etDescription;
    private MainActivity mainActivity;
    private ListFragment listFragment;
    private WordBookVM viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_adding, container, false);
        mainActivity = (MainActivity) getActivity();
        viewModel = new ViewModelProvider(requireActivity()).get(WordBookVM.class);
        listFragment = new ListFragment();
        btnCloseAdding = rootView.findViewById(R.id.btn_close_adding);
        btnCreate = rootView.findViewById(R.id.btn_create);
        etSpelling = rootView.findViewById(R.id.et_spelling);
        etMeaning = rootView.findViewById(R.id.et_meaning);
        etDescription = rootView.findViewById(R.id.et_description);
        btnCloseAdding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.changeMode(listFragment);
            }
        });
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etSpelling = rootView.findViewById(R.id.et_spelling);
                etMeaning = rootView.findViewById(R.id.et_meaning);
                etDescription = rootView.findViewById(R.id.et_description);
                clickCreate();
            }
        });
        return rootView;
    }

    public void clickCreate() {
        viewModel.setSpelling(etSpelling.getText().toString());
        viewModel.setMeaning(etMeaning.getText().toString());
        viewModel.setDescription(etDescription.getText().toString());
        viewModel.makeWordCard();
    }
}
