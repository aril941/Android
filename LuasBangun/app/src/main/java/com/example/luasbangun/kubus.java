package com.example.luasbangun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class kubus extends AppCompatActivity {
    private EditText txtBil1;
    private TextView hasilLuas,hasilV;
    private float sisiKbs,hasilLuas_kbs,hasilVol_kbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kubus);
        txtBil1=findViewById(R.id.input_kubus);
        hasilLuas=findViewById(R.id.hasil_luasKbs);
        hasilV=findViewById(R.id.hasil_VolKbs);
    }
    public void hitung_kubus(View view){
        sisiKbs=Float.parseFloat(txtBil1.getText().toString());
        hasilLuas_kbs=6*(sisiKbs*sisiKbs);
        hasilVol_kbs=sisiKbs*sisiKbs*sisiKbs;
        hasilLuas.setText(Float.toString(hasilLuas_kbs));
        hasilV.setText(Float.toString(hasilVol_kbs));
    }
    public void reset(View v){
        txtBil1.setText("");
        hasilLuas.setText("");
        hasilV.setText("");
    }

}