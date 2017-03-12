package com.example.android.studenthack_wanamore.interfaces;

import com.example.android.studenthack_wanamore.model.ModelPost;

import java.util.List;

/**
 * Created by Naufal Farras on 10/03/2017.
 */

public interface IPost {
    void getListAllPostSuccess(List<ModelPost> pos);
    void getListAllPostFailed(String pesan);
}
