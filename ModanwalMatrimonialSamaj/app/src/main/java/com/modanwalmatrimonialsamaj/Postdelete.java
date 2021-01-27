package com.modanwalmatrimonialsamaj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Postdelete extends AppCompatActivity {
     Button  post,back;
     EditText id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postdelete);
        id=findViewById(R.id.postid);
        post=findViewById(R.id.adminpostdelete);
        back=findViewById(R.id.deletetohome);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Postdelete.this, Admineventpost.class);
                startActivity(i);
            }
        });
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String postid=id.getText().toString().trim();
                DatabaseReference d= FirebaseDatabase.getInstance().getReference("Event").child(postid);
                d.removeValue();
                Toast.makeText(getApplicationContext(),"Notification Deleted",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private long backPressedTime;
    @Override
    public void onBackPressed() {
        if(backPressedTime+2000>System.currentTimeMillis()) {
            super.onBackPressed();
        }
        else
        {
            Toast.makeText(getBaseContext(), "Press Back Again to Exit", Toast.LENGTH_SHORT).show();
        }
        backPressedTime=System.currentTimeMillis();
    }
}
