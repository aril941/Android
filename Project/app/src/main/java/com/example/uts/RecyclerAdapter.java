package com.example.uts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private Context context;
    private List<Barang> listBarang;

    public RecyclerAdapter(Context context, List<Barang> listBarang) {
        this.context = context;
        this.listBarang = listBarang;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        MyViewHolder holder = new MyViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Barang db= listBarang.get(position);

//        holder.id.setText(String.valueOf(db.getId()));
        holder.judul.setText(db.getJudul());
        holder.harga.setText(db.getHarga());
        holder.gambar.setImageResource(db.getGambar());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,DetailBarang.class);

                i.putExtra("judul",listBarang.get(position).getJudul());
                i.putExtra("harga",listBarang.get(position).getHarga());
                i.putExtra("deskripsi",listBarang.get(position).getDeskripsi());
                i.putExtra("gambar",listBarang.get(position).getGambar());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBarang.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{
//        TextView id;
        TextView judul;
        TextView harga;
        ImageView gambar;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            judul= itemView.findViewById(R.id.card_judul);
//            id= itemView.findViewById(R.id.id_produk);
            harga= itemView.findViewById(R.id.card_harga);
            gambar = itemView.findViewById(R.id.card_img);
            cardView = itemView.findViewById(R.id.cardview_id);


        }
    }
}
