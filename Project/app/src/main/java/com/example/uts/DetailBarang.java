package com.example.uts;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import java.util.List;

public class DetailBarang extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    private TextView judul,deskrispi,harga,harga1,sumquantity;
    private ImageView imageView;
    ImageButton plus,minus;
    Button back,share,cart,chat,addCart;
    int quantity;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues = false;
    private List<Barang> listBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_barang);

        judul = (TextView) findViewById(R.id.judul_detail);
        deskrispi = (TextView) findViewById(R.id.desc_detail);
        harga = (TextView) findViewById(R.id.harga_detail);
        imageView = (ImageView) findViewById(R.id.image_detail);
        back = (Button) findViewById(R.id.back);
        share = (Button) findViewById(R.id.share);
        cart = (Button) findViewById(R.id.troli);
        addCart = findViewById(R.id.cart_button);
        chat = findViewById(R.id.chat);
        plus = findViewById(R.id.add_button);
        minus = findViewById(R.id.rmv_button);
        sumquantity = findViewById(R.id.edit_qty);
        harga1 = (TextView) findViewById(R.id.totalHarga);




        // Recieve data
        Intent intent = getIntent();
        String Judul = intent.getExtras().getString("judul");
        String Deskripsi = intent.getExtras().getString("deskripsi");
        String Harga = intent.getExtras().getString("harga");
        int image = intent.getExtras().getInt("gambar") ;

        // Setting values

        judul.setText(Judul);
        deskrispi.setText(Deskripsi);
        harga.setText(Harga);
        imageView.setImageResource(image);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailBarang.this, "Sukses Menambah Barang", Toast.LENGTH_SHORT).show();
                Intent cart = new Intent(DetailBarang.this,rekening.class);
                startActivity(cart);
//                SaveCart();
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(DetailBarang.this,cartActivity.class);
                startActivity(c);

            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                displayQuantity();
                int hargaAwal = 250000;
                int total = hargaAwal * quantity;
                String setnewPrice = String.valueOf(total);
                harga1.setText("Rp "+setnewPrice);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // because we dont want the quantity go less than 0
                if (quantity == 1) {
                    Toast.makeText(DetailBarang.this, "Minimal Pembelian adalah 1", Toast.LENGTH_SHORT).show();
                } else {
                    quantity--;
                    displayQuantity();
                    int hargaAwal = 250000;
                    int total = hargaAwal * quantity;
                    String setnewPrice = String.valueOf(total);
                    harga1.setText("Rp "+setnewPrice);

                }
            }
        });

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no = String.format("smsto:085640935787");
                String chat = "Halo kak,Saya ada pertanyaan/bantuan";
                Intent sms = new Intent(Intent.ACTION_SENDTO);
                sms.setData(Uri.parse(no));
                sms.putExtra("sms_body", chat);
                if (sms.resolveActivity(getPackageManager()) != null) {
                    startActivity(sms);
                }
            }
        });
    }

//    private boolean SaveCart() {
//
//        // getting the values from our views
//        String Judul = judul.getText().toString();
//        String Harga = harga1.getText().toString();
//        String Quantity = sumquantity.getText().toString();
//        int Gambar = imageView.getImageAlpha();
//
//        ContentValues values = new ContentValues();
//        values.put(OrderContract.OrderEntry.COLUMN_NAME, Judul);
//        values.put(OrderContract.OrderEntry.COLUMN_PRICE, Harga);
//        values.put(OrderContract.OrderEntry.COLUMN_QUANTITY, Quantity);
//        values.put(OrderContract.OrderEntry.COLUMN_PICTURE, Gambar);
//
//        if (mCurrentCartUri == null) {
//            Uri newUri = getContentResolver().insert(OrderContract.OrderEntry.CONTENT_URI, values);
//            if (newUri==null) {
//                Toast.makeText(this, "Failed to add to Cart", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "Success  adding to Cart", Toast.LENGTH_SHORT).show();
//
//            }
//        }
//        hasAllRequiredValues = true;
//        return hasAllRequiredValues;
//
//    }

    private void displayQuantity() {
            sumquantity.setText(String.valueOf(quantity));

    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_PICTURE,
                OrderContract.OrderEntry.COLUMN_QUANTITY,
        };

        return new CursorLoader(this, mCurrentCartUri,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {
        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        if (cursor.moveToFirst()) {

            int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
            int price = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
            int quantity = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);
            int image = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PICTURE);


            String namaJudul = cursor.getString(name);
            String hargaBarang = cursor.getString(price);
            String jmlBarang = cursor.getString(quantity);
//            int image = cursor.getString(image);


            judul.setText(namaJudul);
            harga.setText(hargaBarang);
            sumquantity.setText(jmlBarang);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        judul.setText("");
        harga.setText("");
        sumquantity.setText("");
    }
}
