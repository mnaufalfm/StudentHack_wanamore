package com.example.android.studenthack_wanamore.api;

import com.example.android.studenthack_wanamore.Const;
import com.example.android.studenthack_wanamore.model.ModelKelas;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by kirra on 18/02/17.
 */

public class APIKelas {
    public static void tambahkelas(ModelKelas kelas) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child(Const.nodekelas).push().setValue(kelas);
    }
}
