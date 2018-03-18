package com.natalia.lab2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textview;
    RadioGroup rgroup;
    RadioButton rbut1;
    RadioButton rbut2;
    RadioButton rbut3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioGroup rgroup =  (RadioGroup) findViewById(R.id.rgroup);
        textview = (TextView) findViewById(R.id.textView);

        rgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                RadioButton rbutton = (RadioButton) rgroup.findViewById(i);

                switch (i) {
                    case (R.id.rbut1):
                        Intent intent = new Intent( MainActivity.this,  ActivityTwo.class);
                        startActivity(intent);
                        break;
                    case (R.id.rbut3):
                        Intent intent2 = new Intent( MainActivity.this,  ActivityThree.class);
                        startActivity(intent2);
                        break;
                    case (R.id.rbut2):
                        Intent intent3 = new Intent( MainActivity.this,  ActivityFour.class);
                        startActivity(intent3);
                        break;
                    case (R.id.rbut4):
                        Intent intent4 = new Intent( MainActivity.this,  ActivitySix.class);
                        startActivity(intent4);
                        break;
                }
            }
        });
    }
}
