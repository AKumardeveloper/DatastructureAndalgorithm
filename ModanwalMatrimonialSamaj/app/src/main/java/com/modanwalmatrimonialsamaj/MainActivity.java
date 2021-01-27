package com.modanwalmatrimonialsamaj;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
       Button b1;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        FloatingActionButton notification = (FloatingActionButton) findViewById(R.id.notification);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i29 = new Intent(MainActivity.this,Event.class);
                startActivity(i29);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(MainActivity.this,Login.class);
                startActivity(i1);
                finish();
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id==R.id.admin) {
            Intent h30 = new Intent(MainActivity.this,Adminlogin.class);
            startActivity(h30);
            finish();
        }else if(id==R.id.helpclass){
            Intent h37 = new Intent(MainActivity.this,Help.class);
            startActivity(h37);
            finish();
        }
        else if(id==R.id.agecalculator){
            Intent i20 = new Intent(MainActivity.this,Agecalculator.class);
            startActivity(i20);
            finish();
        }
        else if (id == R.id.Maps) {
            Intent browserIntent2=new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.google.co.in"));
            startActivity(browserIntent2);
        } else if (id == R.id.Event) {
            Intent i18 = new Intent(MainActivity.this,Event.class);
            startActivity(i18);
            finish();

        } else if (id == R.id.Aboutus) {
            Intent i16 = new Intent(MainActivity.this,AboutUs.class);
            startActivity(i16);
            finish();
            return true;
        }else if(id==R.id.nav_share) {
            try{
            Intent i=new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_TEXT,"Modanwal matrimonial Samaj app please download it.." +
                    " https://play.google.com/store/apps/details?id=com.modanwalmatrimonialsamaj");
            startActivity(Intent.createChooser(i,"Share Via"));}catch (Exception e){
                Toast.makeText(getApplicationContext(),"Try again",Toast.LENGTH_LONG).show();
            }
        }
        else if(id==R.id.rateus) {
            try{
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("market//details?id=com.modanwalmatrimonialsamaj")));
            }catch (ActivityNotFoundException e){
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.modanwalmatrimonialsamaj")));
            }

        }else if(id==R.id.appupdate) {
            try{
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("market//details?id=com.modanwalmatrimonialsamaj")));
            }catch (ActivityNotFoundException e){
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.modanwalmatrimonialsamaj")));
            }
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
