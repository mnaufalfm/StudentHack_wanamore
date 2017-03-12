package com.example.android.studenthack_wanamore.api;

import android.util.Log;

import com.example.android.studenthack_wanamore.Const;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;

/**
 * Created by Naufal Farras on 10/03/2017.
 */

public class Login {
    public static String[] loginToApp(String username, String password) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        String[] pesan = new String[0];

        if (myRef.child(Const.nodeuser).child(username) != null) {
            if (myRef.child(Const.nodeuser).child(username).child("password").equals(password)) {
                pesan[0] = myRef.child(Const.nodeuser).child("jenis").toString();
                pesan[1] = "SCL";
            }
            else {
                pesan[0] = null;
                pesan[1] = "ERP";
            }
        }
        else {
            pesan[0] = null;
            pesan[1] = "ERU";
        }

        return pesan;
    }
}
