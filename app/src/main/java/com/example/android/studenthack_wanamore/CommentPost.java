package com.example.android.studenthack_wanamore;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CommentPost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_post);
    }
    public static void start(Context context) {
        Intent starter = new Intent(context, CommentPost.class);
      //  starter.putExtra();
        context.startActivity(starter);
    }
}
