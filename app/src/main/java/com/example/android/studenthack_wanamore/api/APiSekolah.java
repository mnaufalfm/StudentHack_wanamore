package com.example.android.studenthack_wanamore.api;

import android.graphics.PorterDuff;
import android.util.Log;

import com.example.android.studenthack_wanamore.Const;
import com.example.android.studenthack_wanamore.model.ModelSekolah;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Naufal Farras on 24/02/2017.
 */

public class APiSekolah {
    public static void registrasi(ModelSekolah sekolah) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child(Const.nodesekolah).push().setValue(sekolah);
    }

    public static ModelSekolah getSekolah(String namasekolah) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        final ModelSekolah[] model = new ModelSekolah[1];

        myRef.child(Const.nodesekolah).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                model[0] = dataSnapshot.getValue(ModelSekolah.class);
                /*if (model[0] != null) Log.i("Nama: ", model[0].getNama());
                else Log.i("Pesan: ", "Kosong coy");*/
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("Pesan Error",databaseError.getMessage());
            }
        });
        return model[0];
    }
}
