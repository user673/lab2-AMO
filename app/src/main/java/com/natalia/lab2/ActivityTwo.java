package com.natalia.lab2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import  com.natalia.lab2.qsort;

import java.lang.reflect.Array;
import java.util.*;

public class ActivityTwo extends AppCompatActivity {

    EditText etext1;
    TextView text1, text2,text3;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        text1  = (TextView) findViewById(R.id.twotext1);
        text2  = (TextView) findViewById(R.id.twotext2);
        text3  = (TextView) findViewById(R.id.twotext3);

        etext1  = (EditText) findViewById(R.id.etext1);
        button1 = (Button) findViewById(R.id.twobutton1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = "";
                String str="";
                long  t = 0;

                try {
                    str = etext1.getText().toString();

                    String strArr[] = str.split(" ");

                    int numArr[] = new int[strArr.length];
                    for (int i = 0; i < strArr.length; i++) {
                        numArr[i] = Integer.parseInt(strArr[i]);}

                    long t0 = System.nanoTime();
                    qsort sorter = new qsort();
                    sorter.quickSort(numArr, 0, numArr.length-1);
                    long t1 = System.nanoTime();
                    t = t1-t0;
                    for (int i=0;i<numArr.length;i++)
                    {
                        res+= String.valueOf(numArr[i])+" ";
                        }
                    text2.setText(res);

                }
                catch (NumberFormatException e){
                    error("Потрібно вводити числа");

                }
                if (t>1000000000){
                    text3.setText(String.valueOf(t/1000000000)+"c");
                }
                if (1000000000>t & t>1000000){
                    text3.setText(String.valueOf(t/1000000)+"мc");
                }

                if (1000000>t & t>1000) {
                    text3.setText(String.valueOf(t/1000)+"мкc");
                }



            }
        });

    }
    public void error(String text ){
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityTwo.this);
        builder.setTitle("Помилка !")
                .setMessage(text)
                .setCancelable(false)
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
