package com.example.android.studenthack_wanamore.interfaces;

import com.example.android.studenthack_wanamore.model.ModelSiswa;

import java.util.List;

/**
 * Created by kirra on 18/02/17.
 */

public interface ISiswa {
    void getListSuccess(List<ModelSiswa> siswa);
    void getListFailed(String error);

    void getListAllSuccess(List<ModelSiswa> siswa);
    void getListAllFailed(String pesan);
}
