package com.example.marymathacollege;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ActivityLogin extends AppCompatActivity {
    private EditText logEmail, logPass;
    private Button login;
    private TextView register;
    private String email,pass;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logEmail = findViewById(R.id.logEmail);
        logPass=findViewById(R.id.logPass);
        login = findViewById(R.id.userLogin);
        register = findViewById(R.id.openRegister);
        mAuth = FirebaseAuth.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityLogin.this,RegisterActivity.class));
                finish();
                
            }
        });
        
        login.setOnClickListener((view)->{
            validateUser();
            
        });


    }

    private void validateUser() {

        email = logEmail.getText().toString();
        pass = logPass.getText().toString();

        if ( email.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else {
            loginuser();
        }
    }

    private void loginuser() {
        mAuth.signInWithEmailAndPassword(email,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(ActivityLogin.this, "Login Success", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ActivityLogin.this,MainActivity.class));
                            finish();
                        }else{
                            Toast.makeText(ActivityLogin.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
