package com.example.android.studenthack_wanamore.api;

import com.example.android.studenthack_wanamore.Const;
import com.example.android.studenthack_wanamore.interfaces.IKomen;
import com.example.android.studenthack_wanamore.model.ModelComment;
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

public class APIKomen {
    public static void tambahKomen(final ModelComment komen) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();
        final String[] idkomen = new String[1];

        myRef.child(Const.nodekomen).push().setValue(komen, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseReference!=null) {
                    idkomen[0] = databaseReference.getKey();
                    myRef.child(Const.nodekomen).child(idkomen[0]).child("idkomen").setValue(idkomen[0]);
                    myRef.child(Const.nodepos_komen).child(komen.getIdpost()).child(idkomen[0]).setValue(komen);
                }
            }
        });
    }

    public static void getListAllKomen(final IKomen ikomen, String idpost) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();
        final List<ModelComment> listkomen = new ArrayList<ModelComment>();

        myRef.child(Const.nodepos_komen).child(idpost).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    listkomen.add(ds.getValue(ModelComment.class));
                }
                ikomen.getListAllKomenSuccess(listkomen);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
