package com.natalia.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;


import org.w3c.dom.Text;

public class ActivityFive extends ActivityThree {

    TextView text1;
    TextView text2, text3;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        Intent intent = getIntent();
        int time;

        text1 = (TextView) findViewById(R.id.Text);
        text2 = (TextView) findViewById(R.id.Text2);
        text3 = (TextView) findViewById(R.id.Text3);
        button2 = (Button) findViewById(R.id.button2);
        button1 = (Button) findViewById(R.id.button1);

        final int[] array = intent.getIntArrayExtra("array");
        final int[] arraycopy = intent.getIntArrayExtra("arraycopy");
        String time1 = intent.getStringExtra("time");


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res1 = "";
                for (int i=0;i<arraycopy.length;i++)
                {
                    res1+= String.valueOf(arraycopy[i])+" ";
                }
                text1.setText(res1);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = "";
                for (int i=0;i<array.length;i++)
                {
                    res+= String.valueOf(array[i])+" ";
                }
                text3.setText(res);
            }
        });

        text2.setText(time1);
    }
}