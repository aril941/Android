package com.example.uts;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class checkout extends AppCompatActivity {
    TextView kembalian;
    EditText tunai,total;
    Button proses,accBtn,back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout);
        total = findViewById(R.id.total_checkout);
        kembalian = findViewById(R.id.Tkembalian);
        tunai = findViewById(R.id.tunai);
        proses=findViewById(R.id.btnProses);
        accBtn=findViewById(R.id.btnAcc);
        back=findViewById(R.id.back);

        proses.setEnabled(false);
        proses.setClickable(false);


        TextWatcher textWatcher=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!total.getText().toString().equals("")&&!tunai.getText().toString().equals("")){
                    int tmp1=Integer.parseInt(total.getText().toString());
                    int tmp2=Integer.parseInt(tunai.getText().toString());
                    kembalian.setText(String.valueOf(tmp2 - tmp1));
                    if(tmp2<tmp1){
                        proses.setEnabled(false);
                        proses.setClickable(false);
                    }else if (tmp2==tmp1){
                        proses.setEnabled(true);
                        proses.setClickable(true);
                    }else if(tmp2>tmp1){
                        proses.setEnabled(true);
                        proses.setClickable(true);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        total.addTextChangedListener(textWatcher);
        tunai.addTextChangedListener(textWatcher);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MKembali=new Intent(checkout.this,MainActivity.class);
                startActivity(MKembali);
            }
        });

        final LoadingDialog loadingDialog=new LoadingDialog(checkout.this);
        final AccDialog accDialog=new AccDialog(checkout.this);
        total.setText(getIntent().getStringExtra("totalid"));
        proses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingDialog.startLoadingDialog();
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadingDialog.dismiss();
                        checkout.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                accDialog.startAcc();
                            }
                        });
                    }
                },4000);
            }
        });
    }

    public void payOK(View view) {
        Intent acc = new Intent(checkout.this,MainActivity.class);
        startActivity(acc);
    }
}
