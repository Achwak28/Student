package com.example.studentmng;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView textView;
    ImageView img;

    String[] Items={"1CPI","2CPI","1CS","2CS_SIW","2CS_ISI"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textHello);
        img=findViewById(R.id.imageMenu);

        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter(this,Items));


    }

   /* private void setSupportActionBar(Toolbar toolbar) {
    }*/
}
