package com.example.luasbangun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void tbl_persegi(View view){
        Intent a=new Intent(this,persegi.class);
        startActivity(a);
    }
    public void tbl_segitiga(View view){
        Intent a=new Intent(this,segitiga.class);
        startActivity(a);
    }
    public void tbl_lingkaran(View view){
        Intent a=new Intent(this,lingkaran.class);
        startActivity(a);
    }
    public void tbl_kubus(View view){
        Intent a=new Intent(this,kubus.class);
        startActivity(a);
    }
}