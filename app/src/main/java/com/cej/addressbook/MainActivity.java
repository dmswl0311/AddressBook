package com.cej.addressbook;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

// Address ArrayList클래스
class Address{
    String name,phone,email;

    public Address(String name,String phone,String email){
        this.name=name;
        this.phone=phone;
        this.email=email;
    }
    public String getName(){
        return name;
    }
    public String getPhone(){
        return phone;
    }
    public String getEmail(){ return email;}

}

public class MainActivity extends AppCompatActivity {
    private LinearLayout linearLAY,textviewLAY,linear;
    private EditText name_edit,phone_edit,email_edit;
    
    // ArrayList 생성
    ArrayList<Address> addressList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // 초기화
        linearLAY=findViewById(R.id.linearLAY);
        textviewLAY=findViewById(R.id.textviewLAY);
        linear=findViewById(R.id.linear);

        // 입력받은 이름, 전화번호, 이메일
        name_edit=findViewById(R.id.name_edit);
        phone_edit=findViewById(R.id.phone_edit);
        email_edit=findViewById(R.id.email_edit);
        
        // 초기 데이터 메소드 실행
        first();

    }

    // 초기에 저장된 데이터 메소드
    public void first(){
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(30, 20, 30, 0);

        // 초기 데이터 저장
        addressList.add(new Address("조은지","010-9136-6343","dmswl_0311@naver.com"));
        addressList.add(new Address("홍길동","010-1234-5678","gildong@naver.com"));

        // textview 갱신
        for (int i=0; i<addressList.size();i++){
            TextView view1=new TextView(this);
            view1.setText(addressList.get(i).getName()+"　"+addressList.get(i).getPhone()+"　"+addressList.get(i).getEmail());
            textviewLAY.addView(view1,params);
        }
    }

    // 버튼을 클릭했을 때 실행되는 메소드
    public void onClick(View v){

        // 레이아웃 설정
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(30, 20, 30, 0);

        if (v.getId()==R.id.addBtn){
            // 추가 버튼을 눌렀을 때

            // name, phone, email이 입력되지 않았을 때 default 값
            if (name_edit.getText().length()==0){
                name_edit.setText("name");
            }
            if (phone_edit.getText().length()==0){
                phone_edit.setText("010-0000-0000");
            }
            if (email_edit.getText().length()==0){
                email_edit.setText("email@naver.com");
            }

            // Address 클래스에 추가
            Address list1=new Address(name_edit.getText().toString(),phone_edit.getText().toString(),email_edit.getText().toString());
            addressList.add(list1);

            // textview
            TextView view1=new TextView(this);
            view1.setText(addressList.get(addressList.size()-1).getName()+"　"+addressList.get(addressList.size()-1).getPhone()+"　"+addressList.get(addressList.size()-1).getEmail());

            // list 갱신
            textviewLAY.addView(view1,params);

            // name,phone, email 초기화
            name_edit.setText("");
            phone_edit.setText("");
            email_edit.setText("");

            //토스트 메세지
            Toast.makeText(v.getContext(),"연락처 추가",Toast.LENGTH_LONG).show();

        }


        if (v.getId()==R.id.delBtn){
            // 삭제 버튼을 눌렀을 때

            if (addressList.size()>0){
                // list에 있는 원소 삭제
                addressList.remove(addressList.size()-1);
                // textview 초기화
                textviewLAY.removeAllViews();
                // textview 갱신
                for (int i=0; i<addressList.size();i++){
                    TextView view1=new TextView(this);
                    view1.setText(addressList.get(i).getName()+"　"+addressList.get(i).getPhone()+"　"+addressList.get(i).getEmail());
                    textviewLAY.addView(view1,params);
                }
            }
            else{
                //토스트 메세지
                Toast.makeText(v.getContext(),"삭제가능한 목록이 없습니다!",Toast.LENGTH_LONG).show();
            }


        }
        if (v.getId()==R.id.viewBtn){
            // textview 보여주기
            Toast.makeText(v.getContext(),"삭제가능한 목록이 없습니다!",Toast.LENGTH_LONG).show();
        }
    }
}