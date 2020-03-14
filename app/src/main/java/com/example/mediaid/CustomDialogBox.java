package com.example.mediaid;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class CustomDialogBox extends Activity {

    //private Button buttonClick;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
                // Create custom dialog object
                final Dialog dialog = new Dialog(CustomDialogBox.this);
                // Include dialog.xml file
                dialog.setContentView(R.layout.developer_info);
                // Set dialog title
                dialog.setTitle("About Me");


                Button instagram_btn=(Button)dialog.findViewById(R.id.instagram_button);
                Button facebook_btn=(Button)dialog.findViewById(R.id.facebook_button);
                Button whatsapp_btn=(Button)dialog.findViewById(R.id.whatsapp_button);
                Button back_button = (Button)dialog.findViewById(R.id.back_button);
                ImageView image = (ImageView) dialog.findViewById(R.id.back_image);
                image.setImageResource(R.drawable.amey_dev);

                dialog.show();


                //INSTAGRAM ACCOUNT OPENING
                instagram_btn.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri uri = Uri.parse("http://instagram.com/_u/ahh.may");
                        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                        likeIng.setPackage("com.instagram.android");

                        try {
                            startActivity(likeIng);
                            }
                        catch (ActivityNotFoundException e) {
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("http://instagram.com/ahh.may")));
                        }
                    }
                });


        // for opening Facebook
        facebook_btn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/”+AmeyJeurkar"));
                startActivity(intent);
            }
        });


              //DEVELOPER's WHATSAPP LINK
        whatsapp_btn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String phoneNumber="+91 7409909018";
                String url = "https://api.whatsapp.com/send?phone="+phoneNumber;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                Toast.makeText(CustomDialogBox.this,"" + "Opening developer's WHATSAPP ACCOUNT", Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        });


        // for returning back to Home Screen
        back_button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(CustomDialogBox.this, navigation_drawer.class);
                startActivity(intent);
            }
        });
    }
}
