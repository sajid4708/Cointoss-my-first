package com.example.cointoss;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splashscreen extends MainActivity {
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RunAnimation();




        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(splashscreen.this,firstpage.class);
                startActivity(intent);
                finish();
            }
        },1000);

    }
    private void RunAnimation()
    {

        Animation a = AnimationUtils.loadAnimation(this, R.anim.scale);
        a.reset();
        TextView txt=(TextView)findViewById(R.id.textView2);
        ImageView img=(ImageView)findViewById(R.id.fullview) ;
        img.setImageResource(R.mipmap.onion_launcher);
        txt.clearAnimation();
        img.clearAnimation();
        txt.startAnimation(a);
        img.startAnimation(a);

    }
}

