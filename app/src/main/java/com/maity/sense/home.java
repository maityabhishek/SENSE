package com.maity.sense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageButton;
import android.widget.ImageView;

public class home extends AppCompatActivity {

    private ImageView bgapp,cv;
    private ImageButton saybtn,listenbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        saybtn=(ImageButton) findViewById(R.id.saybtn);
        listenbtn=(ImageButton) findViewById(R.id.listenbtn);
        bgapp =(ImageView) findViewById(R.id.bgapp);
        cv =(ImageView) findViewById(R.id.clover);

        bgapp.animate().translationY(-500).setDuration(800).setStartDelay(300 );
        cv.animate().translationY(-200).setDuration(800).setStartDelay(600 );
        saybtn.animate().translationY(-200).setDuration(800).setStartDelay(600 );
        listenbtn.animate().translationY(-200).setDuration(800).setStartDelay(600 );
    }
    public void toListen(View view)
    {
        Intent intent=new Intent(home.this,SpeechToText.class);
        startActivity(intent);
        finish();

    }
    public void toSay(View view)
    {
        Intent intent=new Intent(home.this,Main2Activity.class);
        startActivity(intent);
        finish();
    }
}
