package com.example.uts;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class cartActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    Button back,beli;
    public CartAdapter cartAdapter;
    public static  final int LOADER=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_list);
        back = findViewById(R.id.back);
        beli = findViewById(R.id.buy_cart);

    getLoaderManager().initLoader(LOADER, null, this);
    ListView listView = findViewById(R.id.listView);
    cartAdapter = new CartAdapter(this, null);
    listView.setAdapter(cartAdapter);

    back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    });

    beli.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent b = new Intent(cartActivity.this,checkout.class);
            startActivity(b);
        }
    });



    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY,
                OrderContract.OrderEntry.COLUMN_PICTURE,
        };

        return new CursorLoader(this, OrderContract.OrderEntry.CONTENT_URI,projection,null,null,null);

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        cartAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        cartAdapter.swapCursor(null);
    }



//    public void totalBayar(View   view){
//        Integer harga =
//        Intent t = new Intent(cartActivity.this,rekening.class);
//        t.putExtra("jumlah",harga.ToString())
//    }
}

