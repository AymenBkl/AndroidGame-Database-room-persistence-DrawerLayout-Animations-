package com.example.khamamm3ayachwiya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.khamamm3ayachwiya.Animations.AnimationController;

import org.w3c.dom.Text;

public class Splash extends AppCompatActivity {
    private AnimationController animationController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        animationController = new AnimationController(getApplicationContext());
        TextView txt1 = (TextView) findViewById(R.id.text1);
        TextView txt2 = (TextView) findViewById(R.id.text2);
        TextView txt3 = (TextView) findViewById(R.id.enjoy);
        animationController.setAnimatioTop(txt1);
        animationController.setAnimationBottom(txt2);
        animationController.setLeftToRightAnim(txt3);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(Splash.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, 2000);
    }
}
