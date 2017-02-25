package com.example.android.studenthack_wanamore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.android.studenthack_wanamore.api.APIGuru;
import com.example.android.studenthack_wanamore.api.APIOrtu;
import com.example.android.studenthack_wanamore.api.APiSekolah;
import com.example.android.studenthack_wanamore.api.ApiSiswa;
import com.example.android.studenthack_wanamore.interfaces.ISekolah;
import com.example.android.studenthack_wanamore.interfaces.ISiswa;
import com.example.android.studenthack_wanamore.model.ModelGuru;
import com.example.android.studenthack_wanamore.model.ModelOrtu;
import com.example.android.studenthack_wanamore.model.ModelSekolah;
import com.example.android.studenthack_wanamore.model.ModelSiswa;

import java.util.List;

public class Main2Activity extends AppCompatActivity implements ISekolah{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //ModelSiswa siswa = new ModelSiswa("William Hanugra","G64140070","L","123456","anggunsuliarahmi@gmail.com","williamhanugra@gmail.com","085710061170");

        //ApiSiswa.registrasi(siswa);

        //String[] siswa = {"sya@hh.com","bla@gua.com"};

        //ModelOrtu ortu = new ModelOrtu("Budi","budi@gmail.com","123456","0815111111111","Bekasi",siswa);
        //APIOrtu.registrasi(ortu);

        //ModelSekolah sekolah = new ModelSekolah("SDIT Bani Adam","admin@baniadam.sch.id","0213345679","Jauh pokoknya","baniadam.sch.id","123456");
        //APiSekolah.registrasi(sekolah);

        //ModelSekolah nama = APiSekolah.getSekolah("SDIT Bani Adam");
        //Log.i("Nama Sekolah= ",nama.getNama());

        //APiSekolah.getSekolah("SDIT Bani Adam");

        //String[] matpel = {"Matematika","Fisika","Kimia"};

        //ModelGuru guru = new ModelGuru("William","ganteng","G64140018","L",matpel,"085693326656","Gak punya rumah","anggunsuliarahmi@gmail.com","1 2 3","fefefdvdfe");

        //APIGuru.registrasi(guru);

        ApiSiswa.getList(this);

    }

    /*@Override
    public void onSuccess(List<ModelSiswa> modelSiswas) {
        Log.i("Data", "onCreate: "+ modelSiswas.size() +" "+ modelSiswas.get(0).getNama());
    }

    @Override
    public void onFailed(String error) {

    }*/
}
