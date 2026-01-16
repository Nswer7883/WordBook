package com.example.wordbook;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private ListFragment listFragment;
    private QuizFragment quizFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listFragment = new ListFragment();
        quizFragment = new QuizFragment();
        Button btnChangeList = findViewById(R.id.btn_change_list);
        Button btnChangeQuiz = findViewById(R.id.btn_change_quiz);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_changeable, listFragment).commit();

        btnChangeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_changeable, listFragment)
                        .commit();
            }
        });
        btnChangeQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_changeable, quizFragment)
                        .commit();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

/*    public void changeMode(View view) {
        transaction = fragmentManager.beginTransaction();

        switch (view.getId()) {
            case R.id.btn_change_list:
                transaction.replace(R.id.frame_changeable, listFragment).commitAllowingStateLoss();
                break;
            case R.id.btn_change_quiz:
                transaction.replace(R.id.frame_changeable, quizFragment).commitAllowingStateLoss();
                break;
        }
    }*/
}