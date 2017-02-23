package com.example.android.studenthack_wanamore;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.android.studenthack_wanamore.Adapter.AdapterBerandaGuru;
import com.example.android.studenthack_wanamore.model.ModelBerandaGuru;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BerandaGuruActivity extends AppCompatActivity {

    RecyclerView listberanda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda_guru);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listberanda = (RecyclerView) findViewById(R.id.listberanda);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        ModelBerandaGuru berandaguru = new ModelBerandaGuru("Ryan Baskara1","","18 menit yang lalu","Duch, kw capeh bangetz","#curhat","");
        ModelBerandaGuru berandaguru1 = new ModelBerandaGuru("Ryan Baskara2","","18 menit yang lalu","Duch, kw capeh bangetz","#curhat","");
        ModelBerandaGuru berandaguru2 = new ModelBerandaGuru("Ryan Baskara3","","18 menit yang lalu","Duch, kw capeh bangetz","#curhat","");
        ModelBerandaGuru berandaguru3 = new ModelBerandaGuru("Ryan Baskara4","","18 menit yang lalu","Duch, kw capeh bangetz","#curhat","");
        List<ModelBerandaGuru> berandagurulist = new ArrayList<>();
        berandagurulist.add(berandaguru);
        berandagurulist.add(berandaguru1);
        berandagurulist.add(berandaguru2);
        berandagurulist.add(berandaguru3);

        listberanda.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        AdapterBerandaGuru adapterBerandaGuru;
        adapterBerandaGuru = new AdapterBerandaGuru(this,berandagurulist);
        listberanda.setAdapter(adapterBerandaGuru);




    }

}
