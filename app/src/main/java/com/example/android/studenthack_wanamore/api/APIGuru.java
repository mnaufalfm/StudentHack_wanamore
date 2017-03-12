package com.example.android.studenthack_wanamore.api;

import android.util.Log;

import com.example.android.studenthack_wanamore.Const;
import com.example.android.studenthack_wanamore.interfaces.IGuru;
import com.example.android.studenthack_wanamore.model.ModelGuru;
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

public class APIGuru{
    public static void registrasi(ModelGuru modelguru, String idsekolah) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child(Const.nodeguru).child(modelguru.getEmail().replace(".",",")).setValue(modelguru);
        myRef.child(Const.nodeuser).child(modelguru.getEmail().replace(".",",")).setValue(modelguru);
        myRef.child(Const.nodeuser).child(modelguru.getEmail().replace(".",",")).child("jenis").setValue("guru");
        myRef.child(Const.nodesekolah_guru).child(idsekolah).child(modelguru.getEmail().replace(".",",")).setValue(modelguru);
    }

    public static void getGuru(final IGuru igulu, final String idguru) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        Log.i("Tes",idguru);
        myRef.child(Const.nodeguru).child(idguru).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                igulu.getGuruSuccess(dataSnapshot.getValue(ModelGuru.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                igulu.getGuruFailed("Data Tidak Ditemukan");
            }
        });
    }

    public static void beGuruAsWalas(String idguru, String idkelas) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child(Const.nodeguru).child(idguru).child("idkelas").setValue(idkelas);
    }

    public static void deleteGuru(String idguru, String idekolah) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child(Const.nodeguru).child(idguru).removeValue();
        myRef.child(Const.nodesekolah_guru).child(idekolah).child(idguru).removeValue();
    }

    public static void editGuru(ModelGuru guru, String idsekolah) {
        registrasi(guru, idsekolah);
    }

    public static void getListGuruOnSchool(final IGuru igulu, final String idsekolah) {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        final List<ModelGuru> listGuru = new ArrayList<ModelGuru>();
        myRef.child(Const.nodesekolah_guru).child(idsekolah).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot gg: dataSnapshot.getChildren()) {
                    listGuru.add(gg.getValue(ModelGuru.class));
                }
                igulu.getListGuruSuccess(listGuru);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                igulu.getListGuruFailed("Data Tidak Ditemukan. " + databaseError);
            }
        });
    }
}
