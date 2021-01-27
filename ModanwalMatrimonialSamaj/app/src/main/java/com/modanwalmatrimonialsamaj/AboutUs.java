package com.modanwalmatrimonialsamaj;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i26 = new Intent(AboutUs.this,MainActivity.class);
                startActivity(i26);
                finish();
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
