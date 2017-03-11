package com.example.android.studenthack_wanamore.interfaces;

import com.example.android.studenthack_wanamore.model.ModelKelas;

import java.util.List;

/**
 * Created by Naufal Farras on 09/03/2017.
 */

public interface IKelas {
    void getClassSuccess(ModelKelas kelas);
    void getClassFailed(String error);

    void getIdKelasSuccess(String idkelas);
    void getIdKelasFailed(String error);

    void getListKelasSuccess(List<ModelKelas> kelas);
    void getListKelasFailed(String pesan);
}
