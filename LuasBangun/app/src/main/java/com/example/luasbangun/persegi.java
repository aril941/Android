package com.example.luasbangun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class persegi extends AppCompatActivity {
    private EditText txtBil1;
    private TextView hasilS,hasilK;
    private float sisi,hasilsisi,hasilkel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi);
        txtBil1=findViewById(R.id.input);
        hasilS=findViewById(R.id.hasilSisi);
        hasilK=findViewById(R.id.hasilKeliling);

    }
    public void hitung_persegi(View view){
        sisi=Float.parseFloat(txtBil1.getText().toString());
        hasilsisi=sisi*sisi;
        hasilkel=4*sisi;
        hasilS.setText(Float.toString(hasilsisi));
        hasilK.setText(Float.toString(hasilkel));
    }
    public void reset(View view){
        txtBil1.setText("");
        hasilK.setText("");
        hasilS.setText("");
    }

}