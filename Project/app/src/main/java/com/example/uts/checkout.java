package com.example.uts;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class checkout extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout);

        recyclerView = findViewById(R.id.recyclerView);
        ArrayList<PayModel> payModels = new ArrayList<>();

        payModels.add(new PayModel(getString(R.string.bank1),R.drawable.b1));
        payModels.add(new PayModel(getString(R.string.bank2),R.drawable.b2));
        payModels.add(new PayModel(getString(R.string.bank3),R.drawable.b3));
        payModels.add(new PayModel(getString(R.string.bank4),R.drawable.b4));
        payModels.add(new PayModel(getString(R.string.bank5),R.drawable.b5));
        payModels.add(new PayModel(getString(R.string.bank6),R.drawable.b6));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PayAdapter(payModels));
    }
}
