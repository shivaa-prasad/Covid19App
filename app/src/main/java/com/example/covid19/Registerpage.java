package com.example.covid19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registerpage extends AppCompatActivity {
    EditText fname, mdate_of_birth, mphone, memail, mpass, mconfirmpass ;
    Button msignup;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);

        fname = findViewById(R.id.name);
        mdate_of_birth = findViewById(R.id.dob);
        mphone = findViewById(R.id.phone_no);
        memail = findViewById(R.id.emailtxt);
        mpass = findViewById(R.id.passwordtxt);
        mconfirmpass = findViewById(R.id.confirm_password);
        msignup = findViewById(R.id.btnsignup);

        mAuth =  FirebaseAuth.getInstance();

        getSupportActionBar().setTitle("Covid-19 Information App");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        msignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = memail.getText().toString().trim();
                String password = mpass.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                  memail.setError("Email is required");
                  return;
                }
                if(TextUtils.isEmpty(password)){
                    mpass.setError("Password is required");
                    return;
                }
                if(password.length() < 6){
                    mpass.setError("Password must be greater than 6 characters");
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Registerpage.this, "User Created.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                        else {
                            Toast.makeText(Registerpage.this, "Error Occured" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
