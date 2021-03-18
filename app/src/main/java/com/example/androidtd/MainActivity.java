package com.example.androidtd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
}