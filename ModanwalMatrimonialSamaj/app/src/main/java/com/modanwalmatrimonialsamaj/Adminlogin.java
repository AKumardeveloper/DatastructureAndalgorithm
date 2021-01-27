package com.modanwalmatrimonialsamaj;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Adminlogin extends AppCompatActivity {
   Button signin,home;
   EditText emailid,password;
    FirebaseAuth mFirebaseAuth;
    String email="Purana",pwd;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        mFirebaseAuth = FirebaseAuth.getInstance();
        signin=findViewById(R.id.adminsignin);
        home=findViewById(R.id.admintohome);
        emailid=(EditText) findViewById(R.id.adminemail);
        password=(EditText) findViewById(R.id.adminpass);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 email = emailid.getText().toString().trim();
                 pwd = password.getText().toString().trim();
                    if (email.isEmpty()) {
                        emailid.setError("Please Enter email Id");
                        emailid.requestFocus();
                    } else if (pwd.isEmpty()) {
                        password.setError("Please Enter email Id");
                        password.requestFocus();

                    } else if (email.isEmpty() && pwd.isEmpty()) {
                        Toast.makeText(Adminlogin.this, "Feild are Empty", Toast.LENGTH_SHORT).show();
                    } else if (!(email.isEmpty() && pwd.isEmpty())) {
                        if(email.equals("admin1@modanwal.com") || email.equals("admin2@modanwal.com") || email.equals("admin3@modanwal.com") || email.equals("admin4@modanwal.com")|| email.equals("admin5@modanwal.com")) {
                            mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(Adminlogin.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(Adminlogin.this, "Login Error, Please Login again", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Intent i2 = new Intent(Adminlogin.this, Admineventpost.class);
                                        startActivity(i2);
                                    }
                                }
                            });
                        }
                        else
                        {
                            Toast.makeText(Adminlogin.this, "Sorry You are not Admin", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(Adminlogin.this, "Error Occurred!", Toast.LENGTH_SHORT).show();
                    }
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Adminlogin.this, MainActivity.class);
                startActivity(i);
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
