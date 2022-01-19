package com.example.uts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    SliderView slider;
    int[] images = {R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5};
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager layoutManager;
//    private List<Barang> listBarang= new ArrayList<>();
    private List<Barang> barang;

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

//        recyclerView = findViewById(R.id.recyclerView);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
//        retrieveData();

        barang = new ArrayList<>();
        barang.add(new Barang(getString(R.string.text1),getString(R.string.harga1),getString(R.string.desc1),R.drawable.p1));
        barang.add(new Barang(getString(R.string.text2),getString(R.string.harga2),getString(R.string.desc2),R.drawable.p2));
        barang.add(new Barang(getString(R.string.text3),getString(R.string.harga3),getString(R.string.desc3),R.drawable.p3));
        barang.add(new Barang(getString(R.string.text4),getString(R.string.harga4),getString(R.string.desc4),R.drawable.p4));
        barang.add(new Barang(getString(R.string.text5),getString(R.string.harga5),getString(R.string.desc5),R.drawable.p5));
        barang.add(new Barang(getString(R.string.text6),getString(R.string.harga6),getString(R.string.desc6),R.drawable.p6));
        barang.add(new Barang(getString(R.string.text1),getString(R.string.harga1),getString(R.string.desc1),R.drawable.p1));
        barang.add(new Barang(getString(R.string.text2),getString(R.string.harga2),getString(R.string.desc2),R.drawable.p2));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerAdapter myAdapter = new RecyclerAdapter(this,barang);
        myrv.setLayoutManager(new GridLayoutManager(this,2));
        myrv.setAdapter(myAdapter);
//        retrieveData();
    }

//    public void retrieveData(){
//        APIRequestData data = RetroServer.Retroconnect().create(APIRequestData.class);
//        Call<ResponseBarang> tampilData = data.apiBarang();
//        tampilData.enqueue(new Callback<ResponseBarang>() {
//            @Override
//            public void onResponse(Call<ResponseBarang> call, Response<ResponseBarang> response) {
//                int kode = response.body().getKode();
//                String pesan = response.body().getPesan();
//                Toast.makeText(MainActivity.this,"Kode : "+kode+" | Pesan : "+pesan,Toast.LENGTH_SHORT).show();
//
//                listBarang.add((Barang) response.body().getData());
//
//                adData = new RecyclerAdapter(MainActivity.this,listBarang);
//                recyclerView.setAdapter(adData);
//                adData.notifyDataSetChanged();
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBarang> call, Throwable t) {
//                Toast.makeText(MainActivity.this,"Periksa Koneksi Internet/Gagal Menghubungi Server",Toast.LENGTH_SHORT).show();
//            }
//        });
//    }



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