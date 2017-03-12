package com.example.android.studenthack_wanamore.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.studenthack_wanamore.R;
import com.example.android.studenthack_wanamore.model.ModelBerandaGuru;
import com.example.android.studenthack_wanamore.model.ModelPost;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Muhammad Mukhibillah on 11/03/2017.
 */

public class AdapterBeranda extends RecyclerView.Adapter<AdapterBeranda.ViewHolder> {
    private Context context;
    private List<ModelPost> berandamodel;

    public AdapterBeranda(Context context, List<ModelPost> berandamodel) {
        this.context = context;
        this.berandamodel = berandamodel;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_beranda_guru, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ModelPost modelguru = berandamodel.get(position);
        holder.namaBeranda.setText(modelguru.getIdpengirim());
        holder.textBeranda.setText(modelguru.getPost());
        holder.tanggal.setText(String.valueOf(modelguru.getDate()));

    }

    @Override
    public int getItemCount() {
        return berandamodel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView fotoBerandaGuru;
        TextView namaBeranda;
        TextView textBeranda;
        TextView tanggal;


        public ViewHolder(View itemView) {
            super(itemView);
            tanggal = (TextView) itemView.findViewById(R.id.tanggal);
            fotoBerandaGuru = (CircleImageView) itemView.findViewById(R.id.foto_beranda_guru);
            namaBeranda = (TextView) itemView.findViewById(R.id.nama_beranda);
            textBeranda = (TextView) itemView.findViewById(R.id.text_beranda);

        }
    }
}
