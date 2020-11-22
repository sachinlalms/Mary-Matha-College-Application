package com.example.marymathacollege;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.HashMap;

public class UploadQuestions extends AppCompatActivity {
    private CardView addQp;
    private final int REQ=1;
    private Uri qpData;
    private EditText questiontitle;
    private Button uploadqstnbtn;
    private DatabaseReference databaseReference;
    private StorageReference storageReference;
    String downloadUrl = "";
    private ProgressDialog pd;
    private TextView qptextview;
    private String qpName,qptitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_questions);

        pd = new ProgressDialog(this);
        addQp = findViewById(R.id.addQp);
        questiontitle = findViewById(R.id.questiontitle);
        qptextview = findViewById(R.id.qptextview);
        uploadqstnbtn = findViewById(R.id.uploadqstnbtn);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        storageReference = FirebaseStorage.getInstance().getReference();
        try {
            addQp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openGallery();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        try {
            uploadqstnbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    qptitle = questiontitle.getText().toString();
                    if(qptitle.isEmpty()){
                        questiontitle.setError("Empty");
                        questiontitle.requestFocus();
                    }else if(qpData==null){
                        Toast.makeText(UploadQuestions.this, "Please upload Question paper", Toast.LENGTH_SHORT).show();
                    }else{
                        uploadpdf();
                    }

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    private void uploadpdf() {
        pd.setTitle("Please wait...");
        pd.setMessage("Uploading pdf");
        pd.show();
        StorageReference reference = storageReference.child("question/"+qpName+"-"+System.currentTimeMillis()+".pdf");
        reference.putFile(qpData)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                        while (!uriTask.isComplete());
                        Uri uri =uriTask.getResult();
                        UploadData(String.valueOf(uri));
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(UploadQuestions.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void UploadData(String downloadUrl) {
        String uniqueKey = databaseReference.child("question").push().getKey();
        HashMap data = new HashMap();
        data.put("questiontitle",qptitle);
        data.put("QuestionUrl",downloadUrl);
        databaseReference.child("question").child(uniqueKey).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                pd.dismiss();
                Toast.makeText(UploadQuestions.this, "Pdf uploaded successfully", Toast.LENGTH_SHORT).show();
                questiontitle.setText("");

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(UploadQuestions.this, "Failed to upload pdf", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void openGallery() {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Pdf File"),REQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQ && resultCode==RESULT_OK ){
            qpData = data.getData();

            if(qpData.toString().startsWith("content://")){

                Cursor cursor= null;
                //ctrl+alt+t execption
                try {
                    cursor = UploadQuestions.this.getContentResolver().query(qpData,null,null,null,null);
                    if(cursor != null && cursor.moveToFirst());
                    qpName=cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }else if(qpData.toString().startsWith("file://")){

                qpName=new File(qpData.toString()).getName();
            }
            qptextview.setText(qpName);
        }
    }
}