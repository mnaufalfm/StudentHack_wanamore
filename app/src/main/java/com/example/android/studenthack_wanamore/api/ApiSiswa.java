package com.example.android.studenthack_wanamore.api;

import android.content.Context;
import android.util.Log;

import com.example.android.studenthack_wanamore.Const;
import com.example.android.studenthack_wanamore.Main2Activity;
import com.example.android.studenthack_wanamore.interfaces.ISiswa;
import com.example.android.studenthack_wanamore.model.ModelSiswa;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kirra on 18/02/17.
 */

public class ApiSiswa {

    public static void registrasi(ModelSiswa modelSiswa){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child(Const.nodesiswa).child(modelSiswa.getEmail().replace(".",",")).setValue(modelSiswa);
        myRef.child(Const.nodeuser).child(modelSiswa.getEmail().replace(".",",")).setValue(modelSiswa);
        myRef.child(Const.nodeuser).child(modelSiswa.getEmail().replace(".",",")).child("jenis").setValue("siswa");
    }

    public static void getList(final ISiswa iSiswa) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        final List<ModelSiswa> listSiswa = new ArrayList<ModelSiswa>();

        myRef.child(Const.nodesiswa).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ms : dataSnapshot.getChildren()){
                    ModelSiswa a = ms.getValue(ModelSiswa.class);
                    listSiswa.add(a);
                }
                iSiswa.onSuccess(listSiswa);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                iSiswa.onFailed(databaseError.getMessage());
            }
        });
    }
}
