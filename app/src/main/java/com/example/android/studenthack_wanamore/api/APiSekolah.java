package com.example.android.studenthack_wanamore.api;

import android.graphics.PorterDuff;
import android.util.Log;

import com.example.android.studenthack_wanamore.Const;
import com.example.android.studenthack_wanamore.interfaces.ISekolah;
import com.example.android.studenthack_wanamore.model.ModelOrtu;
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

        myRef.child(Const.nodesekolah).child(sekolah.getEmail().replace(".",",")).setValue(sekolah);
        myRef.child(Const.nodeuser).child(sekolah.getEmail().replace(".",",")).setValue(sekolah);
        myRef.child(Const.nodeuser).child(sekolah.getEmail().replace(".",",")).child("jenis").setValue("5");
        myRef.child(Const.nodesekolah_kelas).child(sekolah.getEmail().replace(".",","));
        myRef.child(Const.nodesekolah_guru).child(sekolah.getEmail().replace(".",","));
    }

    public static void getSekolah(final ISekolah isekolah, final String namasekolah) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        //final ModelSekolah[] model = new ModelSekolah[1];

        myRef.child(Const.nodesekolah).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ModelSekolah model = new ModelSekolah();
                for (DataSnapshot ms: dataSnapshot.getChildren()) {
                    if (ms.child("nama").getValue() == namasekolah) {
                        model = dataSnapshot.getValue(ModelSekolah.class);
                        break;
                    }
                }
                /*if (model[0] != null) Log.i("Nama: ", model[0].getNama());
                else Log.i("Pesan: ", "Kosong coy");*/
                isekolah.BerhasilDapetModel(model);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                isekolah.GagalDapetModel(databaseError.toString());
            }
        });
    }
}
