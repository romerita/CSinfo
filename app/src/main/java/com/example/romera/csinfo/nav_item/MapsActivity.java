package com.example.romera.csinfo.nav_item;

import android.content.Intent;
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

import com.example.romera.csinfo.LobbyActivity;
import com.example.romera.csinfo.MainActivity;
import com.example.romera.csinfo.R;
import com.example.romera.csinfo.maps.InfernoMapActivity;
import com.example.romera.csinfo.maps.MirageMapActivity;
import com.example.romera.csinfo.maps.NukeMapActivity;

public class MapsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(MapsActivity.this, MainActivity.class);
                startActivity(home);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

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
        getMenuInflater().inflate(R.menu.maps, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.lobby_activity) {
            Intent lobby = new Intent(MapsActivity.this, LobbyActivity.class);
            MapsActivity.this.startActivity(lobby);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_home:
                Intent home = new Intent(MapsActivity.this, MainActivity.class);
                MapsActivity.this.startActivity(home);
                break;
            case R.id.nav_news:
                Intent news = new Intent(MapsActivity.this, NewsActivity.class);
                startActivity(news);
                break;
            case R.id.nav_ar:
                Intent ar = new Intent(MapsActivity.this, AR_Activity.class);
                startActivity(ar);
                break;
            case R.id.nav_smg:
                Intent smg = new Intent(MapsActivity.this, SMG_Activity.class);
                startActivity(smg);
                break;
            case R.id.nav_shotgun:
                Intent shotgun = new Intent(MapsActivity.this, SHOTGUN_Activity.class);
                startActivity(shotgun);
                break;
            case R.id.nav_pistol:
                Intent pistol = new Intent(MapsActivity.this, PISTOL_Activity.class);
                startActivity(pistol);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void mirage (View view) {
        Intent mirage = new Intent(MapsActivity.this, MirageMapActivity.class);
        MapsActivity.this.startActivity(mirage);
    }
    public void nuke (View view) {
        Intent nuke = new Intent(MapsActivity.this, NukeMapActivity.class);
        MapsActivity.this.startActivity(nuke);
    }
    public void inferno (View view) {
        Intent inferno = new Intent(MapsActivity.this, InfernoMapActivity.class);
        MapsActivity.this.startActivity(inferno);
    }

}
