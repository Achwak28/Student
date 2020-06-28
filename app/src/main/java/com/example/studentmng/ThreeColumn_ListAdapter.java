package com.example.studentmng;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ThreeColumn_ListAdapter extends ArrayAdapter<User> {

  private   LayoutInflater inflater;
    private ArrayList<User> users;
    private int viewRessourceId;

    public  ThreeColumn_ListAdapter(Context context, int textViewRessource, ArrayList<User> users){
        super(context,textViewRessource,users);
        this.users=users;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        viewRessourceId= textViewRessource;

    }
    public View getView(int position, View convertView, ViewGroup parents){
        convertView= inflater.inflate(viewRessourceId,null);

        User user= users.get(position);
        if (user != null){
            TextView firstname = convertView.findViewById(R.id.textfirstname);
            TextView lastname = convertView.findViewById(R.id.textlastname);
            TextView favfood = convertView.findViewById(R.id.textfavfood);
            TextView note= convertView.findViewById(R.id.note);
           TextView noteCc=convertView.findViewById(R.id.textnoteFinal);

            if (firstname != null){
                firstname.setText((user.getFirstname()));
            }
            if (lastname != null){
                lastname.setText((user.getLastname()));
            }
            if (favfood != null){
                favfood.setText((user.getFavfood()));
            }
            if (note != null){
                note.setText((user.getNote()));}
            if (noteCc != null){
                noteCc.setText((user.getNoteCc()));}


        }
        return convertView;
    }


}
