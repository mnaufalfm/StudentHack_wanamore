package com.example.android.studenthack_wanamore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.android.studenthack_wanamore.api.APIGuru;
import com.example.android.studenthack_wanamore.api.ApiSiswa;
import com.example.android.studenthack_wanamore.interfaces.ISiswa;
import com.example.android.studenthack_wanamore.model.ModelGuru;
import com.example.android.studenthack_wanamore.model.ModelSiswa;

import java.util.List;

public class Main2Activity extends AppCompatActivity implements ISiswa{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //ModelSiswa siswa = new ModelSiswa("naufal","G64140091","L","123456","mnfm95@gmail.com","muhammadnaufalfm@gmail.com","085710061172");

        //ApiSiswa.registrasi(siswa);

        String[] matpel = {"Matematika","Fisika","Kimia"};

        ModelGuru guru = new ModelGuru("William","G64140018","LP",matpel,"085693326656","Gak punya rumah","anggunsuliarahmi@gmail.com");

        APIGuru.registrasi(guru);

//        ApiSiswa.getList(this);

    }

    @Override
    public void onSuccess(List<ModelSiswa> modelSiswas) {
        Log.i("Data", "onCreate: "+ modelSiswas.size() +" "+ modelSiswas.get(0).getNama());
    }

    @Override
    public void onFailed(String error) {

    }
}
