package com.example.android.studenthack_wanamore.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.studenthack_wanamore.R;
import com.example.android.studenthack_wanamore.model.ModelSiswa;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by kambing on 25/02/2017.
 */

public class AdapterMasukKelas extends RecyclerView.Adapter<AdapterMasukKelas.ViewHolder> {

    private Context context;
    private List<ModelSiswa> berandamodel;

    public AdapterMasukKelas(Context context, List<ModelSiswa> berandamodel) {
        this.context = context;
        this.berandamodel = berandamodel;
    }


    @Override
    public AdapterMasukKelas.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AdapterMasukKelas.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_masuk_kelas, parent, false));
    }

    @Override
    public void onBindViewHolder(AdapterMasukKelas.ViewHolder holder, int position) {
        ModelSiswa modelSiswa = berandamodel.get(position);
        holder.namaSiswa.setText(modelSiswa.getNama());
//        holder.namaSiswa.setText(modelSiswa.getNama());

    }

    @Override
    public int getItemCount() {
        return berandamodel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView gambarSiswa;
        TextView namaSiswa;

        public ViewHolder(View itemView) {
            super(itemView);
            gambarSiswa = (CircleImageView) itemView.findViewById(R.id.foto_siswa);
            namaSiswa = (TextView) itemView.findViewById(R.id.nama_siswa);

        }
    }
}
