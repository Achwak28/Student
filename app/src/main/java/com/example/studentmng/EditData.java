package com.example.studentmng;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditData extends AppCompatActivity {
    private static final String TAG ="EditDataActivity";
     Button btnsave,btndelete;
     TextView name,test1,test2,presentation;

     DatabaseHelper mDatabaseHelper;
     String selectedName,seltest1,seltest2,selpres;
     int selectedID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);
        btnsave=findViewById(R.id.btnsave);
        btndelete=findViewById(R.id.btndelete);
        name=findViewById(R.id.etname);
        test1=findViewById(R.id.ettest1);
        test2=findViewById(R.id.ettest2);
        presentation=findViewById(R.id.pres);

        mDatabaseHelper=new DatabaseHelper(this);
        Intent received= getIntent();

        selectedID=received.getIntExtra("id",0);
        User user=mDatabaseHelper.getUserbyId(selectedID);

        selectedName=user.getFirstname();
        seltest1=user.getLastname();
        seltest2=user.getFavfood();
        selpres=user.getNote();
        String notef=user.getNoteCc();

        /*selectedname.setText(user.getFirstname());
        test1.setText(user.getLastname());
        test2.setText(user.getFavfood());
        presentation.setText(user.getNote());*/
        //selectedID=received.getIntExtra("id",- 1);



        name.setText(selectedName);
        test1.setText(seltest1);
        test2.setText(seltest2);
        presentation.setText(selpres);


        /// delete user
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert();
            }
        });

    }
    public void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
    public void showAlert(){
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("Confirmation").setMessage("Are You Sure ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /// delete user
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
        AlertDialog dialog = alertBuilder.create();
        dialog.show();

    }
}
