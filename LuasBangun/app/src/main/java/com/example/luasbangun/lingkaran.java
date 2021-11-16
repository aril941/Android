package com.example.luasbangun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class lingkaran extends AppCompatActivity {
    private EditText txtbil1;
    private TextView hasilL,hasil_kel;
    private int int_jari;
    private double hsl_luas;
    private double hsl_kel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingkaran);
        txtbil1=findViewById(R.id.input_jari);
        hasilL=findViewById(R.id.luas_lingkaran);
        hasil_kel=findViewById(R.id.kel_lingkaran);
    }
    public void hitung_lingkaran(View view){
        int_jari=Integer.parseInt(txtbil1.getText().toString());
        double phi = 3.14;
        hsl_luas=phi*int_jari*int_jari;
        hsl_kel=2 * phi * int_jari;
        hasilL.setText(String.format("%.2f",hsl_luas));
        hasil_kel.setText(String.valueOf(hsl_kel));
    }

    public void reset(View view){
        txtbil1.setText("");
        hasilL.setText("");
        hasil_kel.setText("");
    }
}