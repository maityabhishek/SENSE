package com.maity.sense;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;
import java.util.Locale;

public class Main2Activity extends AppCompatActivity {
    private TextToSpeech t1;
    private String inputString="";
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
        setContentView(R.layout.activity_main2);
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if(status!= TextToSpeech.ERROR)
                    t1.setLanguage(Locale.UK);
            }
        });

    }
    public void onclickbt1(View View)
    {
        inputString=inputString+".";

    }
    public void onclickbt2(View view)
    {
        inputString=inputString+"_";
    }
    public void onclickbt3(View view)
    {
        inputString=inputString+"/";
    }
    public void onclickbt4(View view)
    {
        inputString=inputString+"/,/";
    }

    public void mousecodeTotext(View view)
    {
        int i;
        String word="";

        String s[]=inputString.split("/");// / is the character delimeter
        for(i=0;i<s.length;i++)
        {

            word=word+""+find(s[i]);
        }
        TextView tv=(TextView) findViewById(R.id.textView);
        tv.setText(word);

        Toast.makeText(getApplicationContext(), word,Toast.LENGTH_SHORT).show();
        t1.speak(word,TextToSpeech.QUEUE_FLUSH,null);

        //  tv.setText(inputString);
        inputString="";

    }

    private String find(String s)
    {
        int i=0,total=ar.length;
        if(s.equals(","))
            return " ";
        else
        {
            for (i = 0; i < total; i++) {

                if (s.equals(ar[i][1]))
                    return ar[i][0];
            }
        }
        return "";
    }
}
