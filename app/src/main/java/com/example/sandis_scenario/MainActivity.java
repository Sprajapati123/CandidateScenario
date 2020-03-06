package com.example.sandis_scenario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView val1,val2,val3,val4,val5;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val1=findViewById(R.id.value1);
        val2=findViewById(R.id.value2);
        val3=findViewById(R.id.value3);
        val4=findViewById(R.id.value4);
        val5=findViewById(R.id.value5);
        btn=findViewById(R.id.btnstart);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             int result1 = Integer.parseInt(val1.getText().toString())+1;
             int result2 = Integer.parseInt(val2.getText().toString())-1;
             int result3 = Integer.parseInt(val3.getText().toString())+2;
             int result4 = Integer.parseInt(val4.getText().toString())-2;
             int result5 = Integer.parseInt(val5.getText().toString())+3;


             val1.setText(Integer.toString(result1));
             val2.setText(Integer.toString(result2));
             val3.setText(Integer.toString(result3));
             val4.setText(Integer.toString(result4));
             val5.setText(Integer.toString(result5));

            }
        });


    }
}
