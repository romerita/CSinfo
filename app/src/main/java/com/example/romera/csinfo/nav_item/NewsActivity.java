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
import android.widget.TextView;
import android.widget.Toast;

import com.example.romera.csinfo.LobbyActivity;
import com.example.romera.csinfo.MainActivity;
import com.example.romera.csinfo.R;
import com.example.romera.csinfo.news.New1_Activity;
import com.example.romera.csinfo.news.New2_Activity;
import com.example.romera.csinfo.news.New3_Activity;

public class NewsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(NewsActivity.this, MainActivity.class);
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
        getMenuInflater().inflate(R.menu.news, menu);
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
            Intent lobby = new Intent(NewsActivity.this, LobbyActivity.class);
            NewsActivity.this.startActivity(lobby);
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
                Intent home = new Intent(NewsActivity.this, MainActivity.class);
                NewsActivity.this.startActivity(home);
                break;
            case R.id.nav_maps:
                Intent maps = new Intent(NewsActivity.this, MapsActivity.class);
                startActivity(maps);
                break;
            case R.id.nav_ar:
                Intent ar = new Intent(NewsActivity.this, AR_Activity.class);
                startActivity(ar);
                break;
            case R.id.nav_smg:
                Intent smg = new Intent(NewsActivity.this, SMG_Activity.class);
                startActivity(smg);
                break;
            case R.id.nav_shotgun:
                Intent shotgun = new Intent(NewsActivity.this, SHOTGUN_Activity.class);
                startActivity(shotgun);
                break;
            case R.id.nav_pistol:
                Intent pistol = new Intent(NewsActivity.this, PISTOL_Activity.class);
                startActivity(pistol);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void noticia1(View view) {
        Intent noticia1 = new Intent(NewsActivity.this, New1_Activity.class);
        NewsActivity.this.startActivity(noticia1);
    }
    public void noticia2 (View view) {
        Intent noticia2 = new Intent(NewsActivity.this, New2_Activity.class);
        NewsActivity.this.startActivity(noticia2);
    }
    public void noticia3 (View view) {
        Intent noticia3 = new Intent(NewsActivity.this, New3_Activity.class);
        NewsActivity.this.startActivity(noticia3);
    }

    public void share(View view) {

        int id = view.getId();

        TextView noticia1 = findViewById(R.id.noticia1);
        TextView noticia2 = findViewById(R.id.noticia2);
        TextView noticia3 = findViewById(R.id.noticia3);

        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
        whatsappIntent.setType("text/plain");
        whatsappIntent.setPackage("com.whatsapp");

        switch (id) {
            case R.id.share:
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, noticia1.getText().toString());
                try {
                    NewsActivity.this.startActivity(whatsappIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getBaseContext(), "Whatsapp have not been installed", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.share2:
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, noticia2.getText().toString());
                try {
                    NewsActivity.this.startActivity(whatsappIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getBaseContext(), "Whatsapp have not been installed", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.share3:
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, noticia3.getText().toString());
                try {
                    NewsActivity.this.startActivity(whatsappIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getBaseContext(), "Whatsapp have not been installed", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

}
