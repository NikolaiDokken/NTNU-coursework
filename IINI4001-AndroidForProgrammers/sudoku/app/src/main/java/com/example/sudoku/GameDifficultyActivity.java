package com.example.sudoku;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class GameDifficultyActivity extends AppCompatActivity {
    private boolean newBoard = false;
    private int selectedDifficulty = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_difficulty);
        newBoard = getIntent().getBooleanExtra("newBoard", false);
        if (newBoard) {
            Button buttonContinue = findViewById(R.id.buttonContinue);
            buttonContinue.setText(getString(R.string.add_new_board));
        }
    }

    public void onGoBackButtonClicked(View view) {
        finish();
    }

    public void onDifficultyRadioButtonsClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Radiobuttons selecting difficulty
        switch (view.getId()) {
            case R.id.radioButtonEasy:
                if (checked) {
                    selectedDifficulty = 0;
                }
                break;
            case R.id.radioButtonNormal:
                if (checked) {
                    selectedDifficulty = 1;
                }
                break;
            case R.id.radioButtonHard:
                if (checked) {
                    selectedDifficulty = 2;
                }
                break;
        }
    }

    public void onStartGameButtonClicked(View view) {
        if (newBoard) {
            // Adds new board and notifies user
            Intent intent = new Intent("com.example.MainActivity");
            intent.putExtra("boardSaved", true);
            intent.putExtra("difficulty", selectedDifficulty);
            setResult(RESULT_OK, intent);
            finish();
        } else {
            // Go to game afer selecting difficulty
            Intent intent = new Intent("com.example.GameActivity");
            intent.putExtra("difficulty", selectedDifficulty);
            startActivity(intent);
        }
    }
}
