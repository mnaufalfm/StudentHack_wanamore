package com.example.android.studenthack_wanamore.interfaces;

import com.example.android.studenthack_wanamore.model.ModelSiswa;

import java.util.List;

/**
 * Created by kirra on 18/02/17.
 */

public interface ISiswa {
    void onSuccess(List<ModelSiswa> modelSiswas);
    void onFailed(String error);
}
