package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
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
     * This method for increase the game 101 - 901.
     */
    public void increse(View view) {
        if (quantity == 9) {
            Toast.makeText(this, getText(R.string.more_9), Toast.LENGTH_SHORT).show();
            return;
        }
        quantity++;
        TextView gameTextView = (TextView) findViewById(R.id.game_text_view);
        gameTextView.setText("" + quantity);

        EditText playerAscore1 = (EditText) findViewById(R.id.player_a_edit_text1);
        playerAscore1.setText(null);
        EditText playerAscore2 = (EditText) findViewById(R.id.player_a_edit_text2);
        playerAscore2.setText(null);
        EditText playerAscore3 = (EditText) findViewById(R.id.player_a_edit_text3);
        playerAscore3.setText(null);
        EditText playerBscore1 = (EditText) findViewById(R.id.player_b_edit_text1);
        playerBscore1.setText(null);
        EditText playerBscore2 = (EditText) findViewById(R.id.player_b_edit_text2);
        playerBscore2.setText(null);
        EditText playerBscore3 = (EditText) findViewById(R.id.player_b_edit_text3);
        playerBscore3.setText(null);
        TextView arrowLeft = (TextView) findViewById(R.id.arrowLeft);
        arrowLeft.setText(null);
        TextView arrowRight = (TextView) findViewById(R.id.arrowRight);
        arrowRight.setText(null);

        TextView playerAtextView = (TextView) findViewById(R.id.player_a_score);
        playerAtextView.setText("" + (quantity * 100 + 1));
        TextView playerBtextView = (TextView) findViewById(R.id.player_b_score);
        playerBtextView.setText("" + (quantity * 100 + 1));
    }

    /**
     * This method for decrease the game 101 - 901.
     */
    public void decrese(View view) {
        if (quantity == 1) {
            Toast.makeText(this, getText(R.string.less_1), Toast.LENGTH_SHORT).show();
            return;
        }
        quantity--;
        TextView gameTextView = (TextView) findViewById(R.id.game_text_view);
        gameTextView.setText("" + quantity);

        EditText playerAscore1 = (EditText) findViewById(R.id.player_a_edit_text1);
        playerAscore1.setText(null);
        EditText playerAscore2 = (EditText) findViewById(R.id.player_a_edit_text2);
        playerAscore2.setText(null);
        EditText playerAscore3 = (EditText) findViewById(R.id.player_a_edit_text3);
        playerAscore3.setText(null);
        EditText playerBscore1 = (EditText) findViewById(R.id.player_b_edit_text1);
        playerBscore1.setText(null);
        EditText playerBscore2 = (EditText) findViewById(R.id.player_b_edit_text2);
        playerBscore2.setText(null);
        EditText playerBscore3 = (EditText) findViewById(R.id.player_b_edit_text3);
        playerBscore3.setText(null);
        TextView arrowLeft = (TextView) findViewById(R.id.arrowLeft);
        arrowLeft.setText(null);
        TextView arrowRight = (TextView) findViewById(R.id.arrowRight);
        arrowRight.setText(null);

        TextView playerAtextView = (TextView) findViewById(R.id.player_a_score);
        playerAtextView.setText("" + (quantity * 100 + 1));
        TextView playerBtextView = (TextView) findViewById(R.id.player_b_score);
        playerBtextView.setText("" + (quantity * 100 + 1));
    }

    /**
     * Subtract the score for Player A.
     */
    public void subtractScoreForPlayerA(View view) {
        int total_score = 0;
        TextView totalA_score = (TextView) findViewById(R.id.player_a_score);
        String temp1 = totalA_score.getText().toString();
        if (temp1.equals(R.string.win)) {
            Toast.makeText(this, getText(R.string.game_over), Toast.LENGTH_SHORT).show();
            return;
        } else {
            if (!"".equals(temp1)) {
                total_score = Integer.parseInt(temp1);
            }
        }

        EditText playerA_score1 = (EditText) findViewById(R.id.player_a_edit_text1);
        String temp2 = playerA_score1.getText().toString();
        int value1 = 0;
        if (!"".equals(temp2)) {
            value1 = Integer.parseInt(temp2);
        } else {
            Toast.makeText(this, getText(R.string.add_value), Toast.LENGTH_SHORT).show();
            return;
        }

        EditText playerA_score2 = (EditText) findViewById(R.id.player_a_edit_text2);
        String temp3 = playerA_score2.getText().toString();
        int value2 = 0;
        if (!"".equals(temp3)) {
            value2 = Integer.parseInt(temp3);
        } else {
            Toast.makeText(this, getText(R.string.add_value), Toast.LENGTH_SHORT).show();
            return;
        }

        EditText playerA_score3 = (EditText) findViewById(R.id.player_a_edit_text3);
        String temp4 = playerA_score3.getText().toString();
        int value3 = 0;
        if (!"".equals(temp4)) {
            value3 = Integer.parseInt(temp4);
        }else {
            Toast.makeText(this, getText(R.string.add_value), Toast.LENGTH_SHORT).show();
            return;
        }

        TextView leftA_throws = (TextView) findViewById(R.id.throws_leftA);
        String temp5 = leftA_throws.getText().toString();
        int left = 0;
        if (!"".equals(temp5)) {
            left = Integer.parseInt(temp5);
        }

        int valueTotal = value1 + value2 + value3;
        if (valueTotal >= 181) {
            Toast.makeText(this, getText(R.string.more_180), Toast.LENGTH_SHORT).show();
            return;
        }else if (valueTotal < total_score) {
            scorePlayerA = total_score - valueTotal;
            throws_leftA = left - 3;
            displayForPlayerA(scorePlayerA, throws_leftA);
        } else if (valueTotal > total_score) {
            throws_leftA = left - 3;
            displayForPlayerA(total_score, throws_leftA);
            Toast.makeText(this, getText(R.string.switch_b), Toast.LENGTH_SHORT).show();
        } else {
            throws_leftA = left - 3;
            displayWinnerA(throws_leftA);
        }
    }

    /**
     * Subtract the score for Player B.
     */
    public void subtractScoreForPlayerB(View view) {
        int total_score = 0;
        TextView totalB_score = (TextView) findViewById(R.id.player_b_score);
        String temp1 = totalB_score.getText().toString();
        if (temp1.equals(R.string.win)) {
            Toast.makeText(this, getText(R.string.game_over), Toast.LENGTH_SHORT).show();
            return;
        } else {
            if (!"".equals(temp1)) {
                total_score = Integer.parseInt(temp1);
            }
        }

        EditText playerB_score1 = (EditText) findViewById(R.id.player_b_edit_text1);
        String temp2 = playerB_score1.getText().toString();
        int value1 = 0;
        if (!"".equals(temp2)) {
            value1 = Integer.parseInt(temp2);
        }else {
            Toast.makeText(this, getText(R.string.add_value), Toast.LENGTH_SHORT).show();
            return;
        }

        EditText playerB_score2 = (EditText) findViewById(R.id.player_b_edit_text2);
        String temp3 = playerB_score2.getText().toString();
        int value2 = 0;
        if (!"".equals(temp3)) {
            value2 = Integer.parseInt(temp3);
        }else {
            Toast.makeText(this, getText(R.string.add_value), Toast.LENGTH_SHORT).show();
            return;
        }

        EditText playerB_score3 = (EditText) findViewById(R.id.player_b_edit_text3);
        String temp4 = playerB_score3.getText().toString();
        int value3 = 0;
        if (!"".equals(temp4)) {
            value3 = Integer.parseInt(temp4);
        }else {
            Toast.makeText(this, getText(R.string.add_value), Toast.LENGTH_SHORT).show();
            return;
        }

        TextView leftB_throws = (TextView) findViewById(R.id.throws_leftB);
        String temp5 = leftB_throws.getText().toString();
        int left = 0;
        if (!"".equals(temp5)) {
            left = Integer.parseInt(temp5);
        }

        int valueTotal = value1 + value2 + value3;

        if (valueTotal >= 181) {
            Toast.makeText(this, getText(R.string.more_180), Toast.LENGTH_SHORT).show();
            return;
        }else if (valueTotal < total_score) {
            scorePlayerB = total_score - valueTotal;
            throws_leftB = left - 3;
            displayForPlayerB(scorePlayerB, throws_leftB);
        } else if (valueTotal > total_score) {
            throws_leftB = left - 3;
            displayForPlayerB(total_score, throws_leftB);
            Toast.makeText(this, getText(R.string.switch_a), Toast.LENGTH_SHORT).show();
        } else {
            throws_leftB = left - 3;
            displayWinnerB(throws_leftB);
        }
    }

    /**
     * Displays the given score for Player A.
     *
     * @param left  is the left quantity of darts to throw
     * @param score is how left scores player should subtract
     */
    public void displayForPlayerA(int score, int left) {
        TextView leftViewA = (TextView) findViewById(R.id.throws_leftA);
        if (left == -3) {
            Toast.makeText(this, getText(R.string.throws_done), Toast.LENGTH_SHORT).show();
            return;
        } else {
            leftViewA.setText(String.valueOf(left));
            TextView scoreView = (TextView) findViewById(R.id.player_a_score);
            scoreView.setText(String.valueOf(score));
            EditText playerAscore1 = (EditText) findViewById(R.id.player_a_edit_text1);
            playerAscore1.setText(null);
            EditText playerAscore2 = (EditText) findViewById(R.id.player_a_edit_text2);
            playerAscore2.setText(null);
            EditText playerAscore3 = (EditText) findViewById(R.id.player_a_edit_text3);
            playerAscore3.setText(null);
        }
    }

    /**
     * Displays the given score for Player B.
     *
     * @param left  is the left quantity of darts to throw
     * @param score is how left scores player should subtract
     */
    public void displayForPlayerB(int score, int left) {
        TextView leftViewB = (TextView) findViewById(R.id.throws_leftB);
        if (left == -3) {
            Toast.makeText(this, getText(R.string.throws_done), Toast.LENGTH_SHORT).show();
            return;
        } else {
            leftViewB.setText(String.valueOf(left));
            TextView scoreView = (TextView) findViewById(R.id.player_b_score);
            scoreView.setText(String.valueOf(score));
            EditText playerBscore1 = (EditText) findViewById(R.id.player_b_edit_text1);
            playerBscore1.setText(null);
            EditText playerBscore2 = (EditText) findViewById(R.id.player_b_edit_text2);
            playerBscore2.setText(null);
            EditText playerBscore3 = (EditText) findViewById(R.id.player_b_edit_text3);
            playerBscore3.setText(null);
        }
    }

    /**
     * Displays winner A message.
     *
     * @param left is the left quantity of darts to throw
     */
    public void displayWinnerA(int left) {
        TextView scoreViewA = (TextView) findViewById(R.id.player_a_score);
        scoreViewA.setText(getString(R.string.win));
        TextView scoreViewB = (TextView) findViewById(R.id.player_b_score);
        scoreViewB.setText(getString(R.string.lose));
        EditText playerAscore1 = (EditText) findViewById(R.id.player_a_edit_text1);
        playerAscore1.setText(R.string.star);
        EditText playerAscore2 = (EditText) findViewById(R.id.player_a_edit_text2);
        playerAscore2.setText(R.string.star);
        EditText playerAscore3 = (EditText) findViewById(R.id.player_a_edit_text3);
        playerAscore3.setText(R.string.star);
        EditText playerBscore1 = (EditText) findViewById(R.id.player_b_edit_text1);
        playerBscore1.setText(R.string.cross);
        EditText playerBscore2 = (EditText) findViewById(R.id.player_b_edit_text2);
        playerBscore2.setText(R.string.cross);
        EditText playerBscore3 = (EditText) findViewById(R.id.player_b_edit_text3);
        playerBscore3.setText(R.string.cross);
        TextView leftViewA = (TextView) findViewById(R.id.throws_leftA);
        leftViewA.setText(String.valueOf(left));
        TextView arrowLeft = (TextView) findViewById(R.id.arrowLeft);
        arrowLeft.setText(R.string.left_arrow);
        TextView arrowRight = (TextView) findViewById(R.id.arrowRight);
        arrowRight.setText(R.string.right_arrow);
    }

    /**
     * Displays winner B message.
     *
     * @param left is the left quantity of darts to throw
     */
    public void displayWinnerB(int left) {
        TextView scoreViewB = (TextView) findViewById(R.id.player_b_score);
        scoreViewB.setText(getString(R.string.win));
        TextView scoreViewA = (TextView) findViewById(R.id.player_a_score);
        scoreViewA.setText(getString(R.string.lose));
        EditText playerBscore1 = (EditText) findViewById(R.id.player_b_edit_text1);
        playerBscore1.setText(R.string.star);
        EditText playerBscore2 = (EditText) findViewById(R.id.player_b_edit_text2);
        playerBscore2.setText(R.string.star);
        EditText playerBscore3 = (EditText) findViewById(R.id.player_b_edit_text3);
        playerBscore3.setText(R.string.star);
        EditText playerAscore1 = (EditText) findViewById(R.id.player_a_edit_text1);
        playerAscore1.setText(R.string.cross);
        EditText playerAscore2 = (EditText) findViewById(R.id.player_a_edit_text2);
        playerAscore2.setText(R.string.cross);
        EditText playerAscore3 = (EditText) findViewById(R.id.player_a_edit_text3);
        playerAscore3.setText(R.string.cross);
        TextView leftViewB = (TextView) findViewById(R.id.throws_leftB);
        leftViewB.setText(String.valueOf(left));
        TextView arrowLeft = (TextView) findViewById(R.id.arrowLeft);
        arrowLeft.setText(R.string.left_arrow);
        TextView arrowRight = (TextView) findViewById(R.id.arrowRight);
        arrowRight.setText(R.string.right_arrow);
    }

    /**
     * This method for input scores == 0 by clicking on MISSED buttons A1.
     */
    public void missedScoreForPlayerA1(View view) {
        EditText playerAscore1 = (EditText) findViewById(R.id.player_a_edit_text1);
        playerAscore1.setText("0");
    }

    /**
     * This method for input scores == 0 by clicking on MISSED buttons A2.
     */
    public void missedScoreForPlayerA2(View view) {
        EditText playerAscore2 = (EditText) findViewById(R.id.player_a_edit_text2);
        playerAscore2.setText("0");
    }

    /**
     * This method for input scores == 0 by clicking on MISSED buttons A3.
     */
    public void missedScoreForPlayerA3(View view) {
        EditText playerAscore2 = (EditText) findViewById(R.id.player_a_edit_text3);
        playerAscore2.setText("0");
    }

    /**
     * This method for input scores == 0 by clicking on MISSED buttons B1.
     */
    public void missedScoreForPlayerB1(View view) {
        EditText playerBscore1 = (EditText) findViewById(R.id.player_b_edit_text1);
        playerBscore1.setText("0");
    }

    /**
     * This method for input scores == 0 by clicking on MISSED buttons B2.
     */
    public void missedScoreForPlayerB2(View view) {
        EditText playerBscore1 = (EditText) findViewById(R.id.player_b_edit_text2);
        playerBscore1.setText("0");
    }

    /**
     * This method for input scores == 0 by clicking on MISSED buttons B3.
     */
    public void missedScoreForPlayerB3(View view) {
        EditText playerBscore1 = (EditText) findViewById(R.id.player_b_edit_text3);
        playerBscore1.setText("0");
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
        EditText playerAscore1 = (EditText) findViewById(R.id.player_a_edit_text1);
        playerAscore1.setText(null);
        EditText playerAscore2 = (EditText) findViewById(R.id.player_a_edit_text2);
        playerAscore2.setText(null);
        EditText playerAscore3 = (EditText) findViewById(R.id.player_a_edit_text3);
        playerAscore3.setText(null);
        EditText playerBscore1 = (EditText) findViewById(R.id.player_b_edit_text1);
        playerBscore1.setText(null);
        EditText playerBscore2 = (EditText) findViewById(R.id.player_b_edit_text2);
        playerBscore2.setText(null);
        EditText playerBscore3 = (EditText) findViewById(R.id.player_b_edit_text3);
        playerBscore3.setText(null);
        TextView arrowLeft = (TextView) findViewById(R.id.arrowLeft);
        arrowLeft.setText(null);
        TextView arrowRight = (TextView) findViewById(R.id.arrowRight);
        arrowRight.setText(null);
    }
}
