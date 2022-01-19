package com.example.uts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PayAdapter extends RecyclerView.Adapter<PayAdapter.PayViewHolder>{

    private ArrayList<PayModel> payModelList;
    private Context context;

    public PayAdapter(ArrayList<PayModel> payModelList) {
        this.payModelList = payModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public PayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pay,parent,false);
        PayViewHolder holder = new PayViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PayViewHolder holder, int position) {
        PayModel payModel = payModelList.get(position);
        holder.nama.setText(payModel.getNama());
        holder.gambar.setImageResource(payModel.getGambar());
    }

    @Override
    public int getItemCount() {
        return payModelList.size();
    }

    public class PayViewHolder extends RecyclerView.ViewHolder {
        private TextView nama;
        private ImageView gambar;
        public PayViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, rekening.class);
                    i.putExtra("judul",payModelList.get(getAdapterPosition()).getNama());
                    i.putExtra("harga",payModelList.get(getAdapterPosition()).getGambar());
                    context.startActivity(i);
                }
            });
            nama= (itemView).findViewById(R.id.pay_nama);
            gambar = (itemView).findViewById(R.id.pay_gambar);
        }
    }
}
