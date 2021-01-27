package com.modanwalmatrimonialsamaj;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static android.app.Activity.RESULT_OK;

public class Creatprofile extends AppCompatActivity {
    private static final String TAG = "Creatprofile";
    Spinner spinner, spinner2, spinner3, spinner4;
    String state,district,gender,profession,name,parentname,height,color,mob,dob,address;
    Button b1,b2;
    TextView photo;
    EditText e1;
    ImageView img1;
    private static final int SELECTED_PIC=1;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databasestate;
    FirebaseAuth mFirebaseAuth;
    Uri filepath;
    Uri downloadUrl;
    String imgUrl;
    private StorageReference StorageReference;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case SELECTED_PIC:
                if (resultCode == RESULT_OK) {
                    try {
                        filepath = data.getData();
                        InputStream imageStream = getContentResolver().openInputStream(filepath);
                        Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        selectedImage = getResizedBitmap(selectedImage, 200);// 400 is for example, replace with desired size
                        img1.setImageBitmap(selectedImage);
                    } catch (FileNotFoundException e) {

                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }
    }
    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float)width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creatprofile);
        StorageReference = FirebaseStorage.getInstance().getReference();
        mFirebaseAuth=FirebaseAuth.getInstance();
        b1=(Button)findViewById(R.id.button3);
        b2=(Button)findViewById(R.id.button5);
        photo=(TextView) findViewById(R.id.button6);
        e1=(EditText)findViewById(R.id.editText2);
        img1=(ImageView)findViewById(R.id.imageView2);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        final Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        final Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
        Bundle bundle=getIntent().getExtras();
         name=bundle.getString("name");
         parentname=bundle.getString("parentname");
         height=bundle.getString("height");
         color=bundle.getString("color");
         mob=bundle.getString("mob");
         dob=bundle.getString("dob");
       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               state=spinner.getSelectedItem().toString();
               switch (i){
                   case 1:
                       ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Andhrapradeshdistrict, android.R.layout.simple_spinner_item);
                       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter);
                       break;
                   case 2:
                       ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Arunachalpradesh, android.R.layout.simple_spinner_item);
                       adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter1);
                       break;
                   case 3:
                       ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Assamdistricts, android.R.layout.simple_spinner_item);
                       adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter2);
                       break;
                   case 4:
                       ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Bhihardistricts, android.R.layout.simple_spinner_item);
                       adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter3);
                       break;
                   case 5:
                       ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Chhattisgarhdistricts, android.R.layout.simple_spinner_item);
                       adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter4);
                       break;
                   case 6:
                       ArrayAdapter<CharSequence> adapter45 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Delhidistricts, android.R.layout.simple_spinner_item);
                       adapter45.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter45);
                       break;
                   case 7:
                       ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Goadistricts, android.R.layout.simple_spinner_item);
                       adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter5);
                       break;
                   case 8:
                       ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Gujaratdistrics, android.R.layout.simple_spinner_item);
                       adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter6);
                       break;
                   case 9:
                       ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Haryanadistricts, android.R.layout.simple_spinner_item);
                       adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter7);
                       break;
                   case 10:
                       ArrayAdapter<CharSequence> adapter8= ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.HimachalPradeshdistricts, android.R.layout.simple_spinner_item);
                       adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter8);
                       break;
                   case 11:
                       ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Jammukashmirdistricts, android.R.layout.simple_spinner_item);
                       adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter9);
                       break;
                   case 12:
                       ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Jharkhanddistrics, android.R.layout.simple_spinner_item);
                       adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter10);
                       break;
                   case 13:
                       ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Karnatakadistricts, android.R.layout.simple_spinner_item);
                       adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter11);
                       break;
                   case 14:
                       ArrayAdapter<CharSequence> adapter12 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Keraladistrics, android.R.layout.simple_spinner_item);
                       adapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter12);
                       break;
                   case 15:
                       ArrayAdapter<CharSequence> adapter13 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Madhyapradeshdistricts, android.R.layout.simple_spinner_item);
                       adapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter13);
                       break;
                   case 16:
                       ArrayAdapter<CharSequence> adapter14 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Maharashtradistricts, android.R.layout.simple_spinner_item);
                       adapter14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter14);
                       break;
                   case 17:
                       ArrayAdapter<CharSequence> adapter15 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Manipurdistricts, android.R.layout.simple_spinner_item);
                       adapter15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter15);
                       break;
                   case 18:
                       ArrayAdapter<CharSequence> adapter16 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Meghalayadistrics, android.R.layout.simple_spinner_item);
                       adapter16.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter16);
                       break;
                   case 19:
                       ArrayAdapter<CharSequence> adapter17 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Mizoramdistricts, android.R.layout.simple_spinner_item);
                       adapter17.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter17);
                       break;
                   case 20:
                       ArrayAdapter<CharSequence> adapter18 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Nagalanddistricts, android.R.layout.simple_spinner_item);
                       adapter18.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter18);
                       break;
                   case 21:
                       ArrayAdapter<CharSequence> adapter19 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Odishadistricts, android.R.layout.simple_spinner_item);
                       adapter19.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter19);
                       break;
                   case 22:
                       ArrayAdapter<CharSequence> adapter20 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Punjabdistricts, android.R.layout.simple_spinner_item);
                       adapter20.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter20);
                       break;
                   case 23:
                       ArrayAdapter<CharSequence> adapter21 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Rajasthandistrics, android.R.layout.simple_spinner_item);
                       adapter21.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter21);
                       break;
                   case 24:
                       ArrayAdapter<CharSequence> adapter22 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Sikkimdistricts, android.R.layout.simple_spinner_item);
                       adapter22.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter22);
                       break;
                   case 25:
                       ArrayAdapter<CharSequence> adapter23 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Tamilnududistricts, android.R.layout.simple_spinner_item);
                       adapter23.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter23);
                       break;
                   case 26:
                       ArrayAdapter<CharSequence> adapter24 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Telanganadistricts, android.R.layout.simple_spinner_item);
                       adapter24.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter24);
                       break;
                   case 27:
                       ArrayAdapter<CharSequence> adapter25 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Tripuradistricts, android.R.layout.simple_spinner_item);
                       adapter25.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter25);
                       break;
                   case 28:
                       ArrayAdapter<CharSequence> adapter26 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Uttarakhanddistricts, android.R.layout.simple_spinner_item);
                       adapter26.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter26);
                       break;
                   case 29:
                       ArrayAdapter<CharSequence> adapter27 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Updistricts, android.R.layout.simple_spinner_item);
                       adapter27.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter27);
                       break;
                   case 30:
                       ArrayAdapter<CharSequence> adapter28 = ArrayAdapter.createFromResource(getBaseContext(),
                               R.array.Westbengaldistricts, android.R.layout.simple_spinner_item);
                       adapter28.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                       spinner2.setAdapter(adapter28);
                       break;
                   default:
                       break;
               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {
           }
       });
       spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               district=spinner2.getSelectedItem().toString();
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });
       spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               gender=spinner3.getSelectedItem().toString();
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });
       spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               profession=spinner4.getSelectedItem().toString();
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });
       img1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
             startActivityForResult(intent,SELECTED_PIC);
             photo.setText("");
           }
       });

       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              try {
                  address=e1.getText().toString().trim();
                  if(address!=null){
                  uploadfile();}
                  else
                  {
                      Toast.makeText(getApplicationContext(),"Please Fill Villege Name",Toast.LENGTH_LONG).show();
                  }
              }
              catch (Exception e){
                  Toast.makeText(getBaseContext(),"Please Try Again",Toast.LENGTH_LONG).show();
              }
              }
       });
       b2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i9 = new Intent(Creatprofile.this,Nameactivity.class);
               startActivity(i9);
               finish();
           }
       });
    }
 private void addName(){
     databasestate= FirebaseDatabase.getInstance().getReference().child("UserProfile");
        if(!TextUtils.isEmpty(name)){
            FirebaseUser user=mFirebaseAuth.getCurrentUser();
            String id=user.getUid();
            String emailid=user.getEmail();
             Modeldata modeldata=new Modeldata(id,state,name,district,gender,profession,parentname,height,color,mob,dob,address,imgUrl,emailid);
             databasestate.child(id).setValue(modeldata);
             Toast.makeText(this,"Congratulations. Now your name has been registered.",Toast.LENGTH_LONG).show();
            Intent i16 = new Intent(Creatprofile.this,MainActivity.class);
            startActivity(i16);
            finish();
        }else {
            Toast.makeText(this,"\n" + "Fill the state, district, gender, business, village",Toast.LENGTH_LONG).show();
        }
 }
 private void uploadfile() {

     if (filepath != null) {
         final ProgressDialog progressDialog=new ProgressDialog(this);
         progressDialog.setTitle("\n" + "Uploading ..");
         progressDialog.show();
         StorageReference riversRef = StorageReference.child("images").child(filepath.getLastPathSegment());
         riversRef.putFile(filepath)
                 .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                     @Override
                     public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                         progressDialog.dismiss();
                         Toast.makeText(getApplicationContext(),"\n" + "Uploaded a photo",Toast.LENGTH_LONG).show();
                         // Get a URL to the uploaded content
                          downloadUrl = taskSnapshot.getDownloadUrl();
                          imgUrl=downloadUrl.toString();
                         addName();
                     }
                 })
                 .addOnFailureListener(new OnFailureListener() {
                     @Override
                     public void onFailure(@NonNull Exception exception) {
                         progressDialog.dismiss();
                         // Handle unsuccessful uploads
                         Toast.makeText(getApplicationContext(),"Photo not uploaded",Toast.LENGTH_LONG).show();
                         addName();
                     }
                 }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
             @Override
             public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                 double progress=(100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                 progressDialog.setMessage(((int)progress)+"% Upload...");
             }
         });
     }else {
         imgUrl="https://firebasestorage.googleapis.com/v0/b/madanwalmatrimonialsamaj.appspot.com/o/images%2Fstorage" +
                 "%2Femulated%2F0%2Fdownload%2Funnamed%20(1).png?alt=media&token=29431856-b56d-4d4f-8dc9-1200c655a8ad";
         addName();
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
