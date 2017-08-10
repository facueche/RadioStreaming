package com.iongeger.radiostreaming;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        FragmentList.OnFragmentInteractionListener,
        FragmentRadio.OnFragmentInteractionListener{


    private RadioInfo radio;
    private Fragment fragment;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        fm = getFragmentManager();
        fragment = new FragmentList();
        fm.beginTransaction().
                replace(R.id.content_main, fragment,"fragment_list")
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack("fragment_list")
                .commit();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
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

        boolean fragmentTransaction = false;
        String TAG = "";

        if (id == R.id.nav_list) {
            TAG = "fragment_list";
            fragment = (FragmentList) fm.findFragmentByTag(TAG);
            if(fragment == null){
                fragment = new FragmentList();
                newFragmentTransaction(fragment,TAG);
            }else{
                fm.beginTransaction().replace(R.id.content_main, fragment).commit();
            }
            fragmentTransaction = true;

        } else if (id == R.id.nav_player) {
            TAG = "fragment_radio";
            fragment = (FragmentRadio) fm.findFragmentByTag(TAG);
            if(fragment == null){
                fragment = new FragmentRadio();
                newFragmentTransaction(fragment,TAG);
            }else{
                fm.beginTransaction().replace(R.id.content_main, fragment).commit();
            }
            fragmentTransaction = true;

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        if(fragmentTransaction){

            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void newFragmentTransaction(Fragment fragment, String tag){
        fm.beginTransaction()
                .replace(R.id.content_main, fragment, tag)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(tag)
                .commit();
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void setRadioOnActivity(RadioInfo radio) {
        this.radio = radio;
        String TAG = "fragment_radio";
        fragment = (FragmentRadio) fm.findFragmentByTag(TAG);
        if(fragment == null){
            fragment = new FragmentRadio();
            Bundle args = new Bundle();
            args.putSerializable("RadioInfo", radio);
            fragment.setArguments(args);
            newFragmentTransaction(fragment,TAG);
        }else{
            ((FragmentRadio)fragment).setRadioChannel(radio);
            fm.beginTransaction().replace(R.id.content_main, fragment).commit();
        }
    }
}
