package com.example.mediaid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    EditText e1, e2;
    Button b1;
    DatabaserHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        db = new DatabaserHelper(this);
        e1 = (EditText)findViewById(R.id.user);
        e2 = (EditText)findViewById(R.id.pass);
        b1 = (Button)findViewById(R.id.btn_login);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean Chkemailpass = db.emailpassword(email,password);
                if(Chkemailpass==true) {
                    Toast.makeText(getApplicationContext(), "Successfully Login", Toast.LENGTH_SHORT).show();
//                    b1.setOnClickListener(new View.OnClickListener() {
//                        public void onClick(View arg0) {
                    Intent openIntent = new Intent(getApplicationContext(), navigation_drawer.class);
                    openIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    getApplicationContext().startActivity(openIntent);
//                        }
//                    });
                }
                else
                    Toast.makeText(getApplicationContext(),"Wrong Email or Password",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
