package com.cej.addressbook;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ItemDataAdapter extends ArrayAdapter<ItemData> {

    //Member Variable------------------------------
    private Context context;
    private int layoutResId;
    private ArrayList<ItemData> dataList;

    // Constructor Method-----------------------------
    public ItemDataAdapter(@NonNull Context context, int resource, @NonNull ArrayList<ItemData> objects) {

        super(context, resource, objects);
        this.context=context;
        this.layoutResId=resource;
        this.dataList=objects;
    }

    // Override Method-----------------------------
    @Override
    public int getCount() {
        return dataList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Data ==> XML Layout 넣어서 보이고 사용할 수 있도록 객체 생성
        // (1) item Layout xml ==> java 객체로 변환해야 함
        if (convertView==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutResId,null);

            ItemDataHolder holder= new ItemDataHolder(convertView);
            convertView.setTag(holder);
        }
        ItemDataHolder holder = (ItemDataHolder) convertView.getTag();

        // (2) item Layout's view 객체 가져오기
//        ImageView icon=convertView.findViewById(R.id.icon);
//        TextView nameTXT=convertView.findViewById(R.id.nameTXT);
//        TextView phoneTXT=convertView.findViewById(R.id.phoneTXT);
//        TextView emailTXT=convertView.findViewById(R.id.phoneTXT);  ==> holder class 에서 진행

        TextView nameTXT=holder.nameTXT;
        TextView phoneTXT=holder.phoneTXT;
        TextView emailTXT=holder.emailTXT;
        ImageView icon=holder.icon;


        // (3) Data 준비
        final ItemData item=dataList.get(position);

        // (4) Layout <--> Data
        nameTXT.setText(item.getName());
        phoneTXT.setText(item.getPhone());
        emailTXT.setText(item.getEmail());

        // icon 사이즈 조절
        Bitmap bitmap= BitmapFactory.decodeResource(context.getResources(),item.getImgResId());
        bitmap=bitmap.createScaledBitmap(bitmap,300,300,true);
        icon.setImageBitmap(bitmap);

        return convertView;

    }

}
