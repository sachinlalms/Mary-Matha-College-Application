package com.example.marymathacollege;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.marymathacollege.faculty.UpdateFaculty;
import com.example.marymathacollege.notice.DeleteNoticeActivity;
import com.example.marymathacollege.notice.UploadNotice;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView name;
    private Button logout;
    FirebaseAuth mAuth;
    FirebaseUser user =  FirebaseAuth.getInstance().getCurrentUser();


    CardView uploadnotice,addgalleryimage,addebook,addfacalty,deletenotic,addQstn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.userName);
        logout = findViewById(R.id.userlogout);
        mAuth=FirebaseAuth.getInstance();

        if(user!=null){
            name.setText(user.getDisplayName());
        }
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(MainActivity.this,ActivityLogin.class));
                finish();
            }
        });



        uploadnotice=findViewById(R.id.addNotice);
        addgalleryimage=findViewById(R.id.addgalleryimage);
        addfacalty= findViewById(R.id.addfacalty);
        deletenotic = findViewById(R.id.deletenotic);
        addQstn = findViewById(R.id.addQstn);

        addebook=findViewById(R.id.addebook);



        uploadnotice.setOnClickListener(this);
        addgalleryimage.setOnClickListener(this);
        addebook.setOnClickListener(this);
        addfacalty.setOnClickListener(this);
        deletenotic.setOnClickListener(this);
        addQstn.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(user == null){
            startActivity(new Intent(this,ActivityLogin.class));
            finish();
        }
    }


    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.addNotice:
                 intent = new Intent(MainActivity.this, UploadNotice.class);
                startActivity(intent);
                break;
            case R.id.addgalleryimage:
                 intent = new Intent(MainActivity.this, UploadImage.class);
                startActivity(intent);
                break;

             case R.id.addebook:
                 intent = new Intent(MainActivity.this, UploadPdf.class);
                startActivity(intent);
                break;
             case R.id.addfacalty:
                 intent = new Intent(MainActivity.this, UpdateFaculty.class);
                startActivity(intent);
                break;
             case R.id.deletenotic:
                 intent = new Intent(MainActivity.this, DeleteNoticeActivity.class);
                startActivity(intent);
                break;
            case R.id.addQstn:
                intent = new Intent(MainActivity.this, UploadQuestions.class);
                startActivity(intent);
                break;

        }


    }
}