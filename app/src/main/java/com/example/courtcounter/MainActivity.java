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
        TextView totalA_score = (TextView) findViewById(R.id.player_a_score);
        String temp1 = totalA_score.getText().toString();
        int total_score = 0;
        if (!"".equals(temp1)){
            total_score = Integer.parseInt(temp1);
        }

        EditText playerA_score = (EditText) findViewById(R.id.player_a_edit_text);
        String temp2 = playerA_score.getText().toString();
        int value = 0;
        if (!"".equals(temp2)){
            value = Integer.parseInt(temp2);
        }

        TextView leftA_throws = (TextView) findViewById(R.id.throws_leftA);
        String temp3 = leftA_throws.getText().toString();
        int left = 0;
        if (!"".equals(temp3)){
            left = Integer.parseInt(temp3);
        }

        if(value < total_score) {
            scorePlayerA = total_score - value;
            throws_leftA = left - 3;
            displayForPlayerA(scorePlayerA, throws_leftA);
        }else if(value > total_score){
            throws_leftA = left - 3;
            displayForPlayerA(scorePlayerA, throws_leftA);
        }else{
            throws_leftA = left - 3;
            displayWinnerA(throws_leftA);
        }
    }

    /**
     * Subtract the score for Player B.
     */
    public void subtractScoreForPlayerB(View v) {
        TextView totalB_score = (TextView) findViewById(R.id.player_b_score);
        String temp1 = totalB_score.getText().toString();
        int total = 0;
        if (!"".equals(temp1)){
            total = Integer.parseInt(temp1);
        }

        EditText playerB_score = (EditText) findViewById(R.id.player_b_edit_text);
        String temp2 = playerB_score.getText().toString();
        int value = 0;
        if (!"".equals(temp2)){
            value = Integer.parseInt(temp2);
        }

        TextView leftB_throws = (TextView) findViewById(R.id.throws_leftB);
        String temp3 = leftB_throws.getText().toString();
        int left = 0;
        if (!"".equals(temp3)){
            left = Integer.parseInt(temp3);
        }

        if(value < total) {
            scorePlayerB = total - value;
            throws_leftB = left - 3;
            displayForPlayerB(scorePlayerB, throws_leftB);
        }else if(value > total){
            throws_leftB = left - 3;
            displayForPlayerB(scorePlayerB, throws_leftB);
        }else{
            throws_leftB = left - 3;
            displayWinnerB(throws_leftB);
        }
    }

    /**
     * Displays the given score for Player A.
     *
     * @param left is the left quantity of darts to throw
     * @param score is how left scores player should subtract
     */
    public void displayForPlayerA(int score, int left) {
        TextView leftViewA = (TextView) findViewById(R.id.throws_leftA);
        if (left == -3) {
            Toast.makeText(this, getText(R.string.throws_done), Toast.LENGTH_SHORT).show();
            return;
        }else {
            leftViewA.setText(String.valueOf(left));
            TextView scoreView = (TextView) findViewById(R.id.player_a_score);
            scoreView.setText(String.valueOf(score));
            EditText playerAscore = (EditText) findViewById(R.id.player_a_edit_text);
            playerAscore.setText(null);
        }
    }

    /**
     * Displays the given score for Player B.
     *
     * @param left is the left quantity of darts to throw
     * @param score is how left scores player should subtract
     */
    public void displayForPlayerB(int score, int left) {
        TextView leftViewB = (TextView) findViewById(R.id.throws_leftB);
        if (left == -3) {
            Toast.makeText(this, getText(R.string.throws_done), Toast.LENGTH_SHORT).show();
            return;
        }else {
            leftViewB.setText(String.valueOf(left));
            TextView scoreView = (TextView) findViewById(R.id.player_b_score);
            scoreView.setText(String.valueOf(score));
            EditText playerBscore = (EditText) findViewById(R.id.player_b_edit_text);
            playerBscore.setText(null);
        }
    }

    /**
     * Displays winner A message.
     *
     * @param left is the left quantity of darts to throw
     */
    public void displayWinnerA(int left) {
        TextView scoreView = (TextView) findViewById(R.id.player_a_score);
        scoreView.setText(String.valueOf(getText(R.string.win)));
        EditText playerAscore = (EditText) findViewById(R.id.player_a_edit_text);
        playerAscore.setText(getText(R.string.congrats));
        TextView leftViewA = (TextView) findViewById(R.id.throws_leftA);
        leftViewA.setText(left);
    }

    /**
     * Displays winner B message.
     *
     * @param left is the left quantity of darts to throw
     */
    public void displayWinnerB(int left) {
        TextView scoreView = (TextView) findViewById(R.id.player_b_score);
        scoreView.setText(String.valueOf(getText(R.string.win)));
        EditText playerAscore = (EditText) findViewById(R.id.player_b_edit_text);
        playerAscore.setText(getText(R.string.congrats));
        TextView leftViewB = (TextView) findViewById(R.id.throws_leftB);
        leftViewB.setText(left);
    }

    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        int quantity = 1;
        scorePlayerA = 101;
        scorePlayerB = 101;
        throws_leftA = 54;
        throws_leftB = 54;
        TextView gameTextView = (TextView) findViewById(R.id.game_text_view);
        gameTextView.setText("" + quantity);
        displayForPlayerA(scorePlayerA, throws_leftB);
        displayForPlayerB(scorePlayerB, throws_leftB);
    }
}
