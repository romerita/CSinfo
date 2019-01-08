package com.example.romera.csinfo.nav_item;

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
import com.example.romera.csinfo.MainActivity;
import com.example.romera.csinfo.R;
import com.example.romera.csinfo.guns.AR.AK47_GunActivity;
import com.example.romera.csinfo.guns.AR.M4A1S_GunActivity;
import com.example.romera.csinfo.guns.AR.M4A4_GunActivity;

public class AR_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(AR_Activity.this, MainActivity.class);
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
        getMenuInflater().inflate(R.menu.ar_, menu);
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
            Intent lobby = new Intent(AR_Activity.this, LobbyActivity.class);
            AR_Activity.this.startActivity(lobby);
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
                Intent home = new Intent(AR_Activity.this, MainActivity.class);
                AR_Activity.this.startActivity(home);
                break;
            case R.id.nav_maps:
                Intent maps = new Intent(AR_Activity.this, MapsActivity.class);
                startActivity(maps);
                break;
            case R.id.nav_news:
                Intent news = new Intent(AR_Activity.this, NewsActivity.class);
                startActivity(news);
                break;
            case R.id.nav_smg:
                Intent smg = new Intent(AR_Activity.this, SMG_Activity.class);
                startActivity(smg);
                break;
            case R.id.nav_shotgun:
                Intent shotgun = new Intent(AR_Activity.this, SHOTGUN_Activity.class);
                startActivity(shotgun);
                break;
            case R.id.nav_pistol:
                Intent pistol = new Intent(AR_Activity.this, PISTOL_Activity.class);
                startActivity(pistol);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void ak47 (View view) {
        Intent ak47 = new Intent(AR_Activity.this, AK47_GunActivity.class);
        AR_Activity.this.startActivity(ak47);
    }
    public void m4a4 (View view) {
        Intent m4a4 = new Intent(AR_Activity.this, M4A4_GunActivity.class);
        AR_Activity.this.startActivity(m4a4);
    }
    public void m4a1s (View view) {
        Intent m4a1s = new Intent(AR_Activity.this, M4A1S_GunActivity.class);
        AR_Activity.this.startActivity(m4a1s);
    }
}
