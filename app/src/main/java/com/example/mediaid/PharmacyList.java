package com.example.mediaid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextClock;
import android.widget.TextView;

public class PharmacyList extends  AppCompatActivity{
    int[] IMAGES = {R.drawable.hospital_logo1, R.drawable.hospital_logo1,R.drawable.hospital_logo1,R.drawable.hospital_logo1,R.drawable.hospital_logo1,R.drawable.hospital_logo1,R.drawable.hospital_logo1,R.drawable.hospital_logo1,R.drawable.hospital_logo1,R.drawable.hospital_logo1};

    String[] NAMES = {"Patanjali ","Bakshe Bandhu","Tanushri","Shri Datta Krupa","Shree Sai","Vijaya","Govind","Aaroh","Rajeshwar","Smile Pharma"};
    String[] DESCRIPTIONS = {"General Stores and Medical","Ahushadhalaya and General","Arogya Kendra and General Stores","Medical and General Store","Medical Store","Medical Store","Medicals and General Stores","Medical and General Stores",
            "Medical Store","Medical and General Store"};
    String[] PHONES={"9822237565","9371963348","9175784844","9890209132","9890624878","9326428312","9766365988","9923264183",
            "07122251337","08007761166"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pharmacy_layout);

        ListView listView = (ListView)findViewById(R.id.listView_Pharmacy);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.custom_pharmacy_layout,null);

            ImageView imageView = (ImageView)view.findViewById(R.id.imageView2);
            TextView textView_name = (TextView)view.findViewById(R.id.textView_name);
            TextView textView_description = (TextView)view.findViewById(R.id.textView_description);
            TextView textView_phone=(TextView)view.findViewById(R.id.Pharmacy_phoneNumber);

            imageView.setImageResource(IMAGES[i]);
            textView_name.setText(NAMES[i]);
            textView_description.setText(DESCRIPTIONS[i]);
            textView_phone.setText(PHONES[i]);
            return view;
        }
    }
}
