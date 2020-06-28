package com.example.studentmng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {
   FirebaseDatabase db;
   DatabaseReference reff;

    FirebaseAuth mAuth;
    TextView name,information;
    Button btnshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name=findViewById(R.id.username);
        information=findViewById(R.id.information);
        btnshow=findViewById(R.id.show);
        db=FirebaseDatabase.getInstance();
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff=db.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
              //  reff=db.getReference("Groupe");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                      //  Iterable<DataSnapshot> inf=dataSnapshot.getChildren();
                       // String nam= databaseList().toString();
                        String inform= dataSnapshot.child("fullname").getValue().toString();
                        String informations=dataSnapshot.getValue().toString();

                        name.setText(inform);

                        information.setText(informations);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });


        mAuth=FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();


     /*   save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  saveUserInformation();
            }
        });

    }
    public void saveUserInformation(){
        String displayName=editText.getText().toString();

        if (displayName.isEmpty()){
            editText.setError("Name required");
            editText.requestFocus();
            return;
        }*/




        }

    }



