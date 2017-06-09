package com.developer.amien.sariroti;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.developer.amien.sariroti.data.retrofit.Laporan;

import java.util.List;

/**
 * Created by amien on 03/05/17.
 */

public class Report_adapter extends RecyclerView.Adapter<Report_adapter.ViewHolder> {
    Context a;
    private List<Laporan> items;
    public Report_adapter(List<Laporan> laporan, Context a) {
        this.a=a;
        this.items = laporan;
    }

    @Override
    public Report_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_report,parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final Report_adapter.ViewHolder holder, int position) {
        final Laporan model = items.get(position);
        final String Nama_tempat = model.getNama_lokasi();
        final String tanggal = model.getTanggal();
        holder.Nama_tempat.setText(model.getNama_lokasi());
        holder.tanggal.setText(model.getTanggal());
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), Laporan_detail.class);
                i.putExtra("id_laporan", model.getId_laporan());
                i.putExtra("foto_laporan", model.getFoto_laporan());
                i.putExtra("nama_karyawan", model.getNama_karyawan());
                i.putExtra("nama_lokasi", model.getNama_lokasi());
                i.putExtra("tanggal", model.getTanggal());
                i.putExtra("deskripsi", model.getDeskripsi());
                v.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardview;
        TextView Nama_tempat, tanggal;
        public ViewHolder(View itemView) {
            super(itemView);
            cardview = (CardView) itemView.findViewById(R.id.h_card);
            Nama_tempat = (TextView) itemView.findViewById(R.id.nama_tempat);
            tanggal = (TextView) itemView.findViewById(R.id.tanggal);
        }
    }
}
