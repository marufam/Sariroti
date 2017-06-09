package com.developer.amien.sariroti;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.developer.amien.sariroti.data.retrofit.Laporan;
import com.developer.amien.sariroti.data.retrofit.Penjualan;

import java.util.List;

/**
 * Created by amien on 31/05/17.
 */

public class Penjualan_adapter extends RecyclerView.Adapter<Penjualan_adapter.ViewHolder> {
    private List<Penjualan> items;
    Context a;
    public Penjualan_adapter(List<Penjualan> penjualans, Context a) {
        this.a=a;
        this.items = penjualans;
        Toast.makeText(a, "ini "+items.size(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public Penjualan_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_penjualan,parent, false);
        return new Penjualan_adapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final Penjualan_adapter.ViewHolder holder, int position) {
        final Penjualan model = items.get(position);
        final String Nama_tempat = model.getNama_roti();
        final String Jumlah = model.getJumlah_jual();
        holder.Nama_tempat.setText(model.getNama_roti());
        holder.Jumlah_roti.setText("Jumlah yang terjual = "+model.getJumlah_jual());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardview;
        TextView Nama_tempat, Jumlah_roti;
        public ViewHolder(View itemView) {
            super(itemView);
            cardview = (CardView) itemView.findViewById(R.id.penjualan_card);
            Nama_tempat = (TextView) itemView.findViewById(R.id.nama_tempat_roti);
            Jumlah_roti = (TextView) itemView.findViewById(R.id.jumlah_roti_terjual);
        }
    }
}
