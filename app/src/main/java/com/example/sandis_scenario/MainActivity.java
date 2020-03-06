package com.example.sandis_scenario;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
// In this application Values are changed every 5 second till 2 minutes automatically once you clicked on start
public class MainActivity extends AppCompatActivity {

    private TextView val1, val2, val3, val4, val5, timer;
    private Button btn, btnreset;
    private CountDownTimer cTimer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val1 = findViewById(R.id.value1);
        val2 = findViewById(R.id.value2);
        val3 = findViewById(R.id.value3);
        val4 = findViewById(R.id.value4);
        val5 = findViewById(R.id.value5);
        timer = findViewById(R.id.timer);
        btn = findViewById(R.id.btnstart);
        btnreset = findViewById(R.id.btnreset);

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
                finish();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Handler handler = new Handler();
                final Runnable run = new Runnable() {
                    @Override
                    public void run() {
                        Log.i("Runnable has run!", "Repeats every sec");
                        //repeat this task devery 1s
                        handler.postDelayed(this, 5000);
                    }
                };
                handler.post(run);

                new CountDownTimer(120000, 5000) {

                    @Override
                    public void onTick(long millisUntilFinished) {
                        int result1 = Integer.parseInt(val1.getText().toString()) + 1;
                        int result2 = Integer.parseInt(val2.getText().toString()) - 1;
                        int result3 = Integer.parseInt(val3.getText().toString()) + 2;
                        int result4 = Integer.parseInt(val4.getText().toString()) - 2;
                        int result5 = Integer.parseInt(val5.getText().toString()) + 3;

                        val1.setText(Integer.toString(result1));
                        val2.setText(Integer.toString(result2));
                        val3.setText(Integer.toString(result3));
                        val4.setText(Integer.toString(result4));
                        val5.setText(Integer.toString(result5));

                        if ((result1 < 15 || result1 > 35) || (result2 < 15 || result2 > 35)
                                || (result3 < 15 || result3 > 35) || (result4 < 15 || result4 > 35) || (result5 < 15 || result5 > 35)
                        ) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setMessage("Value1: " + result1 + "\n" + "Value2: " + result2
                                    + "\n" + "Value3: " + result3 + "\n" + "Value4: " + result4
                                    + "\n" + "Value5: " + result5).setTitle("Alert")
                                    .setPositiveButton("Reset", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Intent intent = new Intent(MainActivity.this,MainActivity.class);
                                            startActivity(intent);
                                        }
                                    });
                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();
                        }

                    }

                    @Override
                    public void onFinish() {
                        //executed on finish
                        Log.i("Count down", "Finished");

                        // stopping an infinite runnable
                        handler.removeCallbacks(run);

                    }
                }.start();

                startStopTimer();
                btn.setEnabled(false);

            }

        });


    }

    private void startStopTimer() {
        cTimer = new CountDownTimer(120000, 1000) {
            @Override
            public void onTick(long l) {
                timer.setText("seconds remaining: " + l / 1000);
            }

            @Override
            public void onFinish() {
                timer.setText("Finish");


            }
        }.start();

    }


}
