package com.example.uts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class rekening extends AppCompatActivity {
    private TextView rekening,harga;
    private ImageView imageView;
    Button upload,send,back;
    int SELECT_IMAGE_CODE =1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rekening);

        rekening = findViewById(R.id.rek_va);
        harga = findViewById(R.id.rek_harga);
        imageView = findViewById(R.id.upload_img);
        upload = findViewById(R.id.upload_rek);
        send = findViewById(R.id.bukti_rek);
        back = findViewById(R.id.back);

//        Intent intent = getIntent();
//        String Rekening = intent.getExtras().getString("rekenng");
//        String Harga = intent.getExtras().getString("harga");
//        int image = intent.getExtras().getInt("gambar");
//
//        rekening.setText(Rekening);
//        harga.setText(Harga);
//        imageView.setImageResource(image);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i,"Title"),SELECT_IMAGE_CODE);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        final LoadingDialog loadingDialog=new LoadingDialog(rekening.this);
        final AccDialog accDialog=new AccDialog(rekening.this);
//        harga.setText(getIntent().getStringExtra("jumlah"));
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingDialog.startLoadingDialog();
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadingDialog.dismiss();
                        rekening.this.runOnUiThread(new Runnable() {
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode ==1){
            Uri uri = data.getData();
            imageView.setImageURI(uri);

        }
    }
}
