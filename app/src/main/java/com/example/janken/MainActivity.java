package com.example.janken;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text = (TextView)findViewById(R.id.text);
        final TextView subtext = (TextView)findViewById(R.id.subtext);
        Button rock = (Button)findViewById(R.id.rock);
        Button scissors = (Button)findViewById(R.id.scissors);
        Button paper = (Button)findViewById(R.id.paper);

        //opponentHand 1 "rock"
        //opponentHand 2 "scissors"
        //opponentHand 3 "paper"
        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int opponentHand = decideOpponentHand();
                String opponentHandText = changeTextOpponentHand(opponentHand);
                decideGame(1, opponentHand, subtext);
                text.setText(opponentHandText);
            }
        });
        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int opponentHand = decideOpponentHand();
                String opponentHandText = changeTextOpponentHand(opponentHand);
                decideGame(2, opponentHand, subtext);
                text.setText(opponentHandText);
            }
        });
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int opponentHand = decideOpponentHand();
                String opponentHandText = changeTextOpponentHand(opponentHand);
                decideGame(3, opponentHand, subtext);
                text.setText(opponentHandText);
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    String changeTextOpponentHand(int hand) {
        String handText = "";
        if (hand == 1) handText = "ぐー";
        else if (hand == 2) handText = "ちょき";
        else if (hand == 3) handText = "ぱー";
        return handText;
    }

    int decideOpponentHand() {
        Random rnd = new Random();
        int hand = rnd.nextInt(3)+1;
        return hand;
    }

    void decideGame (int playerHand, int opponentHand, TextView decidetext) {
        String decision;
        if (playerHand == opponentHand) decision = "あいこ";
        else if((playerHand == 3 && opponentHand == 1) || (playerHand+1 == opponentHand)) decision = "勝ち";
        else decision = "負け";
        decidetext.setText(decision);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
