package com.example.mediaid;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;
import com.flaviofaria.kenburnsview.Transition;

public class navigation_drawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //TextView username_nav=(TextView)navigationView.getHeaderView(0).findViewById(R.id.nav_username);
        //username_nav.setText();

        //KenBurns EFFECT addition
        KenBurnsView kbv = (KenBurnsView) findViewById(R.id.image);
        AccelerateDecelerateInterpolator ACCELERATE_DECELERATE = new AccelerateDecelerateInterpolator();
        RandomTransitionGenerator generator = new RandomTransitionGenerator(5000, ACCELERATE_DECELERATE);
        kbv.setTransitionGenerator(generator); //set new transition on kenburns view
        kbv.setTransitionListener(onTransittionListener());

    }
    //Ken Burns EFFECT functionality
    private KenBurnsView.TransitionListener onTransittionListener() {
        return new KenBurnsView.TransitionListener() {

            @Override
            public void onTransitionStart(Transition transition) {
               // Toast.makeText(navigation_drawer.this, "start", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onTransitionEnd(Transition transition) {
                // Toast.makeText(navigation_drawer.this, "end", Toast.LENGTH_SHORT).show();
            }
        };
    }
    //ken Burns function ends here





    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_hospital_locator) {
            // Handle the camera action
            Intent i=new Intent(navigation_drawer.this,MapsActivity.class);
            Toast.makeText(getApplicationContext(), "Loading Map", Toast.LENGTH_SHORT).show();
            startActivity(i);
        } else if (id == R.id.nav_weight) {
            Intent i=new Intent(navigation_drawer.this,WeightActivity.class);
            Toast.makeText(getApplicationContext(), "Loading BMI Calculator", Toast.LENGTH_SHORT).show();
            startActivity(i);
        } else if (id == R.id.nav_medico_alert) {
            Intent i=new Intent(navigation_drawer.this,MedicineAlertActivity.class);
            Toast.makeText(getApplicationContext(), "Loading Alert Activity", Toast.LENGTH_SHORT).show();
            startActivity(i);
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {
            Intent share=new Intent();
            share.setAction(Intent.ACTION_SEND);
            share.putExtra(Intent.EXTRA_TEXT,"Hello everyone!\nI've made an application please use it and let me know your opinion on \njeurkaramey@gmail.com .");
            share.setType("text/plain");
            Toast.makeText(getApplicationContext(), "share with..", Toast.LENGTH_SHORT).show();
            startActivity(share);
        }
        else if (id == R.id.developer_abouts) {

            Intent i=new Intent(navigation_drawer.this,CustomDialogBox.class);
            startActivity(i);
//            Toast.makeText(getApplicationContext(), "Will be revealed later", Toast.LENGTH_SHORT).show();

        }
        else if (id == R.id.nav_loggedOut) {
//            Intent i=new Intent(navigation_drawer.this,FirstActivity.class);
//            Toast.makeText(getApplicationContext(), "Logging Out", Toast.LENGTH_SHORT).show();
//            startActivity(i);
//            finish();

            new AlertDialog.Builder(this,R.style.CustomDialogTheme)
                    .setTitle("WARNING").setMessage("Are you sure you want to quit ?").setIcon(R.drawable.hospital_logo1)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                                Intent i=new Intent(navigation_drawer.this,FirstActivity.class);
                                Toast.makeText(getApplicationContext(), "Logged Out", Toast.LENGTH_SHORT).show();
                                startActivity(i);
                                finish();
                        }
                    }).setNegativeButton(android.R.string.no,null).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
