package com.cej.addressbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

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

    // View Object ----------------------------------------
    private EditText name_ed,phone_ed,email_ed;
    private TextView addressTXT;

    // Data --------------------------------------------------
    private ArrayList<Address2> addressList=new ArrayList<>();

    // Member Method - AppCompatActivity's override----------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // layout 보여주는
        setContentView(R.layout.address_layout);

        // XML View 객체
        name_ed=findViewById(R.id.name_ed);
        phone_ed=findViewById(R.id.phone_ed);
        email_ed=findViewById(R.id.email_ed);

        addressTXT=findViewById(R.id.addressTXT);

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
                    addressList.add(new Address2(name_ed.getText().toString(),
                            phone_ed.getText().toString(),
                            email_ed.getText().toString()));

                    Log.i(TAG,"add===>"+addressList.size());

                    // (3) edittext에 입력된 내용 삭제
                    initEXT();

                    // (4) TextView 데이터 출력
                    String data="";
                    for (int i=0; i<addressList.size(); i++) {
                        data += addressList.get(i).getInfo() + "\n";
                    }
                    if(data.length()>0){
                        addressTXT.setText(data);
                    }
                    else{
                        addressTXT.setText(R.string.nothing);
                    }
                }

                else{
                    // (2-2) 사용자에게 Toast 띄우기
                    Toast.makeText(this, R.string.add_msg, Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.deletebtn:
                // 가장 최근에 추가한 데이터 삭제
                if (addressList.size()>0) {

                    Log.i(TAG,"delete 버튼 클릭");

                    addressList.remove(addressList.size() - 1);

                    // TextView 데이터 출력
                    String datas = "";
                    for (int i = 0; i < addressList.size(); i++){
                        datas += addressList.get(i).getInfo() + "\n";
                    }
                    addressTXT.setText(datas);
                }
                else{
                    Toast.makeText(this, R.string.nothing, Toast.LENGTH_LONG).show();
                }
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
}