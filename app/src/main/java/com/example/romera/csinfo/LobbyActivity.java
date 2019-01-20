package com.example.romera.csinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.romera.csinfo.nav_item.AR_Activity;
import com.example.romera.csinfo.nav_item.MapsActivity;
import com.example.romera.csinfo.nav_item.NewsActivity;
import com.example.romera.csinfo.nav_item.PISTOL_Activity;
import com.example.romera.csinfo.nav_item.SHOTGUN_Activity;
import com.example.romera.csinfo.nav_item.SMG_Activity;

import java.util.ArrayList;
import java.util.List;

public class LobbyActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    List<Lobby> lobbyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        RecyclerView recyclerView = findViewById(R.id.poem_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LobbyRecyclerAdapter lobbyRecyclerAdapter = new LobbyRecyclerAdapter(lobbyList);
        recyclerView.setAdapter(lobbyRecyclerAdapter);

        for (int i = 1; i < 100; i++) {
            Lobby lobby = new Lobby();
            lobby.title = "Sala #" + i;
            lobby.player = "Players in lobby: " + (int)(Math.random()*5);
            lobbyList.add(lobby);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Full lobbies. Can't create one.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
        getMenuInflater().inflate(R.menu.lobby, menu);
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
                Intent home = new Intent(LobbyActivity.this, MainActivity.class);
                LobbyActivity.this.startActivity(home);
                break;
            case R.id.nav_maps:
                Intent maps = new Intent(LobbyActivity.this, MapsActivity.class);
                startActivity(maps);
                break;
            case R.id.nav_news:
                Intent news = new Intent(LobbyActivity.this, NewsActivity.class);
                startActivity(news);
                break;
            case R.id.nav_ar:
                Intent ar = new Intent(LobbyActivity.this, AR_Activity.class);
                startActivity(ar);
                break;
            case R.id.nav_smg:
                Intent smg = new Intent(LobbyActivity.this, SMG_Activity.class);
                startActivity(smg);
                break;
            case R.id.nav_shotgun:
                Intent shotgun = new Intent(LobbyActivity.this, SHOTGUN_Activity.class);
                startActivity(shotgun);
                break;
            case R.id.nav_pistol:
                Intent pistol = new Intent(LobbyActivity.this, PISTOL_Activity.class);
                startActivity(pistol);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
