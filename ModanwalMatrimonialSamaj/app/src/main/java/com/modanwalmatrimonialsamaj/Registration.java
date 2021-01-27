package com.modanwalmatrimonialsamaj;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {

    EditText emailid, password;
    Button btnSignUp;
    TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mFirebaseAuth =FirebaseAuth.getInstance();
        emailid =findViewById(R.id.editTextemail);
        password=findViewById(R.id.editTextpass);
        btnSignUp=findViewById(R.id.btnsignup);
        tvSignIn=findViewById(R.id.textViewsinin);
        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.home2);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i28 = new Intent(Registration.this,MainActivity.class);
                startActivity(i28);
                finish();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailid.getText().toString();
                String pwd=password.getText().toString();
                if(email.isEmpty())
                {
                    emailid.setError("Please Enter email Id");
                    emailid.requestFocus();
                }
                else if(pwd.isEmpty())
                {
                    password.setError("Please Enter email Id");
                    password.requestFocus();

                }
                else if(email.isEmpty() && pwd.isEmpty())
                {
                    Toast.makeText(Registration.this,"Feild are Empty",Toast.LENGTH_SHORT).show();
                }
                else if(!(email.isEmpty() && pwd.isEmpty()))
                {
                    mFirebaseAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(Registration.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful())
                            {
                                Toast.makeText(Registration.this,"SignUp Unsuccesful",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                startActivity(new Intent(Registration.this, Myprofile.class));
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(Registration.this,"Error Occurred!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Registration.this,Login.class);
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
