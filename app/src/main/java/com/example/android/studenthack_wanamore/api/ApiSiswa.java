package com.example.android.studenthack_wanamore.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ImageView;

import com.example.android.studenthack_wanamore.Const;
import com.example.android.studenthack_wanamore.Main2Activity;
import com.example.android.studenthack_wanamore.interfaces.ISiswa;
import com.example.android.studenthack_wanamore.model.ModelSiswa;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
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

    public static void editSiswa (ModelSiswa siswa) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        String idkelas = myRef.child(Const.nodesiswa).child(siswa.getEmail().replace(".",",")).child("kelas").toString();

        myRef.child(Const.nodekelas_siswa).child(idkelas).child(siswa.getEmail().replace(".",",")).setValue(siswa);
        myRef.child(Const.nodekelas_siswa).child(idkelas).child(siswa.getEmail().replace(".",",")).child("kelas").setValue(idkelas);
        myRef.child(Const.nodesiswa).child(siswa.getEmail().replace(".",",")).setValue(siswa);
        myRef.child(Const.nodeuser).child(siswa.getEmail().replace(".",",")).setValue(siswa);
        myRef.child(Const.nodesiswa).child(siswa.getEmail().replace(".",",")).child("kelas").setValue(idkelas);
        myRef.child(Const.nodeuser).child(siswa.getEmail().replace(".",",")).child("kelas").setValue(idkelas);
    }

    public static void addSiswaToClass(String idkelas, ModelSiswa modelSiswa) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child(Const.nodekelas_siswa).child(idkelas).child(modelSiswa.getEmail().replace(".",",")).setValue(modelSiswa);
        myRef.child(Const.nodekelas_siswa).child(idkelas).child(modelSiswa.getEmail().replace(".",",")).child("kelas").setValue(idkelas);
        myRef.child(Const.nodesiswa).child(modelSiswa.getEmail().replace(".",",")).child("kelas").setValue(idkelas);
        myRef.child(Const.nodeuser).child(modelSiswa.getEmail().replace(".",",")).child("kelas").setValue(idkelas);
    }


    public static void deleteSiswa(String idsiswa) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        String idkelas = myRef.child(Const.nodesiswa).child(idsiswa).child("kelas").toString();

        myRef.child(Const.nodekelas_siswa).child(idkelas).child(idsiswa).removeValue();
        myRef.child(Const.nodesiswa).child(idsiswa).child("kelas").removeValue();
        myRef.child(Const.nodeuser).child(idsiswa).removeValue();

    }

    public static void getListSiswaOnClass (final ISiswa isiswa, final String idkelas) {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        final List<ModelSiswa> listSiswa = new ArrayList<ModelSiswa>();
        myRef.child(Const.nodekelas_siswa).child(idkelas).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot gg: dataSnapshot.getChildren()) {
                    listSiswa.add(gg.getValue(ModelSiswa.class));
                }
                isiswa.getListSuccess(listSiswa);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                isiswa.getListFailed("Data Tidak Ditemukan. " + databaseError);
            }
        });
    }

    public static void getListAll(final ISiswa iSiswa) {
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
                iSiswa.getListAllSuccess(listSiswa);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                iSiswa.getListAllFailed(databaseError.getMessage());
            }
        });
    }

    /*@Override
    public void tambahsiswa(ModelSiswa siswa) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child(Const.nodesiswa).child(siswa.getEmail().replace(".",",")).setValue(siswa);
        myRef.child(Const.nodeuser).child(siswa.getEmail().replace(".",",")).setValue(siswa);
        myRef.child(Const.nodeuser).child(siswa.getEmail().replace(".",",")).child("jenis").setValue("siswa");
    }

    @Override
    public List<ModelSiswa> getListSiswa() {
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
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return listSiswa;
    }*/
}
