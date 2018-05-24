package com.example.utso.myrestaurantapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;
    Typeface myFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.titleText);
        imageView = (ImageView) findViewById(R.id.imageCover);

        fontModification();

        new CountDownTimer(3000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        }.start();
    }

    void fontModification(){
        myFont = Typeface.createFromAsset(this.getAssets(),"fonts/app_title.ttf");
        textView.setTypeface(myFont);
    }
}
