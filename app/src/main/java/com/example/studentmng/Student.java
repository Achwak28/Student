package com.example.studentmng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;



public class Student extends AppCompatActivity {
    EditText firstname,lastname,favfood,pres;
    Button btnAdd,btnview;
    DatabaseHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        favfood=findViewById(R.id.etfav);
        firstname=findViewById(R.id.etfirst);
        lastname=findViewById(R.id.etlastn);
        pres=findViewById(R.id.pres);
        //
        btnAdd=findViewById(R.id.btnadd);
        btnview=findViewById(R.id.btnview);
        myDB= new DatabaseHelper(this);


        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Student.this, ViewList.class);
                startActivity(i);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fName = firstname.getText().toString();
                String lName = lastname.getText().toString();
                String ffood = favfood.getText().toString();
               String note;
                note = pres.getText().toString();
               /* int notef=Integer.parseInt(lName)+Integer.parseInt(ffood)+Integer.parseInt(note);
                String NoteCC=String.valueOf(notef);*/



                if (fName.length() !=0 && lName.length() !=0 && ffood.length() != 0 && note.length() !=0){
                    AddData(fName,lName,ffood,note);
                    firstname.setText("");
                    lastname.setText("");
                    favfood.setText("");
                    pres.setText("");


                }else{
                    Toast.makeText(Student.this, "You must put something in the text fields !", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
    public void AddData(String firstname, String lastname, String favfood, String note){
        boolean insertdata = myDB.addData(firstname,lastname,favfood,note);

        if (insertdata ){
           Toast.makeText(Student.this, "Data inserted successfully !", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(Student.this, "Something Went Wrong !!", Toast.LENGTH_SHORT).show();
        }
    }

    }

