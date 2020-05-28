package com.example.studentmng;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static android.widget.Toast.LENGTH_SHORT;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    String[] items;
    public Adapter(Context context,String[] items){
        this.context=context;
        this.items=items;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View row=inflater.inflate(R.layout.row,parent,false);
        Item item=new Item(row);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((Item)holder).t.setText(items[position]);
       ((Item)holder).btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if (position==0){
                  Intent intent = new Intent(v.getContext(),CPI1.class);
                  context.startActivity(intent);
              }
                if (position==1){
                    Intent intent = new Intent(v.getContext(),CPI2.class);
                    context.startActivity(intent);
                }
                if (position==2){
                    Intent intent = new Intent(v.getContext(),CS1.class);
                    context.startActivity(intent);
                }
                if (position==3){
                    Intent intent = new Intent(v.getContext(),SIW.class);
                    context.startActivity(intent);
                }
                if (position==4){
                    Intent intent = new Intent(v.getContext(),ISI.class);
                    context.startActivity(intent);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public class Item extends RecyclerView.ViewHolder{
        TextView textView;
      TextView t;
      Button btn;
        public Item(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.prefix);
           t=itemView.findViewById(R.id.y1);
            btn=itemView.findViewById(R.id.button);


        }
    }
}
