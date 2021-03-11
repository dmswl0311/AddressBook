package com.cej.addressbook;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// ListView item 표시해주는 XML Layout ==> java object로 만들어서 저장
public class ItemDataHolder {
    public ImageView icon;
    public TextView nameTXT;
    public TextView phoneTXT;
    public TextView emailTXT;
    
    public ItemDataHolder(View root){
        this.icon=root.findViewById(R.id.icon);
        this.nameTXT=root.findViewById(R.id.nameTXT);
        this.phoneTXT=root.findViewById(R.id.phoneTXT);
        this.emailTXT=root.findViewById(R.id.emailTXT);


    }
}
