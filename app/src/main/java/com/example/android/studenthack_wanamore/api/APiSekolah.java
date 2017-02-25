package com.example.android.studenthack_wanamore.api;

import com.example.android.studenthack_wanamore.model.ModelSekolah;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Naufal Farras on 24/02/2017.
 */

public class APiSekolah {
    public static void registrasi(ModelSekolah sekolah) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();


    }
}
