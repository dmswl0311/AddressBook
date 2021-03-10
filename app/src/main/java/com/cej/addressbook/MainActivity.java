package com.cej.addressbook;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import android.content.DialogInterface;
import android.os.Bundle;
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
        params.setMargins(30, 30, 30, 0);

        // 초기 데이터 저장
        addressList.add(new Address("조은지","010-9136-6343","dmswl_0311@naver.com"));
        addressList.add(new Address("홍길동","010-1234-5678","gildong@naver.com"));

        // textview 갱신
        for (int i=0; i<addressList.size();i++){
            TextView view1=new TextView(this);
            view1.setId(addressList.size()+1);
            view1.setText("이름: "+addressList.get(i).getName()+"　"+"전화번호: "+addressList.get(i).getPhone()+"　"+"이메일: "+addressList.get(i).getEmail());
            textviewLAY.addView(view1,params);
        }
    }

    // 버튼을 클릭했을 때 실행되는 메소드
    public void onClick(View v){

        // 레이아웃 설정
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(30, 30, 30, 0);

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
            view1.setText("이름: "+addressList.get(addressList.size()-1).getName()+"　"+"전화번호: "+addressList.get(addressList.size()-1).getPhone()+"　"+"이메일: "+addressList.get(addressList.size()-1).getEmail());
            view1.setId(addressList.size()+1);

            // list 갱신
            textviewLAY.addView(view1,params);

            // name,phone, email 초기화
            name_edit.setText("");
            phone_edit.setText("");
            email_edit.setText("");

            //토스트 메세지
            Toast.makeText(v.getContext(),"연락처 추가 완료",Toast.LENGTH_LONG).show();

        }


        if (v.getId()==R.id.delBtn){
            // 삭제 버튼을 눌렀을 때
            // Dialog 창으로 삭제할건지 말건지 한번 더 확인
            if (addressList.size()>0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("확인창").setMessage("삭제하시겠습니까?");

                // 취소 눌렀을 때
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
                // 삭제 눌렀을 때
                builder.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // list에 있는 원소 삭제
                        addressList.remove(addressList.size() - 1);
                        // textview 초기화
                        textviewLAY.removeAllViews();
                        // textview 갱신
                        for (int i = 0; i < addressList.size(); i++) {
                            TextView view1 = new TextView(MainActivity.this);
                            view1.setText("이름: " + addressList.get(i).getName() + "　" + "전화번호: " + addressList.get(i).getPhone() + "　" + "이메일: " + addressList.get(i).getEmail());
                            textviewLAY.addView(view1, params);
                        }
                    }
                });
                AlertDialog alterDialog = builder.create();
                alterDialog.show();
            }
            else{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("확인창").setMessage("삭제할 목록이 없습니다!");
                AlertDialog alterDialog = builder.create();
                alterDialog.show();
            }

        }
        if (v.getId()==R.id.viewBtn){
            // textview 보여주기
            Toast.makeText(v.getContext(),"보기 누름",Toast.LENGTH_LONG).show();
        }
    }
}