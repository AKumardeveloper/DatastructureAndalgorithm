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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

public class Admineventpost extends AppCompatActivity {
    Button post,home,delete;
    EditText desct,titlet,postid;
    TextView tv;
    ImageView img1;
    private static final int SELECTED_PIC=1;
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
                        selectedImage = getResizedBitmap(selectedImage, 400);// 400 is for example, replace with desired size
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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admineventpost);
        StorageReference = FirebaseStorage.getInstance().getReference();
        mFirebaseAuth=FirebaseAuth.getInstance();
        postid=findViewById(R.id.adminpostid);
        titlet=findViewById(R.id.adminposttitle);
        desct=findViewById(R.id.adminpostdesc);
        tv=findViewById(R.id.posttextView);
        post=findViewById(R.id.adminpostbutton);
        home=findViewById(R.id.adminposttohome);
        delete=findViewById(R.id.adminposttodelete);
        img1=(ImageView)findViewById(R.id.postimageView);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(Admineventpost.this, Postdelete.class);
                startActivity(i3);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Admineventpost.this, Adminlogin.class);
                startActivity(i);
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,SELECTED_PIC);
                tv.setText("");
            }
        });
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    uploadfile();
                }
                catch (Exception e){
                    Toast.makeText(getBaseContext(),"Please Try Again",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void addName(){
        String title=titlet.getText().toString().trim();
        String desc=desct.getText().toString().trim();
        String id=postid.getText().toString().trim();
        title="ID:"+id+" "+title;
        databasestate= FirebaseDatabase.getInstance().getReference().child("Event");
        if(!TextUtils.isEmpty(id)){
            Blog modeldata=new Blog(title,desc,imgUrl);
            databasestate.child(id).setValue(modeldata);
            Toast.makeText(this,"Congratulations. Notification has posted.",Toast.LENGTH_LONG).show();
            Intent i16 = new Intent(Admineventpost.this,MainActivity.class);
            startActivity(i16);
            finish();
        }else {
            Toast.makeText(this,"\n" + "Fill Title & Discription",Toast.LENGTH_LONG).show();
        }
    }
    private void uploadfile() {
        if (filepath != null) {
            final ProgressDialog progressDialog=new ProgressDialog(this);
            progressDialog.setTitle("\n" + "Uploading ..");
            progressDialog.show();
            StorageReference riversRef = StorageReference.child("Eventsimage").child(filepath.getLastPathSegment());
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
            imgUrl=null;
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
