package com.sheygam.masa_2018_g1_29_11_18_cw_part2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {

    private List<User> users = new ArrayList<>();

    public MyAdapter() {
        for (int i = 0; i < 100; i++) {
            users.add(new User("User " + i, "user"+i+"@mail.com"));
        }
    }


    public void addUser(User user){
        users.add(2,user);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.my_row, parent,false);
        }
        User user = users.get(position);

        TextView nameTxt = convertView.findViewById(R.id.name_txt);
        TextView emailTxt = convertView.findViewById(R.id.email_txt);

        nameTxt.setText(user.getName());
        emailTxt.setText(user.getEmail());

        return convertView;
    }
}
