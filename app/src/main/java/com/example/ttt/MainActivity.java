package com.example.ttt;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int[] game = {2,2,2,2,2,2,2,2,2};
    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    int activeplayer = 0;
    boolean gameactive = true;



    public void dropin(View view){
        ImageView counter = (ImageView) view;



        int tappedcounter = Integer.parseInt(counter.getTag().toString());

        if(game[tappedcounter] ==2 && gameactive) {

            game[tappedcounter] = activeplayer;
            counter.setTranslationY(-1500);

            if (activeplayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activeplayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activeplayer = 0;

            }
            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

            for (int[] a : winningPositions) {
                if (game[a[0]] == game[a[1]] && game[a[1]] == game[a[2]] && game[a[1]] != 2) {
                    gameactive=false;
                    String winner;
                    if (activeplayer == 1) {
                        winner = "yellow ";
                    } else {
                        winner = "red ";
                    }
                    Button again = (Button) findViewById(R.id.button2);
                    TextView won = (TextView) findViewById(R.id.textView2);

                    won.setText(winner + "has won");
                    again.setVisibility(View.VISIBLE);
                    won.setVisibility(View.VISIBLE);

                }
            }
        }
    }

    public void playagain(View view){

        Button again = (Button) findViewById(R.id.button2);
        TextView won = (TextView) findViewById(R.id.textView2);
        again.setVisibility(View.INVISIBLE);
        won.setVisibility(View.INVISIBLE);

        GridLayout grid = (GridLayout) findViewById(R.id.gridy);
        for(int i=0; i<grid.getChildCount();i++){
            ImageView x = (ImageView) grid.getChildAt(i);
            x.setImageDrawable(null);

        }
        for(int i=0;i<game.length;i++){
            game[i]=2;
        }

        activeplayer=0;
        gameactive = true;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}