package com.example.wordbook.ViewFolder;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.wordbook.R;
import com.example.wordbook.ViewModelFolder.WordBookVM;

public class MainActivity extends AppCompatActivity {
    public Fragment listFragment;
    public Fragment quizFragment;
    public WordBookVM viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(WordBookVM.class);

        listFragment = new ListFragment();
        quizFragment = new QuizFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.frame_changeable, listFragment).commit();

        Button btnChangeList = findViewById(R.id.btn_change_list);
        Button btnChangeQuiz = findViewById(R.id.btn_change_quiz);

        btnChangeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeMode(listFragment);
            }
        });
        btnChangeQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeMode(quizFragment);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void changeMode(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_changeable, fragment).commit();
    }
}