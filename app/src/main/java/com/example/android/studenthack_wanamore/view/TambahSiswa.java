/*package com.example.android.studenthack_wanamore.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.android.studenthack_wanamore.R;
import com.example.android.studenthack_wanamore.api.ApiSiswa;
import com.example.android.studenthack_wanamore.model.ModelSiswa;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TambahSiswa extends AppCompatActivity {

    Toolbar toolbar;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("siswa");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_siswa);

        Log.d("haha","tesststs");
        ModelSiswa siswa= new ModelSiswa("william","g64140070","Laki-laki","789456","hahaa@gmail.com","william@gmail.com","082828282");
        ApiSiswa.registrasi(siswa);

        toolbar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Tambah Siswa");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
}*/