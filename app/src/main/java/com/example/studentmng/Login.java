package com.example.studentmng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener {

  TextView textView;
  TextView emailtxt,passwordtxt;
  Button loginbtn;
  FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textView=findViewById(R.id.signUp);
        textView.setOnClickListener(this);
        emailtxt=findViewById(R.id.email);
        passwordtxt=findViewById(R.id.password);
        loginbtn=findViewById(R.id.log);
        loginbtn.setOnClickListener(this);

        mAuth=FirebaseAuth.getInstance();
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });


    }
    public void userlogin(){

        String email = emailtxt.getText().toString().trim();
        String password = passwordtxt.getText().toString().trim();

        if (email.isEmpty()){
            emailtxt.setError("Email is required");
            emailtxt.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailtxt.setError("Please enter a valid email");
            emailtxt.requestFocus();
            return;
        }
        if (password.isEmpty()){
            passwordtxt.setError("Password is required");
            passwordtxt.requestFocus();
            return;
        }
        if (password.length()< 6){
            passwordtxt.setError("You should enter 6 caracters at least");
            passwordtxt.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                   openActivity();
                }else {
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void openActivity(){
        Intent i = new Intent(this,Home.class);

        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signUp:
                startActivity(new Intent(this,SignUp.class));
                break;
           /* case R.id.log:
                userlogin();
                break;*/
        }
    }
}
