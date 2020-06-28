package com.example.studentmng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Home extends AppCompatActivity {
    TextView textHello,textUser,textTrending;
    ImageView Imagemenu;
    LinearLayout layoutGoal,Finance,health,comfort;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textHello = findViewById(R.id.textHello);
        textTrending = findViewById(R.id.textTrending);
        textUser = findViewById(R.id.textUser);
        Imagemenu = findViewById(R.id.imageMenu);
        layoutGoal = findViewById(R.id.layoutGoal);
        Finance = findViewById(R.id.layoutFinance);
        health = findViewById(R.id.layoutHealth);
        comfort = findViewById(R.id.layoutComfort);


        Finance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });
        layoutGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openActivity();
            }
        });
    }
    public void openActivity(){
        Intent intent = new Intent(this,Student.class);
        startActivity(intent);
    }
   /* public void openActivity2(){
        Intent intent = new Intent(this,Student.class);
        startActivity(intent);
    }*/
  public void openActivity1(){
        Intent intent = new Intent(this,Profile.class);
        startActivity(intent);
    }}

