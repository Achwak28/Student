package com.example.studentmng;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import io.opencensus.tags.Tag;

import static android.widget.Toast.LENGTH_SHORT;

public class ViewList extends AppCompatActivity {

    DatabaseHelper myDB;
    ArrayList<User> userlist;
    ListView listView;
    User user;
    String test1,test2,pres,name;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents_layout);
        listView = findViewById(R.id.listview);

        myDB = new DatabaseHelper(this);
        userlist = new ArrayList<>();
        Cursor data = myDB.getListContents();
        int numRows = data.getColumnCount();
        if (numRows == 0) {
            Toast.makeText(ViewList.this, "There is nothing in this database !", LENGTH_SHORT).show();
        } else {

            while (data.moveToNext()) {
                user = new User(data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5));

                userlist.add(user);

            }
            ThreeColumn_ListAdapter adapter = new ThreeColumn_ListAdapter(this, R.layout.list_adapter_view, userlist);

            listView.setAdapter(adapter);


        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                User selectedUser= (User) parent.getItemAtPosition(position);

                String name= selectedUser.getFirstname();
                int item_id=myDB.getItemid(name);



                Intent intent= new Intent(ViewList.this,EditData.class);

                intent.putExtra("id",item_id);

             //  intent.putExtra("id",selectedUser.getID());


              toastMessage("we're going to activity editdata");


                // il reste 3 user must have an id atribute

                startActivity(intent);
            }
        });



    }




   /* public void onResume() {
        super.onResume();
        userlist = new ArrayList<>();
        Cursor data = myDB.getListContents();
        int numRows = data.getColumnCount();
        if (numRows == 0) {
            Toast.makeText(ViewList.this, "There is nothing in this database !", LENGTH_SHORT).show();
        } else {

            while (data.moveToNext()) {
                user = new User(data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5));

                userlist.add(user);

            }
            ThreeColumn_ListAdapter adapter = new ThreeColumn_ListAdapter(this, R.layout.list_adapter_view, userlist);

            listView.setAdapter(adapter);

        }
    }*/
   public void toastMessage(String message){
       Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

   }

}
