package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private int hitung = 0;
    private TextView tampil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void toast(View view){
        Toast toast = Toast.makeText(this, "josssss gandos", Toast.LENGTH_LONG);
        toast.show();
    }
    public void count(View view){
        tampil=(TextView)findViewById(R.id.show_count);
        hitung++;
        if (tampil != null)
            tampil.setText(Integer.toString(hitung));

    }
}