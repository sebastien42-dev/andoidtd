package com.example.androidtd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button dashboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.dashboard = (Button)findViewById(R.id.buttondashboard);

        this.dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goDashboard = new Intent(getApplicationContext(), Dashboard.class);
                startActivity(goDashboard);
                finish();
            }
        });

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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