package com.example.mediaid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView lst;
    String[] fruitname={"Kadu Hospital,Om Nursing Home","Dr. Pallavi Gawalpanchi", "Dr. Matkar Hospital( Multispeciality Hospital)",
            "Aradhna poly clinic","Radhika vihar vrindavan","Shri satya sai baba gramin seva kendra","Arogya multispeciality clinic",
            "Arogya clinic","Health hospital and tiwari residence","Shriram hospital","Mohak medical","Smile pharma","Ujjwal multispeciality hospital",
            "Priti hospital"};


    String[] desc={"Hingna Rd, Mahajanwadi, Takli Seem, Dangarpura,Wanadongri","Hingna Rd, Mahajanwadi, Dangarpura,Wanadongri",
            "5 Shikshak Colony, Hingna Road, Wanadongri, Maharashtra","Shop No 3, Plot No 16 B, Wanadongari, Matoshri Nagar, Amar Nagar Road",
            "behind Ashtavinayak Empire dentle college road, Wanadongri, Maharashtra 441110","Nagalwadi, Maharashtra 441110",
            "Nagpur, Maharashtra 440016","Unnamed Road, Wanadongri, Maharashtra 440016","waghdara, Hingna Rd, Wanadongri, Maharashtra 441110",
            "Rajiv Nagar, Wanadongri ct, Nildoh, Maharashtra 440016","Rajiv Nagar, Nagpur, Maharashtra 440016",
            "House No.4784, M.I.D.C, Hingna, Nagpur, Maharashtra 440016","10, Hingna Rd, Gajanan Nagar, M.I.D.C., Lokmanya Nagar, Nagpur,440016",
            "Hingna, Maharashtra 440016"};


    String[] rating={"5","5","4","3","2","5","4","3","4","3","2","5","4","4"};


    String[] phone={"09960817168","09975493311","09545368569","9960772443","+917776090011","07776097516","Not Specified",
            "Not Specified","Not Specified","Not Specified","Not Specified","08007761166","09422129618","Not Specified"};


    String[] email={"Available 10am-9pm","Available 24Hrs","Available 9am-9pm","Available 10am-2pm","Available 8am-6pm","Available 24Hrs","Available 24Hrs","Available 24Hrs","Available 24 Hrs",
            "Available 24Hrs","Available 24Hrs","Available 10am-9pm","Available 24Hrs","Available 24Hrs"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospital_list);

        lst=findViewById(R.id.listview);

        CustomListview customListview=new CustomListview(this,fruitname,desc,rating,phone,email);

        lst.setAdapter(customListview);

    }
}
