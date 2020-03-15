package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class MainActivity<scorePlayerA> extends AppCompatActivity {

    int quantity = 1;
    int throws_leftA = 54;
    int throws_leftB = 54;
    int scorePlayerA = 101;
    int scorePlayerB = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView playerAtextView = (TextView) findViewById(R.id.player_a_score);
        playerAtextView.setText("" + 101);
        TextView playerBtextView = (TextView) findViewById(R.id.player_b_score);
        playerBtextView.setText("" + 101);
    }

    /**
     * This method for increse the quantity.
     */
    public void increse(View view) {
        if (quantity == 9) {
            Toast.makeText(this, getText(R.string.more_9), Toast.LENGTH_SHORT).show();
            return;
        }
        quantity++;
        TextView gameTextView = (TextView) findViewById(R.id.game_text_view);
        gameTextView.setText("" + quantity);

        TextView playerAtextView = (TextView) findViewById(R.id.player_a_score);
        playerAtextView.setText("" + (quantity * 100 + 1));
        TextView playerBtextView = (TextView) findViewById(R.id.player_b_score);
        playerBtextView.setText("" + (quantity * 100 + 1));
    }

    /**
     * This method for decrese the quantity.
     */
    public void decrese(View view) {
        if (quantity == 1) {
            Toast.makeText(this, getText(R.string.less_1), Toast.LENGTH_SHORT).show();
            return;
        }
        quantity--;
        TextView gameTextView = (TextView) findViewById(R.id.game_text_view);
        gameTextView.setText("" + quantity);

        TextView playerAtextView = (TextView) findViewById(R.id.player_a_score);
        playerAtextView.setText("" + (quantity * 100 + 1));
        TextView playerBtextView = (TextView) findViewById(R.id.player_b_score);
        playerBtextView.setText("" + (quantity * 100 + 1));
    }


    /**
     * Subtract the score for Player A.
     */
    public void subtractScoreForPlayerA(View v) {
        TextView totalAscore = (TextView) findViewById(R.id.player_a_score);
        String temp1 = totalAscore.getText().toString();
        int total = 0;
        if (!"".equals(temp1)){
            total = Integer.parseInt(temp1);
        }

        EditText playerAscore = (EditText) findViewById(R.id.player_a_edit_text);
        String temp2 = playerAscore.getText().toString();
        int value = 0;
        if (!"".equals(temp2)){
            value = Integer.parseInt(temp2);
        }

        TextView leftAthrows = (TextView) findViewById(R.id.throws_leftA);
        String temp3 = totalAscore.getText().toString();
        int left = 0;
        if (!"".equals(temp3)){
            left = Integer.parseInt(temp3);
        }
        left -= 3;

        scorePlayerA = total - value;
        displayForPlayerA(scorePlayerA, left);
    }

    /**
     * Subtract the score for Player B.
     */
    public void subtractScoreForPlayerB(View v) {
        TextView totalBscore = (TextView) findViewById(R.id.player_b_score);
        String temp1 = totalBscore.getText().toString();
        int total = 0;
        if (!"".equals(temp1)){
            total = Integer.parseInt(temp1);
        }

        EditText playerBscore = (EditText) findViewById(R.id.player_b_edit_text);
        String temp2 = playerBscore.getText().toString();
        int value = 0;
        if (!"".equals(temp2)){
            value = Integer.parseInt(temp2);
        }

        TextView leftBthrows = (TextView) findViewById(R.id.throws_leftB);
        String temp3 = totalBscore.getText().toString();
        int left = 0;
        if (!"".equals(temp3)){
            left = Integer.parseInt(temp3);
        }
        left -= 3;

        scorePlayerB = total - value;
        displayForPlayerB(scorePlayerB, left);
    }

    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        scorePlayerA = 101;
        scorePlayerB = 101;
        throws_leftA = 54;
        throws_leftB = 54;
        displayForPlayerA(scorePlayerA, throws_leftA);
        displayForPlayerB(scorePlayerB, throws_leftB);
    }


    /**
     * Displays the given score for Teams.
     */
    public void displayForPlayerA(int score, int left) {
        TextView scoreView = (TextView) findViewById(R.id.player_a_score);
        scoreView.setText(String.valueOf(score));
        EditText playerAscore = (EditText) findViewById(R.id.player_a_edit_text);
        playerAscore.setText(null);
        TextView leftView = (TextView) findViewById(R.id.throws_leftA);
        leftView.setText(left);
    }

    public void displayForPlayerB(int score, int left) {
        TextView scoreView = (TextView) findViewById(R.id.player_b_score);
        scoreView.setText(String.valueOf(score));
        EditText playerAscore = (EditText) findViewById(R.id.player_a_edit_text);
        playerAscore.setText(null);
        TextView leftView = (TextView) findViewById(R.id.throws_leftB);
        leftView.setText(left);
    }
}
