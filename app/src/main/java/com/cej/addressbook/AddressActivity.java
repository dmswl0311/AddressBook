package com.cej.addressbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

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
        setContentView(R.layout.address_layout);
    }
    // Member Method - Custom------------------------------
}