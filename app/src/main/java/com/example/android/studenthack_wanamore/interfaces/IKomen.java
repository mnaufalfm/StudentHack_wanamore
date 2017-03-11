package com.example.android.studenthack_wanamore.interfaces;

import com.example.android.studenthack_wanamore.model.ModelComment;

import java.util.List;

/**
 * Created by Naufal Farras on 11/03/2017.
 */

public interface IKomen {
    void getListAllKomenSuccess(List<ModelComment> komen);
    void getListAllKomenFailed(String pesan);
}
