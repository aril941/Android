package com.example.uts;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class CartAdapter extends CursorAdapter {

    public CartAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView judul,harga,quantity,gambar;

        judul = view.findViewById(R.id.cart_nama);
        harga = view.findViewById(R.id.cart_harga);
        quantity = view.findViewById(R.id.qty_cart);
        gambar = view.findViewById(R.id.cart_harga);

        int nama = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
        int price = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
        int qty = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);
        int image = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PICTURE);

        String nm = cursor.getString(nama);
        String hrg = cursor.getString(price);
        String qts = cursor.getString(qty);
        String pic = cursor.getString(image);

        judul.setText(nm);
        harga.setText(hrg);
        gambar.setText(pic);
        quantity.setText(qts);

    }
}
