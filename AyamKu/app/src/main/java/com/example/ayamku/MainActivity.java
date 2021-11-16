package com.example.ayamku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private View btn1, btn2, btn3, btn4, btn5, btn6;
    private TextView total;
    private int sumHarga,tambahHarga=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        total= findViewById(R.id.totalid);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumHarga=12000;
                tambahHarga+=sumHarga;
                total.setText("Total : Rp."+Integer.toString(tambahHarga));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumHarga=14000;
                tambahHarga+=sumHarga;;
                total.setText("Total : Rp."+Integer.toString(tambahHarga));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumHarga=13000;
                tambahHarga+=sumHarga;
                total.setText("Total : Rp."+Integer.toString(tambahHarga));
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumHarga=20000;
                tambahHarga+=sumHarga;
                total.setText("Total : Rp."+Integer.toString(tambahHarga));
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumHarga=3000;
                tambahHarga+=sumHarga;
                total.setText("Total : Rp."+Integer.toString(tambahHarga));
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumHarga=2000;
                tambahHarga+=sumHarga;
                total.setText("Total : Rp."+Integer.toString(tambahHarga));
            }
        });
    }
}