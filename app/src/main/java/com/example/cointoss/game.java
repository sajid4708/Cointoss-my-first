package com.example.cointoss;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class game extends AppCompatActivity {
    private TextView txt;
    private Button head;
    private Button tail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);
        txt=findViewById(R.id.gameq);
        head=findViewById(R.id.Head);
        tail=findViewById(R.id.Tail);
        RunAnimation();
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hider();

                TextView tossing=(TextView)findViewById(R.id.result);
                tossing.setText(R.string.Toss);
                Handler handler;
                handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                      selector(true);








                        Handler handlers;
                        handlers=new Handler();
                        handlers.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent=new Intent(game.this,game.class);
                                startActivity(intent);
                                finish();
                            }
                        },1000);

                    }
                },3000);
            }
        });
        tail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hider();
                TextView tossing=(TextView)findViewById(R.id.result);
                tossing.setText(R.string.Toss);

                Handler handler;
                handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        selector(false);
                         Handler handlers;
                        handlers=new Handler();
                        handlers.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent=new Intent(game.this,game.class);
                                startActivity(intent);
                                finish();
                            }
                        },1000);






                    }
                },3000);
            }
        });
    }
    private void RunAnimation()
    {

        Animation a = AnimationUtils.loadAnimation(this, R.anim.scale);
        a.reset();
        head.clearAnimation();
        tail.clearAnimation();
        txt.clearAnimation();
        txt.startAnimation(a);
        head.startAnimation(a);
        tail.startAnimation(a);




    }
    @SuppressLint("ResourceAsColor")
    private void selector(boolean status)
    {
        if(status=coin_status())
        {
            TextView youwon=(TextView)findViewById(R.id.result);
            youwon.setTextColor(Color.GREEN);
            youwon.setText(R.string.Youwon);
        }
        else{
            TextView youlost=(TextView)findViewById(R.id.result);
            youlost.setTextColor(Color.RED);
            youlost.setText(R.string.lost);
    }
    }
    private boolean coin_status()
    {

        Random r=new Random();
        return r.nextBoolean();
    }
    private void hider()
    {
        txt.setVisibility(View.INVISIBLE);
        txt.setEnabled(false);
        head.setVisibility(View.INVISIBLE);
        head.setEnabled(false);
        tail.setVisibility(View.INVISIBLE);
        tail.setEnabled(false);

    }
}
