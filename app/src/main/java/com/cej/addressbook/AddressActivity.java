package com.cej.addressbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Address2{
    // Member Variable ----------------------------------
    private String name;
    private String phone;
    private String email;

    // Constructor Method ----------------------------------
    public Address2(String name,String phone,String email){
        this.name=name;
        this.phone=phone;
        this.email=email;
    }

    // Getter / Setter ----------------------------------
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    // Custom Method ----------------------------------
    public String getInfo(){
        return this.name+" - "+this.phone+" - "+this.email;
    }
}


public class AddressActivity extends AppCompatActivity {
    // Member Variable ----------------------------------
    private final boolean D=true;
    private final String TAG="AddressActivity";
    private int clickid=100;

    // View Object ----------------------------------------
    private EditText name_ed,phone_ed,email_ed;
    private Button settingBTN;
    private ListView listview;


    // Data --------------------------------------------------
    private ArrayList<HashMap<String,String>> addressList=new ArrayList<>();
    private SimpleAdapter adapter;

    // Member Method - AppCompatActivity's override----------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // layout 보여주는
        setContentView(R.layout.address_layout);
        
        // 초기 메소드
        init();

        if(D) Log.i(TAG,"onCreate()");

    }
    // Member Method - Onclick------------------------------
    public void onClick(View v){
        switch (v.getId()){
            case R.id.addbtn:
                // 3개 editTxt 값 읽어서  Address 객체 생성 및 추가
                // (1) editTxt 값 입력 여부 (length가 0보다 크면 입력된 것)
                if (name_ed.getText().length()>0 && phone_ed.getText().length()>0 && email_ed.getText().length()>0){

                    // (2-1)Address 객체 생성 및 ArrayList 추가
                    HashMap<String,String> map2=new HashMap<>();

                    map2.put("name",name_ed.getText().toString());
                    map2.put("phone",phone_ed.getText().toString());
                    map2.put("email",email_ed.getText().toString());
                    addressList.add(map2);

                    Log.i(TAG,"addressList===>"+addressList);

                    // (3) edittext에 입력된 내용 삭제
                    initEXT();

                    // (4) 데이터 출력
                    adapter=new SimpleAdapter(this,addressList, R.layout.addressdata,new String[]{"name","phone","email"},new int[]{R.id.text1,R.id.textt2,R.id.text3});
                    listview.setAdapter(adapter);
                    Toast.makeText(this, "추가 완료", Toast.LENGTH_SHORT).show();
                }

                else{
                    // (2-2) 사용자에게 Toast 띄우기
                    Toast.makeText(this, R.string.add_msg, Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.deletebtn:
                // 가장 최근에 추가한 데이터 삭제
                if (addressList.size()>0) {
                    // 삭제 할 item 선택
                    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            clickid=(int)id;
                        }
                    });

                    if (clickid==100){
                        // 아이템이 선택되지 않았을 경우
                        Toast.makeText(this, "삭제할 아이템을 선택해주세요!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        addressList.remove(clickid);

                        // 데이터 출력
                        adapter=new SimpleAdapter(this,addressList, R.layout.addressdata,new String[]{"name","phone","email"},new int[]{R.id.text1,R.id.textt2,R.id.text3});
                        listview.setAdapter(adapter);
                        clickid=100;
                    }
                }
                else{
                    Toast.makeText(this, "삭제할 목록이 없습니다.", Toast.LENGTH_SHORT).show();
                }
                break;
                
            case R.id.settingBTN:
                Intent MoveINT=new Intent(AddressActivity.this,SettingActivity.class);
                startActivity(MoveINT);
                break;

        }

    }
    // Member Method - Custom------------------------------
    private void initEXT(){
        // edittext에 입력된 내용 삭제
        name_ed.setText("");
        phone_ed.setText("");
        email_ed.setText("");
    }
    private void init(){
        // XML View 객체
        name_ed=findViewById(R.id.name_ed);
        phone_ed=findViewById(R.id.phone_ed);
        email_ed=findViewById(R.id.email_ed);
        settingBTN=findViewById(R.id.settingBTN);
        
        listview=findViewById(R.id.listview);
        
        // ArrayList 초기 데이터
        HashMap<String,String> map=new HashMap<>();

        map.put("name","Cho");
        map.put("phone","010-9136-6343");
        map.put("email","dmswl_0311@naver.com");
        addressList.add(map);

        adapter=new SimpleAdapter(this,addressList, R.layout.addressdata,new String[]{"name","phone","email"},new int[]{R.id.text1,R.id.textt2,R.id.text3});

        listview.setAdapter(adapter);


    }
}