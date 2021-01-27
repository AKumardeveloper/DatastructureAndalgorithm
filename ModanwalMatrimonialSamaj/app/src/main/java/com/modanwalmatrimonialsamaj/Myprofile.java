package com.modanwalmatrimonialsamaj;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class Myprofile extends AppCompatActivity {
    ArrayList<String> list=new ArrayList<>();
    Button create,search,logout,delete,update;
    FirebaseAuth mFirebaseAuth;
    TextView name,parent,dob,profession,height,color,mob,email,address;
    ImageView imageViewphoto;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);
        mFirebaseAuth=FirebaseAuth.getInstance();
        create = findViewById(R.id.bcreate);
        search=findViewById(R.id.bsearch);
        logout=findViewById(R.id.blogout);
        delete=findViewById(R.id.bdelete);
        update=findViewById(R.id.bupdate);
         name=findViewById(R.id.name);
         parent=findViewById(R.id.parentname);
         dob=findViewById(R.id.dob);
         profession=findViewById(R.id.profesion);
         height=findViewById(R.id.height);
         color=findViewById(R.id.color);
         mob=findViewById(R.id.mobno);
         email=findViewById(R.id.email);
         address=findViewById(R.id.address);
         imageViewphoto=findViewById(R.id.profilePhoto);
        Button fab1 = findViewById(R.id.home);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i28 = new Intent(Myprofile.this,MainActivity.class);
                startActivity(i28);
                finish();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(Myprofile.this,Nameactivity.class);
                startActivity(i1);
                finish();
            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(Myprofile.this,Nameactivity.class);
                startActivity(i1);
                finish();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(Myprofile.this,Search.class);
                startActivity(i2);
                finish();
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent movetohome=new Intent(Myprofile.this,MainActivity.class);
                startActivity(movetohome);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user=mFirebaseAuth.getCurrentUser();
                String id=user.getUid();
                DatabaseReference d= FirebaseDatabase.getInstance().getReference("UserProfile").child(id);
                d.removeValue();
                Toast.makeText(getApplicationContext(),"Profile Deleted",Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onStart() {

        super.onStart();
        if(mFirebaseAuth.getCurrentUser()!=null) {
            FirebaseUser user=mFirebaseAuth.getCurrentUser();
            String id=user.getUid();
            Query q = FirebaseDatabase.getInstance().getReference().child("UserProfile").orderByChild("nameId").equalTo(id);
            q.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot searchSnapshot : dataSnapshot.getChildren()) {
                        Modeldata modeldata = searchSnapshot.getValue(Modeldata.class);
                        if (modeldata.getAddress() == null || modeldata.getEmail() == null || modeldata.getDob() == null || modeldata.getColor() == null || modeldata.getName() == null)
                            continue;
                        if (modeldata.getHeight() == null || modeldata.getProfession() == null || modeldata.getMob() == null || modeldata.getParentname() == null )
                            continue;
                        name.setText(modeldata.getName());
                        String Date=modeldata.getDob();
                        String d,m,y,Dobdym="";
                        d=Date.substring(0,2);
                        m=Date.substring(2,4);
                        y=Date.substring(4);
                        Dobdym=d+"/"+m+"/"+y;
                        dob.setText(Dobdym);
                        height.setText(modeldata.getHeight());
                        address.setText(modeldata.getAddress()+", "+modeldata.getDistrict()+", "+modeldata.getState());
                        profession.setText(modeldata.getProfession());
                        parent.setText(modeldata.getParentname());
                        color.setText(modeldata.getColor());
                        mob.setText(modeldata.getMob());
                        email.setText(modeldata.getEmail());
                       if(modeldata.getUrl()!=null) {
                           Picasso.with(getApplicationContext()).load(modeldata.getUrl()).into(imageViewphoto);
                       }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        else
        {
            name.setText("Profile Not Created");
        }
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
