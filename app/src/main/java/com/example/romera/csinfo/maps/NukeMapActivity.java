package com.example.romera.csinfo.maps;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import com.example.romera.csinfo.nav_item.AR_Activity;
import com.example.romera.csinfo.nav_item.PISTOL_Activity;
import com.example.romera.csinfo.nav_item.SHOTGUN_Activity;
import com.example.romera.csinfo.nav_item.SMG_Activity;
import com.example.romera.csinfo.MainActivity;
import com.example.romera.csinfo.nav_item.MapsActivity;
import com.example.romera.csinfo.nav_item.NewsActivity;
import com.example.romera.csinfo.R;

public class NukeMapActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuke_map);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(NukeMapActivity.this, MainActivity.class);
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
        getMenuInflater().inflate(R.menu.nuke_map, menu);
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
            Intent lobby = new Intent(NukeMapActivity.this, LobbyActivity.class);
            NukeMapActivity.this.startActivity(lobby);
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
                Intent home = new Intent(NukeMapActivity.this, MainActivity.class);
                NukeMapActivity.this.startActivity(home);
                break;
            case R.id.nav_maps:
                Intent maps = new Intent(NukeMapActivity.this, MapsActivity.class);
                startActivity(maps);
                break;
            case R.id.nav_news:
                Intent news = new Intent(NukeMapActivity.this, NewsActivity.class);
                startActivity(news);
                break;
            case R.id.nav_ar:
                Intent ar = new Intent(NukeMapActivity.this, AR_Activity.class);
                startActivity(ar);
                break;
            case R.id.nav_smg:
                Intent smg = new Intent(NukeMapActivity.this, SMG_Activity.class);
                startActivity(smg);
                break;
            case R.id.nav_shotgun:
                Intent shotgun = new Intent(NukeMapActivity.this, SHOTGUN_Activity.class);
                startActivity(shotgun);
                break;
            case R.id.nav_pistol:
                Intent pistol = new Intent(NukeMapActivity.this, PISTOL_Activity.class);
                startActivity(pistol);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
