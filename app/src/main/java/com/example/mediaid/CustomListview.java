package com.example.mediaid;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomListview extends ArrayAdapter<String>{

    private String[] fruitname;
    private String[] desc;
    private String[] rating;
    private String[] phone;
    private String[] email;

    private Activity context;

    //constructor setting fruitname,description and rating values to private string arrays
    public CustomListview(@NonNull Activity context,String[] fruitname,String[] desc,String[] rating,String[] phone,String[] email) {
        super(context, R.layout.custom_hospital_lv,fruitname);
        this.context=context;
        this.fruitname=fruitname;
        this.desc=desc;
        this.rating=rating;
        this.phone=phone;
        this.email=email;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //optimize the listview performance
        View r=convertView;

        ViewHolder viewHolder=null;
        //when new row is created in listview if() is executed
        if(r==null)
        {
            //convert .xml file to corresponding java object with getLayout method
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.custom_hospital_lv,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);                   //stores view
        }
        else {
            viewHolder=(ViewHolder)r.getTag();
        }

        viewHolder.tvw1.setText(fruitname[position]);
        viewHolder.tvw2.setText(desc[position]);
        viewHolder.tvw3.setText(rating[position]);
        viewHolder.tvw4.setText(phone[position]);
        viewHolder.tvw5.setText(email[position]);

        return r;
    }

    class ViewHolder
    {
        TextView tvw1,tvw2,tvw3,tvw4,tvw5;
        ViewHolder(View v)
        {
            tvw1=v.findViewById(R.id.textview);    //fruit
            tvw2=v.findViewById(R.id.textview2);   //desc
            tvw3=v.findViewById(R.id.textview3);   //rating
            tvw4=v.findViewById(R.id.phoneNumber); //phoneNumber
            tvw5=v.findViewById(R.id.email);       //email
        }

    }

}