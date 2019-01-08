package com.example.romera.csinfo;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.romera.csinfo.nav_item.AR_Activity;
import com.example.romera.csinfo.nav_item.MapsActivity;
import com.example.romera.csinfo.nav_item.NewsActivity;
import com.example.romera.csinfo.nav_item.PISTOL_Activity;
import com.example.romera.csinfo.nav_item.SHOTGUN_Activity;
import com.example.romera.csinfo.nav_item.SMG_Activity;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
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
        getMenuInflater().inflate(R.menu.register, menu);
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
            Intent lobby = new Intent(RegisterActivity.this, LobbyActivity.class);
            RegisterActivity.this.startActivity(lobby);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_home:
                Intent home = new Intent(RegisterActivity.this, MainActivity.class);
                RegisterActivity.this.startActivity(home);
                break;
            case R.id.nav_maps:
                Intent maps = new Intent(RegisterActivity.this, MapsActivity.class);
                startActivity(maps);
                break;
            case R.id.nav_news:
                Intent news = new Intent(RegisterActivity.this, NewsActivity.class);
                startActivity(news);
                break;
            case R.id.nav_ar:
                Intent ar = new Intent(RegisterActivity.this, AR_Activity.class);
                startActivity(ar);
                break;
            case R.id.nav_smg:
                Intent smg = new Intent(RegisterActivity.this, SMG_Activity.class);
                startActivity(smg);
                break;
            case R.id.nav_shotgun:
                Intent shotgun = new Intent(RegisterActivity.this, SHOTGUN_Activity.class);
                startActivity(shotgun);
                break;
            case R.id.nav_pistol:
                Intent pistol = new Intent(RegisterActivity.this, PISTOL_Activity.class);
                startActivity(pistol);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void register(View view) {

        Users users = new Users();

        TextView user = findViewById(R.id.user_register);
        TextView password = findViewById(R.id.password_register);
        TextView email = findViewById(R.id.email_register);

        String userRegistered = user.getText().toString();

        if (userRegistered.isEmpty()) {
            user.setError("Este campo está vacío");
        } else if (password.getText().toString().isEmpty()) {
            password.setError("Este campo está vacío");
        } else if (email.getText().toString().isEmpty()) {
            email.setError("Este campo está vacío");
        } else {
            users.arrayUsers.add(userRegistered);
            Toast.makeText(getBaseContext(), "Succesfully registered", Toast.LENGTH_SHORT).show();
        }
    }

}
