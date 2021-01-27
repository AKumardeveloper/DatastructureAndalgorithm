package com.modanwalmatrimonialsamaj;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Calendar;

public class Agecalculator extends AppCompatActivity {
    Button b1;
    TextView t1,t2,t3;
    Integer y1,y2,y3,d1,d2,d3,m1,m2,m3;
    private static final String TAG = "Agecalculator";
    private DatePickerDialog.OnDateSetListener aDatasetLintener,bDatasetLintener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agecalculator);
        t1=(TextView)findViewById(R.id.textView38);
        t2=(TextView)findViewById(R.id.textView30);
        t3=(TextView)findViewById(R.id.textView31);
        b1=(Button)findViewById(R.id.button7);
        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fabe);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i29 = new Intent(Agecalculator.this,MainActivity.class);
                startActivity(i29);
                finish();
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal=Calendar.getInstance();
                y1=cal.get(Calendar.YEAR);
                m1=cal.get(Calendar.MONTH);
                d1=cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog=new DatePickerDialog(Agecalculator.this,aDatasetLintener,y1,m1,d1);
                dialog.show();
            }
        });
        aDatasetLintener =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year1, int month1, int day1) {
                m1=month1+1;
                y1=year1;
                d1=day1;
                Log.d(TAG," "+m1+d1+y1);
                String dd=String.format("%02d",d1);
                String mm=String.format("%02d",m1);
                String yyyy=String.format("%04d",y1);
                String pop1=dd+"/"+mm+"/"+yyyy;
                t2.setText(pop1);
            }
        };
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal2=Calendar.getInstance();
                y2=cal2.get(Calendar.YEAR);
                m2=cal2.get(Calendar.MONTH);
                d2=cal2.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog2=new DatePickerDialog(Agecalculator.this,bDatasetLintener,y2,m2,d2);
                dialog2.show();
            }
        });
        bDatasetLintener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year2, int month2, int day2) {
                m2=month2+1;
                y2=year2;
                d2=day2;
                Log.d(TAG," "+m2+d2+y2);
                String dd2=String.format("%02d",d2);
                String mm2=String.format("%02d",m2);
                String yyyy2=String.format("%04d",y2);
                String pop2=dd2+"/"+mm2+"/"+yyyy2;
                t3.setText(pop2);
            }
        };
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (d1!=null && d2!=null && m1!=null && m2!=null && y1!=null && y2!=null) {
                        try {
                            if (d1 > d2) {
                                d2 = d2 + 30;
                                d3 = d2 - d1;
                                m2 = m2 - 1;
                                if (m1 > m2) {
                                    m2 = m2 + 12;
                                    m3 = m2 - m1;
                                    y2 = y2 - 1;
                                    y3 = y2 - y1;
                                } else {
                                    m3 = m2 - m1;
                                    y3 = y2 - y1;
                                }
                            } else {
                                d3 = d2 - d1;
                                if (m1 > m2) {
                                    m2 = m2 + 12;
                                    m3 = m2 - m1;
                                    y2 = y2 - 1;
                                    y3 = y2 - y1;
                                } else {
                                    m3 = m2 - m1;
                                    y3 = y2 - y1;

                                }
                                t1.setText(d3 + " Days " + m3 + " Months " + y3 + " Years ");
                            }
                        }catch (Exception e) {
                            Toast.makeText(getBaseContext(), "Please Try Again", Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        Toast.makeText(getBaseContext(), "Please Fill Date ", Toast.LENGTH_LONG).show();
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
