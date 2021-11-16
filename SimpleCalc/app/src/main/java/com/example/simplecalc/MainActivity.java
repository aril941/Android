package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "CalculatorActivity";
    private EditText txtbil1;
    private EditText txtbil2;
    private TextView Hasil;
    private float nil1,nil2,hsl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtbil1=findViewById(R.id.input1);
        txtbil2=findViewById(R.id.input2);
        Hasil=findViewById(R.id.hasil);
    }
    public void tambah(View view) {
        try {
            nil1 = Float.parseFloat(txtbil1.getText().toString());
            nil2 = Float.parseFloat(txtbil2.getText().toString());
            hsl = nil1 + nil2;
            Hasil.setText(Float.toString(hsl));
        }
        catch(NumberFormatException e)
        {
            Log.d("Error","Error Format..."+e);
        }
    }
    public void bagi(View view) {
        try {
            nil1 = Float.parseFloat(txtbil1.getText().toString());
            nil2 = Float.parseFloat(txtbil2.getText().toString());
            hsl = nil1/nil2;
            Hasil.setText(Float.toString(hsl));
        }
        catch(NumberFormatException e)
        {
            Log.d("Error","Error Format..."+e);
        }
    }
    public void kurang(View view) {
        try {
            nil1 = Float.parseFloat(txtbil1.getText().toString());
            nil2 = Float.parseFloat(txtbil2.getText().toString());
            hsl = nil1 - nil2;
            Hasil.setText(Float.toString(hsl));
        }
        catch(NumberFormatException e)
        {
            Log.d("Error","Error Format..."+e);
        }
    }
    public void kali(View view) {
        try {
            nil1 = Float.parseFloat(txtbil1.getText().toString());
            nil2 = Float.parseFloat(txtbil2.getText().toString());
            hsl = nil1*nil2;
            Hasil.setText(Float.toString(hsl));
        }
        catch(NumberFormatException e)
        {
            Log.d("Error","Error Format..."+e);
        }
    }
    public void reset(View view){
        txtbil1.setText("");
        txtbil2.setText("");
        Hasil.setText("");
    }
}