package com.lazymail.unitconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private double val_kph = 0;
    private double val_fpf = 0;
    private TextView editText_kph;
    private TextView editText_fpf;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Another Useless Unit Converter");
    }

    public void calc_kph (View view) {

        // copied from https://javawithumer.com/2019/07/get-value-edittext.html
        // I have no idea how this really works
        EditText e = (EditText) findViewById(R.id.editText_fpf);
        String temp = e.getText().toString();
        double value = 0;
        if (!"".equals(temp)) {
            val_fpf = Double.parseDouble(temp);
        }

        val_kph = val_fpf * 0.00297619 * 0.2011680;

        EditText e2 = (EditText) findViewById(R.id.editText_kph);
        String strDouble = "";
        if (val_fpf < 167) {
            strDouble = String.format(Locale.CANADA, "%.4f", val_kph);
        } else {
            strDouble = String.format(Locale.CANADA, "%.2f", val_kph);
        }
        e2.setText(strDouble);
        
        Toast.makeText(getApplicationContext(), "Calculation Complete", Toast.LENGTH_SHORT).show();
    }

    public void calc_fpf(View view) {

        // copied from https://javawithumer.com/2019/07/get-value-edittext.html
        // I have no idea how this really works.
        EditText e = (EditText) findViewById(R.id.editText_kph);
        String temp = e.getText().toString();
        double value = 0;
        if (!"".equals(temp)) {
            val_kph = Double.parseDouble(temp);
        }

        val_fpf = val_kph * 336 * 4.970969;

        EditText e2 = (EditText) findViewById(R.id.editText_fpf);
        String strDouble = String.format(Locale.CANADA,"%.1f", val_fpf);
        e2.setText(strDouble);
        
        Toast.makeText(getApplicationContext(), "Calculation Complete", Toast.LENGTH_SHORT).show();
    }
}
