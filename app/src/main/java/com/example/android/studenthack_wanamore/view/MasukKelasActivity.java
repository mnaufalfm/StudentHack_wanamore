package com.example.android.studenthack_wanamore.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.android.studenthack_wanamore.Adapter.AdapterMasukKelas;
import com.example.android.studenthack_wanamore.CreatePost;
import com.example.android.studenthack_wanamore.R;
import com.example.android.studenthack_wanamore.model.ModelSiswa;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class MasukKelasActivity extends AppCompatActivity {

    RecyclerView listmasukkelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk_kelas);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listmasukkelas = (RecyclerView) findViewById(R.id.listmasukkelas);

        //ModelSiswa(String nama, String noinduk, String jenis_kelamin, String kelas, String password, String email_ortu, String email, String notelp)
        ModelSiswa siswa = new ModelSiswa("William Hanugra","G64140070","L","12A","","","","");
        ModelSiswa siswa1 = new ModelSiswa("Dwi Yoga Wibawa","G64140108","L","12A","","","","");
        ModelSiswa siswa2 = new ModelSiswa("William Hanugra","G64140070","L","12A","","","","");
        ModelSiswa siswa3 = new ModelSiswa("William Hanugra","G64140070","L","12A","","","","");
        List<ModelSiswa> masukkelaslist = new ArrayList<>();
        masukkelaslist.add(siswa);
        masukkelaslist.add(siswa1);
        masukkelaslist.add(siswa2);
        masukkelaslist.add(siswa3);

        listmasukkelas.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        AdapterMasukKelas adapterMasukKelas;
        adapterMasukKelas = new AdapterMasukKelas(this,masukkelaslist);
        listmasukkelas.setAdapter(adapterMasukKelas);




    }

}
