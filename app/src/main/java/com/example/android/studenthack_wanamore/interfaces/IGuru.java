package com.example.android.studenthack_wanamore.interfaces;

import com.example.android.studenthack_wanamore.model.ModelGuru;

import java.util.List;

/**
 * Created by Naufal Farras on 09/03/2017.
 */

public interface IGuru {
    void getGuruSuccess(ModelGuru guru);
    void getGuruFailed(String pesan);

    void getListGuruSuccess(List<ModelGuru> guru);
    void getListGuruFailed(String pesan);
}
