package com.example.android.studenthack_wanamore.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.studenthack_wanamore.R;
import com.example.android.studenthack_wanamore.model.ModelBerandaGuru;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Muhammad Mukhibillah on 23/02/2017.
 */

public class AdapterBerandaGuru extends RecyclerView.Adapter<AdapterBerandaGuru.ViewHolder> {

    private Context context;
    private List<ModelBerandaGuru> berandamodel;

    public AdapterBerandaGuru(Context context, List<ModelBerandaGuru> berandamodel) {
        this.context = context;
        this.berandamodel = berandamodel;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_beranda_guru, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ModelBerandaGuru modelguru = berandamodel.get(position);
        holder.namaBeranda.setText(modelguru.getNama());
        holder.textBeranda.setText(modelguru.getCaption());
        holder.hastagBeranda.setText(modelguru.getHastag());

    }

    @Override
    public int getItemCount() {
        return berandamodel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView fotoBerandaGuru;
        TextView namaBeranda;
        TextView textBeranda;
        ImageView gambarBeranda;
        TextView hastagBeranda;
        ImageView love;
        public ViewHolder(View itemView) {
            super(itemView);
            fotoBerandaGuru = (CircleImageView) itemView.findViewById(R.id.foto_beranda_guru);
            namaBeranda = (TextView) itemView.findViewById(R.id.nama_beranda);
            textBeranda = (TextView) itemView.findViewById(R.id.text_beranda);
            gambarBeranda = (ImageView) itemView.findViewById(R.id.gambar_beranda);
            hastagBeranda = (TextView) itemView.findViewById(R.id.hastag_beranda);
            love = (ImageView) itemView.findViewById(R.id.love);

        }
    }
}
