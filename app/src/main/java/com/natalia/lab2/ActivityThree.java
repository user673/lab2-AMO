package com.natalia.lab2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ActivityThree extends AppCompatActivity {

    TextView text2, text3,text4;
    EditText text1;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);


        text1 = (EditText) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num=0;

                String res = "";
                String res1="";
                try {
                    num = Integer.parseInt(text1.getText().toString());
                }
                catch (NumberFormatException e ){
                    error("Потрібно вводити числа ");

                }
                final int[] array = new int[num];
                int[] array1 = new int[num];
                for (int i = 0; i < array.length; i++) {
                    array[i] = ((int) (Math.random() * 3300));
                }


                if(num<=50){

                    for (int i=0;i<array.length;i++)
                    {
                        res1+= String.valueOf(array[i])+" ";
                    }

                    for (int i =0; i<array.length; i++){
                        array1[i]=array[i];
                    }
                    long t0 = System.nanoTime();
                    qsort sorter = new qsort();
                    sorter.quickSort(array,0,array.length-1);
                    long t1 = System.nanoTime();
                    long t = t1-t0;
                    for (int i=0;i<array.length;i++)
                    {
                        res+= String.valueOf(array[i])+" ";
                    }


                    if (1000000>t & t>1000) {
                        text2.setText("Час виконання"+String.valueOf(t/1000)+"мкc");
                    }
                    text3.setText(res1);
                    text4.setText(res);
                }



                if (num>50){
                    int[] arraycopy = Arrays.copyOf(array, array.length);
                    long t0 = System.nanoTime();
                    qsort sorter = new qsort();
                    sorter.quickSort(array,0,array.length-1);
                    long t1 = System.nanoTime();
                    long t = t1-t0;


                    String time = "";
                    if (t>1000000000){
                        time = ("Час виконання"+String.valueOf(t/1000000000)+"c");
                    }
                    if (1000000000>t & t>1000000){
                        time = ("Час виконання"+String.valueOf(t/1000000)+"мc");
                    }
                    if (1000000>t & t>1000) {
                        time = ("Час виконання"+String.valueOf(t/1000)+"мкc");
                    }

                    Intent intent = new Intent( ActivityThree.this,  ActivityFive.class);

                    intent.putExtra("time", time);
                    intent.putExtra("array", array);
                    intent.putExtra("arraycopy", arraycopy);
                    startActivity(intent);
                }

            }
        });


    }
    public void error(String text ){
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityThree.this);
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
