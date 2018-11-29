package com.sheygam.masa_2018_g1_29_11_18_cw_part2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView myList;
    private MyAdapter adapter;
    private Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList = findViewById(R.id.my_list);
        adapter = new MyAdapter();
        myList.setAdapter(adapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user = (User) adapter.getItem(position);

                Toast.makeText(MainActivity.this,user.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.add_btn){
            adapter.addUser(new User("vasya","vasya@mail.com"));
        }
    }
}
