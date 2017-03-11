package com.example.android.studenthack_wanamore.api;

import com.example.android.studenthack_wanamore.Const;
import com.example.android.studenthack_wanamore.interfaces.IPost;
import com.example.android.studenthack_wanamore.model.ModelPost;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Naufal Farras on 10/03/2017.
 */

public class APIPost {
    public static void tambahPost(ModelPost postt) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();
        final String[] idpos = new String[1];

        myRef.child(Const.nodepos).push().setValue(postt, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseReference!=null) {
                    idpos[0] = databaseReference.getKey();
                    myRef.child(Const.nodepos).child(idpos[0]).child("idpost").setValue(idpos[0]);
                    myRef.child(Const.nodepos_komen).child(idpos[0]);
                    myRef.child(Const.nodepos_like).child(idpos[0]);
                }
            }
        });
    }

    private static void getListAllPost(final IPost ipost) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        final List<ModelPost> listPost = new ArrayList<ModelPost> ();

        myRef.child(Const.nodepos).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    listPost.add(ds.getValue(ModelPost.class));
                }
                if (!listPost.isEmpty()) ipost.getListAllPostSuccess(listPost);
                else ipost.getListAllPostFailed("Data Tidak Ditemukan");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                ipost.getListAllPostFailed("Data Tidak Ditemukan");
            }
        });
    }

}
