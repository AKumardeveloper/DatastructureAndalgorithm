package com.modanwalmatrimonialsamaj;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Search extends AppCompatActivity {
    String state,district,gender;
    Spinner spinner5,spinner6,spinner7,spinner8;
    Button submit,back;
    private static final String TAG = "Search";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        submit=(Button)findViewById(R.id.bsubmit);
        back=(Button)findViewById(R.id.bback);
        spinner5=(Spinner)findViewById(R.id.spinner5);
        spinner6=(Spinner)findViewById(R.id.spinner6);
        spinner7=(Spinner)findViewById(R.id.spinner7);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i9=new Intent(Search.this, Myprofile.class);
                startActivity(i9);
                finish();
            }
        });
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                state=spinner5.getSelectedItem().toString();
                switch (i){
                    case 1:
                        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Andhrapradeshdistrict, android.R.layout.simple_spinner_item);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter);
                        break;
                    case 2:
                        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Arunachalpradesh, android.R.layout.simple_spinner_item);
                        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter1);
                        break;
                    case 3:
                        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Assamdistricts, android.R.layout.simple_spinner_item);
                        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter2);
                        break;
                    case 4:
                        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Bhihardistricts, android.R.layout.simple_spinner_item);
                        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter3);
                        break;
                    case 5:
                        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Chhattisgarhdistricts, android.R.layout.simple_spinner_item);
                        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter4);
                        break;
                    case 6:
                        ArrayAdapter<CharSequence> adapter45 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Delhidistricts, android.R.layout.simple_spinner_item);
                        adapter45.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter45);
                        break;
                    case 7:
                        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Goadistricts, android.R.layout.simple_spinner_item);
                        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter5);
                        break;
                    case 8:
                        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Gujaratdistrics, android.R.layout.simple_spinner_item);
                        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter6);
                        break;
                    case 9:
                        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Haryanadistricts, android.R.layout.simple_spinner_item);
                        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter7);
                        break;
                    case 10:
                        ArrayAdapter<CharSequence> adapter8= ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.HimachalPradeshdistricts, android.R.layout.simple_spinner_item);
                        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter8);
                        break;
                    case 11:
                        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Jammukashmirdistricts, android.R.layout.simple_spinner_item);
                        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter9);
                        break;
                    case 12:
                        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Jharkhanddistrics, android.R.layout.simple_spinner_item);
                        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter10);
                        break;
                    case 13:
                        ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Karnatakadistricts, android.R.layout.simple_spinner_item);
                        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter11);
                        break;
                    case 14:
                        ArrayAdapter<CharSequence> adapter12 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Keraladistrics, android.R.layout.simple_spinner_item);
                        adapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter12);
                        break;
                    case 15:
                        ArrayAdapter<CharSequence> adapter13 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Madhyapradeshdistricts, android.R.layout.simple_spinner_item);
                        adapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter13);
                        break;
                    case 16:
                        ArrayAdapter<CharSequence> adapter14 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Maharashtradistricts, android.R.layout.simple_spinner_item);
                        adapter14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter14);
                        break;
                    case 17:
                        ArrayAdapter<CharSequence> adapter15 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Manipurdistricts, android.R.layout.simple_spinner_item);
                        adapter15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter15);
                        break;
                    case 18:
                        ArrayAdapter<CharSequence> adapter16 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Meghalayadistrics, android.R.layout.simple_spinner_item);
                        adapter16.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter16);
                        break;
                    case 19:
                        ArrayAdapter<CharSequence> adapter17 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Mizoramdistricts, android.R.layout.simple_spinner_item);
                        adapter17.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter17);
                        break;
                    case 20:
                        ArrayAdapter<CharSequence> adapter18 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Nagalanddistricts, android.R.layout.simple_spinner_item);
                        adapter18.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter18);
                        break;
                    case 21:
                        ArrayAdapter<CharSequence> adapter19 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Odishadistricts, android.R.layout.simple_spinner_item);
                        adapter19.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter19);
                        break;
                    case 22:
                        ArrayAdapter<CharSequence> adapter20 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Punjabdistricts, android.R.layout.simple_spinner_item);
                        adapter20.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter20);
                        break;
                    case 23:
                        ArrayAdapter<CharSequence> adapter21 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Rajasthandistrics, android.R.layout.simple_spinner_item);
                        adapter21.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter21);
                        break;
                    case 24:
                        ArrayAdapter<CharSequence> adapter22 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Sikkimdistricts, android.R.layout.simple_spinner_item);
                        adapter22.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter22);
                        break;
                    case 25:
                        ArrayAdapter<CharSequence> adapter23 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Tamilnududistricts, android.R.layout.simple_spinner_item);
                        adapter23.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter23);
                        break;
                    case 26:
                        ArrayAdapter<CharSequence> adapter24 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Telanganadistricts, android.R.layout.simple_spinner_item);
                        adapter24.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter24);
                        break;
                    case 27:
                        ArrayAdapter<CharSequence> adapter25 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Tripuradistricts, android.R.layout.simple_spinner_item);
                        adapter25.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter25);
                        break;
                    case 28:
                        ArrayAdapter<CharSequence> adapter26 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Uttarakhanddistricts, android.R.layout.simple_spinner_item);
                        adapter26.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter26);
                        break;
                    case 29:
                        ArrayAdapter<CharSequence> adapter27 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Updistricts, android.R.layout.simple_spinner_item);
                        adapter27.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter27);
                        break;
                    case 30:
                        ArrayAdapter<CharSequence> adapter28 = ArrayAdapter.createFromResource(getBaseContext(),
                                R.array.Westbengaldistricts, android.R.layout.simple_spinner_item);
                        adapter28.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner6.setAdapter(adapter28);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                district=spinner6.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                gender=spinner7.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i42=new Intent(Search.this,Searchmenu.class);
                    i42.putExtra("state",state);
                    i42.putExtra("district",district);
                    i42.putExtra("gender",gender);
                    startActivity(i42);
                    finish();
                }catch (Exception e){
                    Toast.makeText(getBaseContext(),"Please Fill State, District, Gender",Toast.LENGTH_LONG).show();
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
