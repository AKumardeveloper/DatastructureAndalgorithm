package com.modanwalmatrimonialsamaj;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Nameactivity extends AppCompatActivity {
     Button b4,b8;
     EditText e1,e2,e3,e4,e5;
     TextView e6;
     String name,parentname,height,color,mob,dob;
     private static final String TAG="Nameactivity";
     private DatePickerDialog.OnDateSetListener mDatasetLintener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nameactivity);
        b4=(Button)findViewById(R.id.button8);
        b8=(Button)findViewById(R.id.button4);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText3);
        e3=(EditText)findViewById(R.id.editText4);
        e4=(EditText)findViewById(R.id.editText5);
        e5=(EditText)findViewById(R.id.editText6);
        e6=(TextView)findViewById(R.id.editText7);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i29 = new Intent(Nameactivity.this, Myprofile.class);
                startActivity(i29);
                finish();
            }
        });
        e6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                         Calendar cal=Calendar.getInstance();
                         int year=cal.get(Calendar.YEAR);
                         int month=cal.get(Calendar.MONTH);
                         int day=cal.get(Calendar.DAY_OF_MONTH);
                         DatePickerDialog dialog=new DatePickerDialog(Nameactivity.this,mDatasetLintener,year,month,day);
                         dialog.show();
            }
        });
        mDatasetLintener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month=month+1;
                Log.d(TAG," "+month+day+year);
                String dd=String.format("%02d",day);
                String mm=String.format("%02d",month);
                String yyyy=String.format("%04d",year);
                dob=dd+""+mm+""+yyyy;
              String pop=day+"/"+month+"/"+year;
              e6.setText(pop);
            }
        };
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=e1.getText().toString().trim();
                parentname=e2.getText().toString().trim();
                height=e3.getText().toString().trim();
                color=e4.getText().toString().trim();
                mob=e5.getText().toString().trim();
                for(int i=0;i<name.length();i++) {
                    if(i==0 || name.charAt(i-1)==' ' && i!=0) {
                        if (name.charAt(i) >= 97 && name.charAt(i) <= 122) {
                            int n = name.charAt(i) - 32;
                            char ch = (char) n;
                            String first="";
                            if(i>0)
                               first=name.substring(0,i)+" ";
                            name = first+ch + name.substring(i+1);
                        }
                    }
                }
                for(int i=0;i<parentname.length();i++) {
                    if(i==0 || parentname.charAt(i-1)==' ' && i!=0) {
                        if (parentname.charAt(i) >= 97 && parentname.charAt(i) <= 122) {
                            int n = parentname.charAt(i) - 32;
                            char ch = (char) n;
                            String first="";
                            if(i>0)
                                first=parentname.substring(0,i)+" ";
                            parentname = first+ch + parentname.substring(i+1);
                        }
                    }
                }
                if(name==null || parentname==null || height==null || color==null || mob==null || dob==null) {

                    Toast.makeText(getApplicationContext(),"\n" + "Fill the name, parentname, height, color, mobileno. date of birth Properly",Toast.LENGTH_LONG).show();

                }
                    else{ Intent i4 = new Intent(Nameactivity.this, Creatprofile.class);
                    i4.putExtra("name", name);
                    i4.putExtra("parentname", parentname);
                    i4.putExtra("height", height);
                    i4.putExtra("color", color);
                    i4.putExtra("mob", mob);
                    i4.putExtra("dob", dob);
                    startActivity(i4);
                    finish();
                }
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
