package com.example.studentmng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    EditText email,password,fulln;
    TextView textview;
    Button btn;
    private FirebaseAuth mAuth;
    FirebaseDatabase dababase;
    DatabaseReference reff;
    String fn;
    public static final String EXTRA_TEXT = "FullName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        textview=findViewById(R.id.login);
        btn=findViewById(R.id.btnUp);
        fulln=findViewById(R.id.fullname);
      //  fn = fulln.getText().toString();
        String fullname=fulln.getText().toString().trim();


        dababase=FirebaseDatabase.getInstance();
        reff=dababase.getReference().child("Users");
        reff.push().setValue(fn);

        btn.setOnClickListener(this);
       textview.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });


    }
    private void registerUser(){
        String em = email.getText().toString().trim();
        String passw = password.getText().toString().trim();
        final String fullname=fulln.getText().toString().trim();




        if (em.isEmpty()){
            email.setError("Email is required");
            email.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(em).matches()){
            email.setError("Please enter a valid email");
            email.requestFocus();
            return;
        }
        if (passw.isEmpty()){
            password.setError("Password is required");
            password.requestFocus();
            return;
        }
        if (passw.length()< 6){
            password.setError("You should enter 6 caracters at least");
            password.requestFocus();
            return;
        }
        if (fullname.isEmpty()){
            fulln.setError("Full Name is required");
            fulln.requestFocus();
            return;}

        mAuth.createUserWithEmailAndPassword(em,passw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    UserInformation fulname=new UserInformation(fullname);
                    FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(fulname).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(getApplicationContext(),"User Registered Successfull",Toast.LENGTH_SHORT).show();
                            openActivity();


                        }
                    });

                } else{
                    if (task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(),"You are already registered",Toast.LENGTH_SHORT).show();

                    }


                }
            }
        });

    }
    public void openActivity(){
        Intent i = new Intent(this,MainActivity.class);

       // i.putExtra(EXTRA_TEXT,);
        startActivity(i);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
          /*  case R.id.btnUp:
                registerUser();
                startActivity(new Intent(this,MainActivity.class));
                break;*/
            case R.id.login:
                startActivity(new Intent(this,Login.class));
                break;
        }

    }
}
