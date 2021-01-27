package com.modanwalmatrimonialsamaj;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
public class Searchmenu extends AppCompatActivity {
     String state=null,district=null,gender=null,profession=null;
     String id=null;
    ListView listViewSearch;
    DatabaseReference databasestate;
    List<Modeldata>searchList;
    private static final String TAG = "Searchmenu";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchmenu);
        listViewSearch=(ListView)findViewById(R.id.listviewsearch);
        FloatingActionButton fab10 = (FloatingActionButton) findViewById(R.id.fabresult);
        fab10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i10 = new Intent(Searchmenu.this, Myprofile.class);
                startActivity(i10);
                finish();
            }
        });
        searchList=new ArrayList<>();
        Bundle bundle=getIntent().getExtras();
        state=bundle.getString("state");
        district=bundle.getString("district");
        gender=bundle.getString("gender");

    }
    @Override
    protected void onStart() {
        super.onStart();
        if (state.equals("Select")) // Nothing Given
        {
            if (gender.equals("Select")) {
                final ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("Searching...");
                progressDialog.show();
                databasestate = FirebaseDatabase.getInstance().getReference().child("UserProfile");
                databasestate.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        searchList.clear();
                        progressDialog.dismiss();
                        for (DataSnapshot searchSnapshot : dataSnapshot.getChildren()) {
                            Modeldata modeldata = searchSnapshot.getValue(Modeldata.class);
                            if (modeldata.getAddress() == null || modeldata.getEmail() == null || modeldata.getDob() == null || modeldata.getColor() == null || modeldata.getName() == null)
                                continue;
                            if (modeldata.getHeight() == null || modeldata.getProfession() == null || modeldata.getMob() == null || modeldata.getParentname() == null )
                                continue;
                            searchList.add(modeldata);
                        }
                        SearchList adapter = new SearchList(Searchmenu.this, searchList);
                        listViewSearch.setAdapter(adapter);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        progressDialog.dismiss();
                    }
                });
            }
            else if(!gender.equals("Select"))
            {
                final ProgressDialog progressDialog=new ProgressDialog(this);
                progressDialog.setTitle("Searching...");
                progressDialog.show();
                Query q = FirebaseDatabase.getInstance().getReference().child("UserProfile").orderByChild("gender").equalTo(gender);
                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        searchList.clear();
                        progressDialog.dismiss();
                        for (DataSnapshot searchSnapshot : dataSnapshot.getChildren()) {
                            Modeldata modeldata = searchSnapshot.getValue(Modeldata.class);
                            if (modeldata.getAddress() == null || modeldata.getEmail() == null || modeldata.getDob() == null || modeldata.getColor() == null || modeldata.getName() == null)
                                continue;
                            if (modeldata.getHeight() == null || modeldata.getProfession() == null || modeldata.getMob() == null || modeldata.getParentname() == null )
                                continue;
                            searchList.add(modeldata);
                        }
                        SearchList adapter = new SearchList(Searchmenu.this, searchList);
                        listViewSearch.setAdapter(adapter);
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        progressDialog.dismiss();
                    }
                });
            }
        }
        else if(!state.equals("Select"))
        {
            if((!district.equals("Select") && gender.equals("Select")) || !district.equals("Select") && !gender.equals("Select"))
            {
                final ProgressDialog progressDialog=new ProgressDialog(this);
                progressDialog.setTitle("Searching...");
                progressDialog.show();
                Query q = FirebaseDatabase.getInstance().getReference().child("UserProfile").orderByChild("district").equalTo(district);
                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        searchList.clear();
                        progressDialog.dismiss();
                        for (DataSnapshot searchSnapshot : dataSnapshot.getChildren()) {
                            Modeldata modeldata = searchSnapshot.getValue(Modeldata.class);
                            if (modeldata.getAddress() == null || modeldata.getEmail() == null || modeldata.getDob() == null || modeldata.getColor() == null || modeldata.getName() == null)
                                continue;
                            if (modeldata.getHeight() == null || modeldata.getProfession() == null || modeldata.getMob() == null || modeldata.getParentname() == null )
                                continue;
                            searchList.add(modeldata);
                        }
                        SearchList adapter = new SearchList(Searchmenu.this, searchList);
                        listViewSearch.setAdapter(adapter);
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        progressDialog.dismiss();
                    }
                });
            }
            else if(district.equals("Select") && gender.equals("Select"))
            {
                final ProgressDialog progressDialog=new ProgressDialog(this);
                progressDialog.setTitle("Searching...");
                progressDialog.show();
                Query q = FirebaseDatabase.getInstance().getReference().child("UserProfile").orderByChild("state").equalTo(state);
                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        searchList.clear();
                        progressDialog.dismiss();
                        for (DataSnapshot searchSnapshot : dataSnapshot.getChildren()) {
                            Modeldata modeldata = searchSnapshot.getValue(Modeldata.class);
                            if (modeldata.getAddress() == null || modeldata.getEmail() == null || modeldata.getDob() == null || modeldata.getColor() == null || modeldata.getName() == null)
                                continue;
                            if (modeldata.getHeight() == null || modeldata.getProfession() == null || modeldata.getMob() == null || modeldata.getParentname() == null )
                                continue;
                            searchList.add(modeldata);
                        }
                        SearchList adapter = new SearchList(Searchmenu.this, searchList);
                        listViewSearch.setAdapter(adapter);
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        progressDialog.dismiss();
                    }
                });
            }
            else if(district.equals("Select") && !gender.equals("Select"))
            {
                final ProgressDialog progressDialog=new ProgressDialog(this);
                progressDialog.setTitle("Searching...");
                progressDialog.show();
                Query q = FirebaseDatabase.getInstance().getReference().child("UserProfile").orderByChild("gender").equalTo(gender);
                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        searchList.clear();
                        progressDialog.dismiss();
                        for (DataSnapshot searchSnapshot : dataSnapshot.getChildren()) {
                            Modeldata modeldata = searchSnapshot.getValue(Modeldata.class);
                            if (modeldata.getAddress() == null || modeldata.getEmail() == null || modeldata.getDob() == null || modeldata.getColor() == null || modeldata.getName() == null)
                                continue;
                            if (modeldata.getHeight() == null || modeldata.getProfession() == null || modeldata.getMob() == null || modeldata.getParentname() == null )
                                continue;
                            searchList.add(modeldata);
                        }
                        SearchList adapter = new SearchList(Searchmenu.this, searchList);
                        listViewSearch.setAdapter(adapter);
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        progressDialog.dismiss();
                    }
                });
            }
        }
        else {
            Toast.makeText(getBaseContext(),"Try Again Something Error",Toast.LENGTH_LONG).show();
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
