package com.example.android.studenthack_wanamore.api;

import android.util.Log;

import com.example.android.studenthack_wanamore.Const;
import com.example.android.studenthack_wanamore.interfaces.IKelas;
import com.example.android.studenthack_wanamore.model.ModelGuru;
import com.example.android.studenthack_wanamore.model.ModelKelas;
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

public class APIKelas {
    public static void tambahkelas(final ModelKelas kelas, final String idsekolah) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();
        final String[] idkelas = new String[1];

        myRef.child(Const.nodekelas).push().setValue(kelas, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseReference != null) idkelas[0] = databaseReference.getKey();
                else Log.i("Pesan Gagal", databaseError.toString());

                Log.i("Bla",idkelas[0]);
                myRef.child(Const.nodekelas).child(idkelas[0]).child("idsekolah").setValue(idsekolah);
                myRef.child(Const.nodesekolah_kelas).child(idsekolah).child(idkelas[0]).setValue(kelas);
                myRef.child(Const.nodekelas_siswa).child(idkelas[0]);
            }
        });
    }

    /*public static void addKelasToSchool(final String namakelas, final String idsekolah) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();
        final String[] idkelas = new String[1];
        final ModelKelas[] modelkelas = new ModelKelas[1];

        myRef.child(Const.nodekelas).orderByChild("nama").equalTo(namakelas).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    if (ds.child("idsekolah").getValue().toString().equals(idsekolah)) {
                        idkelas[0] = ds.getKey().toString();
                        modelkelas[0] = ds.getValue(ModelKelas.class);
                        break;
                    }
                }
                myRef.child(Const.nodesekolah_kelas).child(idsekolah).child(idkelas[0]).setValue(modelkelas[0]);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }*/

    public static void getIdKelas(final IKelas ikelas, final String namakelas, final String idsekolah) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child(Const.nodesekolah_kelas).child(idsekolah).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String idkelas = new String();
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    if (ds.child("nama").getValue().toString().equals(namakelas)) {
                        idkelas = ds.getKey().toString();
                        break;
                    }
                }
                ikelas.getIdKelasSuccess(idkelas);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                ikelas.getIdKelasFailed("Data Tidak Ditemukan");
            }
        });
    }

    public static void getKelas(final IKelas ikelas, final String idkelas) {
        //Mengembalikan model kelas
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child(Const.nodekelas).child(idkelas).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ikelas.getClassSuccess(dataSnapshot.getValue(ModelKelas.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                ikelas.getClassFailed("Data Tidak Ditemukan");
            }
        });
    }

    public static void getKelas(final IKelas ikelas, final String namakelas, final String idsekolah) {
        //Mengembalikan model kelas
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child(Const.nodekelas).orderByChild("idsekolah").equalTo(idsekolah).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ModelKelas kel = new ModelKelas();
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    if (ds.child("nama").getValue().toString().equals(namakelas)) kel = ds.getValue(ModelKelas.class);
                    break;
                }
                ikelas.getClassSuccess(kel);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                ikelas.getClassFailed("Data Tidak Ditemukan");
            }
        });
    }

    public static void getListKelasOnSchool(final IKelas ikelas, final String idsekolah) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        final List<ModelKelas> listKelas = new ArrayList<ModelKelas>();

        myRef.child(Const.nodesekolah_kelas).child(idsekolah).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot gg: dataSnapshot.getChildren()) {
                    listKelas.add(gg.getValue(ModelKelas.class));
                }
                ikelas.getListKelasSuccess(listKelas);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                ikelas.getClassFailed("Data Tidak Ditemukan ("+databaseError.toString()+")");
            }
        });
    }

    public static void editKelas(ModelKelas kelas,String idkelas) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child(Const.nodekelas).child(idkelas).setValue(kelas);
        //myRef.child(Const.nodekelas).child(idkelas).child("idsekolah").setValue(kelas.getIdsekolah());
        myRef.child(Const.nodesekolah_kelas).child(kelas.getIdsekolah()).child(idkelas).setValue(kelas);
    }

    public static void hapusKelas(final String idkelas, String idsekolah) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        myRef.child(Const.nodekelas).child(idkelas).removeValue();
        myRef.child(Const.nodesekolah_kelas).child(idsekolah).child(idkelas).removeValue();
    }

}
