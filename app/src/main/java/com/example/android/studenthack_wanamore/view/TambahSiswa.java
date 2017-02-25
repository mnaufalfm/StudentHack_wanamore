/*package com.example.android.studenthack_wanamore.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.android.studenthack_wanamore.R;
import com.example.android.studenthack_wanamore.api.ApiSiswa;
import com.example.android.studenthack_wanamore.model.ModelSiswa;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TambahSiswa extends AppCompatActivity {

    private Toolbar toolbar;
    private Button tambahsiswaBtn;
    private RadioButton radioSexButton;
    private Button btnDisplay;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("siswa");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_siswa);
        final EditText namaLengkap,nomorInduk,kelasSiswa,emailSiswa,emailOrtu,nomorHP,password;
        final RadioGroup jenisKelamin;


        namaLengkap = (EditText) findViewById(R.id.full_name);
        nomorInduk = (EditText) findViewById(R.id.nomor_induk_siswa);
        kelasSiswa = (EditText) findViewById(R.id.kelas_siswa);
        jenisKelamin=(RadioGroup)findViewById(R.id.radioGroup);
        btnDisplay=(Button)findViewById(R.id.button);
        emailSiswa = (EditText) findViewById(R.id.email_siswa);
        emailOrtu = (EditText) findViewById(R.id.email_orangtua);
        nomorHP = (EditText) findViewById(R.id.nomor_hp_siswa);
        password = (EditText) findViewById(R.id.create_password);


        tambahsiswaBtn = (Button) findViewById(R.id.btn_tambahsiswa);
        tambahsiswaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId=jenisKelamin.getCheckedRadioButtonId();
                radioSexButton=(RadioButton)findViewById(selectedId);
                ModelSiswa siswa = new ModelSiswa(namaLengkap.getText().toString(), nomorInduk.getText().toString(), radioSexButton.getText().toString(),kelasSiswa.getText().toString(), password.getText().toString(),emailOrtu.getText().toString(),emailSiswa.getText().toString(),nomorHP.getText().toString());
                ApiSiswa.registrasi(siswa);
            }
        });

        toolbar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Tambah Siswa");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
}*/