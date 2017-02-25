package com.example.android.studenthack_wanamore.api;

import com.example.android.studenthack_wanamore.Const;
import com.example.android.studenthack_wanamore.model.ModelGuru;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by kirra on 18/02/17.
 */

public class APIGuru {
    public static void registrasi(ModelGuru modelguru) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child(Const.nodeguru).child(modelguru.getEmail().replace(".",",")).setValue(modelguru);
        myRef.child(Const.nodeuser).child(modelguru.getEmail().replace(".",",")).setValue(modelguru);
        myRef.child(Const.nodeuser).child(modelguru.getEmail().replace(".",",")).child("jenis").setValue("guru");
    }
}
