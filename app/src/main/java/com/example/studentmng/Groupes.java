package com.example.studentmng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Groupes extends AppCompatActivity {
    CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;
    Button btn;
    TextView textView;
    FirebaseDatabase database;
  DatabaseReference reff;
   String M1=new String("ANALYSE 1");
    String M2=new String("ALGORITHMEQUE");
    String M3=new String("ALGEBRE");
    String M4=new String("SYSTEME D'EXPLOITATION");
    String M5=new String("ARCHITECTURE DES ORDINATEURS");
    String M6=new String("BUREAUTIQUE ET WEB");
    String M7=new String("FRANÇAIS");
    String M8=new String("ANGLAIS");
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupes);
        c1=findViewById(R.id.c1);
        c2=findViewById(R.id.c2);
        c3=findViewById(R.id.c3);
        c4=findViewById(R.id.c4);
        c5=findViewById(R.id.c5);
        c6=findViewById(R.id.c6);
        c7=findViewById(R.id.c7);
        c8=findViewById(R.id.c8);
        c9=findViewById(R.id.c9);
        c10=findViewById(R.id.c10);
        btn=findViewById(R.id.b1);

       database=FirebaseDatabase.getInstance();
       // reff= FirebaseDatabase.getInstance().getReference().child("Users").child("MODULES");
      //  reff=database.getReference().child("Years").child("1CPI");
        reff =database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        textView=findViewById(R.id.module);
        Intent intent=getIntent();
        String text= intent.getStringExtra(CPI1.EXTRA_TEXT);
        textView.setText(text);


          //  reff=database.getReference().child("Years").child("1CPI").child("ANALYSE 1");
            c1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    reff.push().setValue("Groupe 1");
                }

            });
            c1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    reff.push().setValue("Groupe 1");
                }

            });
            c2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    reff.push().setValue("Groupe 2");
                }

            });
            c3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    reff.push().setValue("Groupe 3");
                }

            });
            c4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    reff.push().setValue("Groupe 4");
                }

            });
            c5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    reff.push().setValue("Groupe 5");
                }

            });
            c6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    reff.push().setValue("Groupe 6");
                }

            });
            c7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    reff.push().setValue("Groupe 7");
                }

            });
            c8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    reff.push().setValue("Groupe 8");
                }

            });





          /*  if (c1.isChecked()){

              reff=FirebaseDatabase.getInstance().getReference().child("ANALYSE 1");
              reff.push().setValue("Groupe 1");

            }*/
            ;
       


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }
    public void openActivity(){
        Intent inten= new Intent(this,Home.class);
        startActivity(inten);
    }

}
