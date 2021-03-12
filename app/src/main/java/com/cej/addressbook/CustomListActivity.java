package com.cej.addressbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CustomListActivity.this,"클릭함",Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.nameTXT:
            case R.id.phoneTXT:
            case R.id.emailTXT:
                Log.i(TAG, "TEXT "+((TextView)v).getText());
                break;
            case R.id.icon:
                Log.i(TAG, "IMAGE");

                break;
        }
    }
}