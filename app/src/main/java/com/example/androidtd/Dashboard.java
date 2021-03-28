package com.example.androidtd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Dashboard extends AppCompatActivity {

    private static final String TAG_NAME = "toto";
    public TextView nomUser;
    public ListView dataUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

       this.nomUser = (TextView) findViewById(R.id.nomUser);
       this.dataUser = (ListView) findViewById(R.id.dataUser);

        PasserelleApi api = new PasserelleApi();
        api.WebService();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //retourne activity dashboard
    public void goDsh() {
        Intent goDashboard = new Intent(getApplicationContext(), Dashboard.class);
        startActivity(goDashboard);
        finish();
    }

    //retourne l'activity user
    public void goUsers() {
        Intent goUsers = new Intent(getApplicationContext(), Users.class);
        startActivity(goUsers);
        finish();
    }

    //retourne l'activity main
    public void goLogin() {
        Intent goMain = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(goMain);
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_login:
                this.goLogin();
                break;
            case R.id.menu_dsh:
                this.goDsh();
                break;
            case R.id.menu_users:
                this.goUsers();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}