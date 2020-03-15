package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quantity = 1;
    int scorePlayerRed = 0;
    int scorePlayerGreen = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NumberPicker np = findViewById(R.id.numberPicker1);

        np.setMinValue(1);
        np.setMaxValue(180);

        np.setOnValueChangedListener(onValueChangeListener);
    }

    /**
     * Increase the score by 1 point.
     */
    public void addOneForTeamA(View v) {
        scorePlayerRed = scorePlayerRed + 1;
        displayForPlayerRed(scorePlayerRed);
    }

    public void addOneForTeamB(View v) {
        scorePlayerGreen = scorePlayerGreen + 1;
        displayForPlayerGreen(scorePlayerGreen);
    }

    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        scorePlayerRed = 0;
        scorePlayerGreen = 0;
        displayForPlayerRed(scorePlayerRed);
        displayForPlayerGreen(scorePlayerGreen);
    }


    /**
     * This method for increse the quantity.
     */
    public void increse(View view) {
        if(quantity == 9){
            Toast.makeText(this, getText(R.string.more_9), Toast.LENGTH_SHORT).show();
            return;
        }
        quantity++;
        TextView gameTextView = (TextView) findViewById(R.id.game_text_view);
        gameTextView.setText("" + quantity);
    }

    /**
     * This method for decrese the quantity.
     */
    public void decrese(View view) {
        if(quantity == 1){
            Toast.makeText(this, getText(R.string.less_1), Toast.LENGTH_SHORT).show();
            return;
        }
        quantity--;
        TextView gameTextView = (TextView) findViewById(R.id.game_text_view);
        gameTextView.setText("" + quantity);
    }


    /**
     * Picker one.
     */
    NumberPicker.OnValueChangeListener onValueChangeListener =
            new 	NumberPicker.OnValueChangeListener(){
                @Override
                public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                    Toast.makeText(MainActivity.this,
                            "selected number "+numberPicker.getValue(), Toast.LENGTH_SHORT);
                }
            };


    /**
     * Displays the given score for Teams.
     */
    public void displayForPlayerRed(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForPlayerGreen(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
