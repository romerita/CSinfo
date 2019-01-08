package com.example.romera.csinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GestureDetectorCompat;
import android.view.MotionEvent;
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
import com.example.romera.csinfo.news.New1_Activity;
import com.example.romera.csinfo.news.New2_Activity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "You are already in home", Snackbar.LENGTH_LONG)
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
        if (id == R.id.lobby_activity) {
            Intent lobby = new Intent(MainActivity.this, LobbyActivity.class);
            MainActivity.this.startActivity(lobby);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // switch implementado en todas las activities para el menú de navegacion (nav_drawer)
        switch (id) {
            case R.id.nav_maps:
                Intent maps = new Intent(MainActivity.this, MapsActivity.class);
                MainActivity.this.startActivity(maps);
                break;
            case R.id.nav_news:
                Intent news = new Intent(MainActivity.this, NewsActivity.class);
                MainActivity.this.startActivity(news);
                break;
            case R.id.nav_ar:
                Intent ar = new Intent(MainActivity.this, AR_Activity.class);
                MainActivity.this.startActivity(ar);
                break;
            case R.id.nav_smg:
                Intent smg = new Intent(MainActivity.this, SMG_Activity.class);
                MainActivity.this.startActivity(smg);
                break;
            case R.id.nav_shotgun:
                Intent shotgun = new Intent(MainActivity.this, SHOTGUN_Activity.class);
                MainActivity.this.startActivity(shotgun);
                break;
            case R.id.nav_pistol:
                Intent pistol = new Intent(MainActivity.this, PISTOL_Activity.class);
                MainActivity.this.startActivity(pistol);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // Método para el botón LOG IN haciendo que cambie de activity
    public void signIn (View view) {
        Intent signIn = new Intent(MainActivity.this, LoginActivity.class);
        MainActivity.this.startActivity(signIn);
    }

    // Método para el botón REGISTER haciendo que cambie de activity
    public void signUp (View view) {
        Intent signUp = new Intent(MainActivity.this, RegisterActivity.class);
        MainActivity.this.startActivity(signUp);
    }

    // Método para que cuando haga click en la noticia se vaya a ella.
    public void noticia1(View view) {
        Intent noticia1 = new Intent(MainActivity.this, New1_Activity.class);
        MainActivity.this.startActivity(noticia1);
    }

    // Método para que cuando haga click en la noticia se vaya a ella.
    public void noticia2 (View view) {
        Intent noticia2 = new Intent(MainActivity.this, New2_Activity.class);
        MainActivity.this.startActivity(noticia2);
    }

    // Método para compartir TextView por la aplicación WhatsApp
    public void share(View view) {

        int id = view.getId();

        TextView noticia1 = findViewById(R.id.noticia1);
        TextView noticia2 = findViewById(R.id.noticia2);

        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
        whatsappIntent.setType("text/plain");
        whatsappIntent.setPackage("com.whatsapp");

        switch (id) {
            case R.id.share:
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, noticia1.getText().toString());
                try {
                    MainActivity.this.startActivity(whatsappIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getBaseContext(), "Whatsapp have not been installed", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.share2:
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, noticia2.getText().toString());
                try {
                    MainActivity.this.startActivity(whatsappIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getBaseContext(), "Whatsapp have not been installed", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void showMore (View view) {
        Intent showMore = new Intent(MainActivity.this, NewsActivity.class);
        MainActivity.this.startActivity(showMore);
    }

}
