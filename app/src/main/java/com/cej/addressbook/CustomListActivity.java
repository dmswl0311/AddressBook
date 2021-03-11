package com.cej.addressbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomListActivity extends AppCompatActivity {
    // Log variable ---------------------------------------------------------
    private final boolean D=true;
    private final String TAG="CustomListActivity";

    // xml variable ---------------------------------------------------------
    private ListView listView;

    // data variable --------------------------------------------------------
    private ArrayList<ItemData> datArrays;
    private ItemDataAdapter adapter;

    // Member Method - override ---------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address_layout);
        init();
    }

    // Member Method - Custom -----------------------------------------------
    private void init(){
        listView=findViewById(R.id.listview);

        // Data  준비
        datArrays=new ArrayList<ItemData>();
        datArrays.add(new ItemData("TEST","010","@naver.com",R.drawable.test));

        // adapter 만들기
        adapter=new ItemDataAdapter(this,R.layout.item_data,datArrays);

        // adapter 붙이기
        listView.setAdapter(adapter);

    }
}