package com.cej.addressbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SettingActivity extends AppCompatActivity {
    //Member Variable--------------------------------------
    private final boolean D=true;
    private final String TAG="SettingActivity";

    private LinearLayout setLAY;
    private EditText id_edit;
    private Button modBTN,saveBTN,cancelBTN,finishBTN;
    private RadioGroup radioGroup;
    private RadioButton radioBTN1,radioBTN2,radioBTN3;
    private CheckBox checkBox1,checkBox2;
    private String radio_txt,result="",result2="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_layout);

        //Member Variable 초기화--------------------------------------
        setLAY=findViewById(R.id.setLAY);
        id_edit=findViewById(R.id.id_edit);
        modBTN=findViewById(R.id.modBTN);
        saveBTN=findViewById(R.id.saveBTN);
        cancelBTN=findViewById(R.id.saveBTN);
        finishBTN=findViewById(R.id.finishBTN);
        radioGroup=findViewById(R.id.radioGroup);
        radioBTN1=findViewById(R.id.radioBTN1);
        radioBTN2=findViewById(R.id.radioBTN2);
        radioBTN3=findViewById(R.id.radioBTN3);
        checkBox1=findViewById(R.id.checkBox1);
        checkBox2=findViewById(R.id.checkBox2);

        Intent moveINT=getIntent();

        // 라디오 버튼
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radio_txt=((RadioButton)findViewById(checkedId)).getText().toString();
            }
        });

        // 체크 박스
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true){
                    result="Auto save";
                }

            }
        });
        // 체크 박스 2
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true){
                    result2="Auto connect WiFi";
                }
            }
        });

    }

    //Member Method--------------------------------------
    public void click(View v){
        // 버튼 클릭 할 때 실행되는 메소드

        switch(v.getId()){
            case (R.id.modBTN):
                id_edit.setFocusable(true);
                id_edit.setText("");
                break;
            case (R.id.saveBTN):
                Log.i(TAG,"Id : "+id_edit.getText()+" Thema : "+radio_txt+" Select : "+result+" "+result2);
                id_edit.setFocusable(false);
                break;
            case (R.id.cancelBTN):
                checkBox1.setChecked(false);
                checkBox2.setChecked(false);
                radioBTN1.setChecked(false);
                radioBTN2.setChecked(false);
                radioBTN3.setChecked(false);
                break;
            case R.id.finishBTN:
                finish();
                break;
        }
    }
}