package com.example.covid19;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText mEmail, mPassword;
    Button login;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    TextView createaccount, fgtpassword;
    private static final String TAG = "SessionManager";
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        mEmail = findViewById(R.id.emailTxt);
        mPassword = findViewById(R.id.passwordTxt);
        login = findViewById(R.id.login);
        progressBar = findViewById(R.id.progressBar);
        createaccount = findViewById(R.id.create_account);
        fgtpassword = findViewById(R.id.fogotpassword);

        getSupportActionBar().setTitle("Covid-19 Information App");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString();
                String pwd = mPassword.getText().toString();
                if (TextUtils.isEmpty(email)){
                    mEmail.setError("Please Enter Your Email");
                    return;
                }
                if (TextUtils.isEmpty(pwd)){
                    mPassword.setError("Please Enter Your Password");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                mAuth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),CovidStats.class));
                        }
                        else {
                            Toast.makeText(MainActivity.this,"Error Occured" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Registerpage.class));
            }
        });

        fgtpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ForgotPassword.class));
            }
        });


    }

}



