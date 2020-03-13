package com.example.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tip_percent, tip_amount, total_amount;
    EditText bill_amount;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bill_amount = findViewById(R.id.editText1);
        seekBar = findViewById(R.id.seekBar);
        tip_percent = findViewById(R.id.textView4);
        tip_amount = findViewById(R.id.textView6);
        total_amount = findViewById(R.id.textView8);

        seekBar.setMax(100);
        seekBar.setProgress(30);

        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        int min = 30;
                        String s = String.valueOf(bill_amount.getText());
                        if(s.isEmpty())
                        {
                            Toast.makeText(getApplicationContext(),"ENTER BILL AMOUNT",Toast.LENGTH_SHORT).show();
                            seekBar.setProgress(min);
                            return;
                        }

                        int progressValue;

                        if( progress < min )
                        {
                            progressValue = min;
                        }else
                            progressValue = progress;

                        seekBar.setProgress(progressValue);
                        tip_percent.setText(""+ progressValue + "%");

                        float progressvalue_float = progressValue;
                        float bill_amount_float = Integer.parseInt(s);
                        float tip_amount_float = bill_amount_float * (float)(progressvalue_float/100);

                        String formatted1 = "$" + String.format("%.2f", tip_amount_float);
                        // Update the tip dollar amount. (bill amount * (slider’s value / 100))
                        tip_amount.setText("" + formatted1);
                        //(bill amount + tip amount)
                        float total_amount_float = bill_amount_float + tip_amount_float;
                        String formatted2 = "$" + String.format("%.2f", total_amount_float);
                        total_amount.setText("" + formatted2);



                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
    }
}
