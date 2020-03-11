package com.maity.sense;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.speech.RecognizerIntent;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Locale;
import android.os.Vibrator;
import android.os.VibrationEffect;

public class SpeechToText extends AppCompatActivity {
    private TextView tv;
    private Vibrator vb ;
    public static final int  REQUEST_CODE_SPEECH_INPUT=1000;
    private String ar[][]={{"A","._"},{"B","_..."},{"C","_._."},{"D","_.."},{"E","."},
            {"F","..-."},{"G","__."},{"H","...."},{"I",".."},{"J",".___"},
            {"K","_._"},{"L","._.."},{"M","__"},{"N","_."},{"O","___"},
            {"P",".__."},{"Q","__._"},{"R","._."},{"S","..."},{"T","_"},
            {"U",".._"},{"V","..._"},{"W",".__"},{"X","_.._"},{"Y","_.__"},
            {"Z","__.."},{"1",".____"},{"2","..___"},{"3","...__"},{"4","...._"},
            {"5","....."},{"6","_...."},{"7","__..."},{"8","___.."},{"9","____."},
            {"0","_____"},{" ","/"},{" ",","}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_to_text);
        vb= (Vibrator) getSystemService(VIBRATOR_SERVICE);
    }
    public void speak(View view)
    {
        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speak to Covert");

        try
        {

            startActivityForResult(intent,REQUEST_CODE_SPEECH_INPUT);
        }
        catch(Exception e)
        {}

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String s="";
        switch(requestCode)
        {
            case REQUEST_CODE_SPEECH_INPUT :
                if(resultCode==RESULT_OK && null != data ){
                    ArrayList<String> result= data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    tv=(TextView) findViewById(R.id.textView);
                    s=result.get(0);
                    tv.setText(s);
                    getMouseCode(s);

                }

                break;


        }
        //converting text to touch


    }

    private String getMouseCode(String s)
    {
         String ans="";
        int i=0,j=0;
        for(i=0;i<s.length();i++)
        {
            for(j=0;j<36;j++)
            {
                if((s.charAt(i)+"").equals(ar[j][0]))
                {
                    ans=ans+ar[j][1];
                    sendhaptic(ar[j][1]);
                }

            }

        }
        return ans;
    }

    private void sendhaptic(String s)
    {

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='.')
                vb.vibrate(100);
            else
                vb.vibrate(600);

        }
    }
}
