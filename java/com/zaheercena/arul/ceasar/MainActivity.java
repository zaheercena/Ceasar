package com.zaheercena.arul.ceasar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import android.util.Log;
public class MainActivity extends AppCompatActivity {
    public  String s1;
    public String s2;
    char [] a1;
    public int k1;
    private EditText rawText;
    private EditText enKey;
    private Button mProcessButton;
    private EditText enYield;
    private static final String LOG_TAG=MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setup the UI.
        //Log.i(LOG_TAG, "onCreat Called");
        initializeUI();
    }

    private void initializeUI(){
        Log.i(LOG_TAG, "initialize Called");
        // Set the layout.
        setContentView(R.layout.activity_main);
        //Log.i(LOG_TAG, "setContentview Called");
        // Initialize the views.
        rawText = (EditText) findViewById(R.id.raw);
        enKey = (EditText) findViewById(R.id.key);
        mProcessButton = (Button) findViewById(R.id.button);
        //Log.i(LOG_TAG, "Locals Created");
    }
    public void encryept(View buttonPress){
        //Log.i(LOG_TAG, "encrypt Called");
        s1=rawText.getText().toString();
        String lower = s1.toLowerCase();
        int groupSize = s1.length();
        final String strValue = enKey.getText().toString();
        k1=Integer.valueOf(strValue);
        a1=new char[groupSize];
        //Log.v(LOG_TAG, "encrypt Called"+groupSize);
        //Log.v(LOG_TAG, "encrypt Called"+k1);
        //Log.v(LOG_TAG, "encrypt Called"+s1);
        for (int i=0;i<groupSize;i++)
        {
            a1[i]=lower.charAt(i);
           // Log.v(LOG_TAG, "encrypt Called"+a1[i]);
        }
        /*for (char letter : s1.toCharArray()) {
            System.out.println(letter);
        }*/
        for(int j=0;j<groupSize;j++)
        {
            //Log.i(LOG_TAG, "encrypt Called");
            char c1=a1[j];
            //Log.v(LOG_TAG, "encrypt Called"+c1);
            if(c1!=32){
            for(int m=0;m<k1;m++)
            {
                c1++;
                if(c1>122)
                    {
                        for(int c=26;c>0;c--)
                        {
                            c1--;
                        }
                    }
           //     Log.v(LOG_TAG, "encrypt Called"+c1);

            }}
            a1[j]=c1;
          //  Log.v(LOG_TAG, "Final Called"+a1[j]);
        }
        //Log.i(LOG_TAG, "Exit Called");
        s2=Arrays.toString(a1);
        //Log.v(LOG_TAG, "encrypt Called"+s2);
        enYield = (EditText) findViewById(R.id.yield);
       // enYield.setText("" + enYield.getText() + s2);
        enYield.setText(s2);
        //Log.i(LOG_TAG, "Yield Called");
    //    enYield.setText(s2);
        //addToEditText(a1);

    }
    /*private void addToEditText(String string) {
        rawText.setText("" + rawText.getText() + string);
    }*/
    /*public void addToEditText(Array arr ) {
        enYield.setText("" + enYield.getText() + arr);
    }*/
}
