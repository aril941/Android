package com.example.luasbangun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class segitiga extends AppCompatActivity {
    private EditText int_alas,int_tinggi,int_sisi;
    private TextView hasilLuas,hasilK;
    private float sisi,alas,tinggi,hsl_luas,hsl_Kel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga);
        int_alas=findViewById(R.id.input_alas);
        int_tinggi=findViewById(R.id.input_tinggi);
        int_sisi=findViewById(R.id.input_sisi);
        hasilLuas=findViewById(R.id.hasil_luas);
        hasilK=findViewById(R.id.hasil_keliling);
    }
    public void hitung_segitiga(View view){
        sisi=Float.parseFloat(int_sisi.getText().toString());
        alas=Float.parseFloat(int_alas.getText().toString());
        tinggi=Float.parseFloat(int_tinggi.getText().toString());
        hsl_luas=(alas*tinggi)/2;
        hsl_Kel=3*sisi;
        hasilLuas.setText(Float.toString(hsl_luas));
        hasilK.setText(Float.toString(hsl_Kel));
    }

    public void reset(View view){
        int_alas.setText("");
        int_tinggi.setText("");
        int_sisi.setText("");
        hasilLuas.setText("");
        hasilK.setText("");
    }
}