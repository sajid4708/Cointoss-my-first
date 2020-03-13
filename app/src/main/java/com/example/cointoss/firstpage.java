package com.example.cointoss;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class firstpage extends MainActivity {
    private TextView txtfirst;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);
        txtfirst=(TextView)findViewById(R.id.textViewfirst);
        btn=(Button)findViewById(R.id.buttonfirst1);
        RunAnimatio();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn.setEnabled(false);
                RunAnimationfrst();
                handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(firstpage.this,game.class);
                        startActivity(intent);
                        finish();
                    }
                },250);



            }
        });

    }
    private void RunAnimationfrst()
    {

        Animation b = AnimationUtils.loadAnimation(this,R.anim.fade);
        b.reset();

txtfirst.clearAnimation();
btn.clearAnimation();

        txtfirst.startAnimation(b);
        btn.startAnimation(b);


    }
    private void RunAnimatio()
    {

        Animation a = AnimationUtils.loadAnimation(this, R.anim.scale);
        a.reset();
        txtfirst.clearAnimation();
        btn.clearAnimation();

        txtfirst.startAnimation(a);
        btn.startAnimation(a);


    }
}

