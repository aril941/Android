package com.example.appnilaippb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edTgs,edUTS,edUAS,edHasilTgs,edHasilUTS,edHasilUAS,edAkhir,edHuruf,edPredikat;
    private TextView nim,nama;
    private String predikat,huruf;
    private  float nTgs,nUTS,nUAS,nHasilTgs,nHasilUTS,nHasilUAS,nAkhir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nim=(TextView) findViewById(R.id.nim);
        nama=(TextView) findViewById(R.id.nama);
        edTgs=(EditText) findViewById(R.id.intTugas);
        edUTS=(EditText) findViewById(R.id.intUTS);
        edUAS=(EditText) findViewById(R.id.intUAS);
        edHasilTgs=(EditText) findViewById(R.id.hasilTugas);
        edHasilUAS=(EditText) findViewById(R.id.hasilUAS);
        edHasilUTS=(EditText) findViewById(R.id.hasilUTS);
        edAkhir=(EditText) findViewById(R.id.repAkhir);
        edHuruf=(EditText) findViewById(R.id.repHuruf);
        edPredikat=(EditText) findViewById(R.id.repPredikat);
        edTgs.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start,int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(edTgs.getText().toString().isEmpty())
                {
                    nTgs=0;
                }else {
                    nTgs =Float.parseFloat(edTgs.getText().toString());
                }
                nHasilTgs=0.3f*nTgs;
                edHasilTgs.setText(Float.toString(nHasilTgs));
            }
        });
        edUTS.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start,int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(edUTS.getText().toString().isEmpty())
                {
                    nUTS=0;
                }else {
                    nUTS =Float.parseFloat(edUTS.getText().toString());
                }
                nHasilUTS=0.35f*nUTS;
                edHasilUTS.setText(Float.toString(nHasilUTS));
            }
        });
        edUAS.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start,int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(edUAS.getText().toString().isEmpty())
                {
                    nUAS=0;
                }else {
                    nUAS =Float.parseFloat(edUAS.getText().toString());
                }
                nHasilUAS=0.35f*nUAS;
                edHasilUAS.setText(Float.toString(nHasilUAS));
            }
        });

    }
    public void hitungAkhir(){
        nAkhir=nHasilTgs+nHasilUTS+nHasilUAS;
    }
    public void hitung(View view) {
        hitungAkhir();
        edAkhir.setText(Float.toString(nAkhir));
        edHuruf.setText(getHuruf(nAkhir));
        edPredikat.setText(getPredikat(huruf));
    }
    public String getHuruf(float nilai) {
        if (nilai >= 85) {
            huruf = "A";
        }
        else if (nilai >= 80)
                huruf = "AB";
            else if (nilai >= 70)
                huruf = "B";
            else if (nilai >= 65)
                huruf = "BC";
            else if (nilai >= 60)
                huruf = "C";
            else if (nilai >= 50)
                huruf = "D";
            else
                huruf = "E";
            return huruf;
    }
    public String getPredikat(String huruf)
    {
        switch(huruf)
        {
            case "A":predikat="Apik";break;
            case "AB":predikat="Apik Baik";break;
            case "B":predikat="Baik";break;
            case "BC":predikat="Cukup Baik";break;
            case "C":predikat="Cukup";break;
            case "D":predikat="Dablek";break;
            default:predikat="Elek";
        }
        return predikat;
    }
    public void keluar(View view){
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }

}