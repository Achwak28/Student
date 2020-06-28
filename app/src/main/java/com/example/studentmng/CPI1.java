package com.example.studentmng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CPI1 extends AppCompatActivity  {
    Button b3, b4, b5, b6, b7, b8, b9, b10;
    TextView textView;
    ImageView img;
    DatabaseReference reff;
    String module;
    FirebaseDatabase database;

   // Intent intent = new Intent(this,Groupes.class);
    public static final String EXTRA_TEXT = "Groupe";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_p_i1);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        b10 = findViewById(R.id.button10);
        img = findViewById(R.id.imageMenu);
        database= FirebaseDatabase.getInstance();
        //reff= FirebaseDatabase.getInstance().getReference().child("Users").child("MODULES");
       // reff=database.getReference().child("Years").child("1CPI");
        reff =database.getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        textView = findViewById(R.id.textHello);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              module= "ANALYSE 1";

                openActivity();

                 reff.push().setValue("ANALYSE 1");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* String module= new String("ALGORITHMEQUE");
                intent.putExtra(EXTRA_TEXT,module);*/
               module="ALGORITHMEQUE";
                openActivity();
                reff.push().setValue("ALGORITHMEQUE");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* String module = new String("ALGEBRE");
                intent.putExtra(EXTRA_TEXT,module);*/
               module="ALGEBRE";
                openActivity();
                reff.push().setValue("ALGEBRE");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  String module = new String("SYSTEME D'EXPLOITATION");
                intent.putExtra(EXTRA_TEXT,module);*/
                module="SYSTEME D'EXPLOITATION";
                openActivity();
                reff.push().setValue("SYSTEME D'EXPLOITATION");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  String module= new String("ARCHITECTURE DES ORDINATEURS 1");
                intent.putExtra(EXTRA_TEXT,module);*/
                module="ARCHITECTURE DES ORDINATEURS 1";
                openActivity();
                reff.push().setValue("ARCHITECTURE DES ORDINATEURS 1");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* String module= new String("BUREAUTIQUE ET WEB");
                intent.putExtra(EXTRA_TEXT,module);*/
                module="BUREAUTIQUE ET WEB";
                openActivity();
                reff.push().setValue("BUREAUTIQUE ET WEB");

            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* String module =new String("FRANÇAIS");
                intent.putExtra(EXTRA_TEXT,module);*/
                module="FRANÇAIS";
                openActivity();
                reff.push().setValue("FRANÇAIS");
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  String module =new String("ANGLAIS");
                intent.putExtra(EXTRA_TEXT,module);*/
                module="ANGLAIS";
                openActivity();
                reff.push().setValue("ANGLAIS");
            }
        });
    }


    public void openActivity(){



      Intent intent=new Intent(this,Groupes.class);
      intent.putExtra(EXTRA_TEXT,module);


        startActivity(intent);



    }
}
