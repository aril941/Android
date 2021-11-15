package com.example.uts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    SliderView slider;
    int[] images = {R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5};
    private View btn1, btn2, btn3, btn4, btn5, btn6;
    private int sumHarga,tambahHarga=0;
    public TextView total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slider=findViewById(R.id.slider);
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        slider.setSliderAdapter(sliderAdapter);
        slider.setIndicatorAnimation(IndicatorAnimationType.WORM);
        slider.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        slider.startAutoCycle();
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
                sumHarga=250000;
                tambahHarga+=sumHarga;
                total.setText("Total : Rp."+ tambahHarga);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumHarga=300000;
                tambahHarga+=sumHarga;;
                total.setText("Total : Rp."+ tambahHarga);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumHarga=350000;
                tambahHarga+=sumHarga;
                total.setText("Total : Rp."+ tambahHarga);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumHarga=380000;
                tambahHarga+=sumHarga;
                total.setText("Total : Rp."+ tambahHarga);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumHarga=600000;
                tambahHarga+=sumHarga;
                total.setText("Total : Rp."+ tambahHarga);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumHarga=250000;
                tambahHarga+=sumHarga;
                total.setText("Total : Rp."+ tambahHarga);
            }
        });

    }

    public void totalBayar(View view){
        Integer checkout=tambahHarga;
        Intent t=new Intent(MainActivity.this,checkout.class);
        t.putExtra("totalid",checkout.toString());
        startActivity(t);
    }
    public void reset(View view) {
        tambahHarga = 0;
        total.setText("Total : Rp."+Integer.toString(tambahHarga));
    }


    public void popup(View view){
        PopupMenu menu=new PopupMenu(this,view);
        menu.setOnMenuItemClickListener(this);
        menu.inflate(R.menu.menu_main);
        menu.show();
    }
    public void user(View v){
        PopupMenu menuUser=new PopupMenu(this,v);
        menuUser.setOnMenuItemClickListener(this);
        menuUser.inflate(R.menu.menu_user);
        menuUser.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.logout:
                Intent logout = new Intent(MainActivity.this, login.class);
                startActivity(logout);
                return true;
            case R.id.user_update:
                Intent user_u = new Intent(MainActivity.this, update.class);
                startActivity(user_u);
                return true;
            case R.id.cc:
                Intent cc = new Intent(Intent.ACTION_DIAL);
                cc.setData(Uri.parse("tel:085640935787"));
                startActivity(cc);
                return true;
            case R.id.sms:
                String no = String.format("smsto:085640935787");
                String chat = "Halo kak,Saya ada pertanyaan/bantuan";
                Intent sms = new Intent(Intent.ACTION_SENDTO);
                sms.setData(Uri.parse(no));
                sms.putExtra("sms_body", chat);
                if (sms.resolveActivity(getPackageManager()) != null) {
                    startActivity(sms);
                    return true;
                }
            case R.id.maps:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                String data = getString(R.string.lokasi);
                intent.setData(Uri.parse(data));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                    return true;
                }

            default:
                return false;
        }
    }
}