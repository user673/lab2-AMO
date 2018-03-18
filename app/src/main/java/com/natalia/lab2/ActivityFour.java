package com.natalia.lab2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivityFour extends AppCompatActivity {

    TextView text1, text2, text3;
    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        String restxt = "";


        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        button1 = (Button) findViewById(R.id.button1);

        final  int[] arraytxt = new int[2000];
        for (int i = 0; i < arraytxt.length; i++) {
            arraytxt[i] = ((int)(Math.random() * 3300));
        }
        for (int i=0;i<arraytxt.length;i++)
        {
            restxt+= String.valueOf(arraytxt[i])+" ";
        }

        text1.setText(restxt);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res1txt = "";
                long t0 = System.nanoTime();
                qsort sorter = new qsort();
                sorter.quickSort(arraytxt, 0, arraytxt.length-1);
                long t1 = System.nanoTime();
                long t = t1-t0;
                for (int i=0;i<arraytxt.length;i++)
                {
                    res1txt+= String.valueOf(arraytxt[i])+" ";
                }

                text2.setText(res1txt);

                if (t>1000000000){
                    text3.setText("Час виконання"+String.valueOf(t/1000000000)+"c");
                }
                if (1000000000>t & t>1000000){
                    text3.setText("Час виконання"+String.valueOf(t/1000000)+"мc");
                }

                if (1000000>t & t>1000) {
                    text3.setText("Час виконання"+String.valueOf(t/1000)+"мкc");
                }


            }
        });


    }

}
