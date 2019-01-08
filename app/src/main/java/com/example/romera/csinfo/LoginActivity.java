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

public class LoginActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String USERNAME_ADMIN = "admin";
    private static final String PASSWORD_ADMIN = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(LoginActivity.this, MainActivity.class);
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
        getMenuInflater().inflate(R.menu.login, menu);
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
            Intent lobby = new Intent(LoginActivity.this, LobbyActivity.class);
            LoginActivity.this.startActivity(lobby);
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
                Intent home = new Intent(LoginActivity.this, MainActivity.class);
                LoginActivity.this.startActivity(home);
                break;
            case R.id.nav_maps:
                Intent maps = new Intent(LoginActivity.this, MapsActivity.class);
                startActivity(maps);
                break;
            case R.id.nav_news:
                Intent news = new Intent(LoginActivity.this, NewsActivity.class);
                startActivity(news);
                break;
            case R.id.nav_ar:
                Intent ar = new Intent(LoginActivity.this, AR_Activity.class);
                startActivity(ar);
                break;
            case R.id.nav_smg:
                Intent smg = new Intent(LoginActivity.this, SMG_Activity.class);
                startActivity(smg);
                break;
            case R.id.nav_shotgun:
                Intent shotgun = new Intent(LoginActivity.this, SHOTGUN_Activity.class);
                startActivity(shotgun);
                break;
            case R.id.nav_pistol:
                Intent pistol = new Intent(LoginActivity.this, PISTOL_Activity.class);
                startActivity(pistol);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void login (View view) {

        Users users = new Users();

        TextView user = findViewById(R.id.user_login);
        TextView password = findViewById(R.id.password_login);

        boolean logged = false;

        if (users.arrayUsers.contains(user) || user.getText().toString().equals(USERNAME_ADMIN) && password.getText().toString().equals(PASSWORD_ADMIN)) {
            Toast.makeText(getBaseContext(), "Succesfully logged", Toast.LENGTH_LONG).show();
            logged = true;
        } else if (user.getText().toString().isEmpty()) {
            user.setError("Este campo está vacío");
        } else {
            Toast.makeText(getBaseContext(), "Incorrect username/password", Toast.LENGTH_SHORT).show();
        }
    }

}
