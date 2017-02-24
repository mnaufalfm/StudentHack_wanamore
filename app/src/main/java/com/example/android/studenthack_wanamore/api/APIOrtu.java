package com.example.android.studenthack_wanamore.api;

import com.example.android.studenthack_wanamore.Const;
import com.example.android.studenthack_wanamore.model.ModelOrtu;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Naufal Farras on 24/02/2017.
 */

public class APIOrtu {
    public static void registrasi(ModelOrtu ortu) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child(Const.nodeortu).child(ortu.getEmail().replace(".",",")).setValue(ortu);
        myRef.child(Const.nodeuser).child(ortu.getEmail().replace(".",",")).setValue(ortu);
        myRef.child(Const.nodeuser).child(ortu.getEmail().replace(".",",")).child("jenis").setValue("ortu");
    }
}
