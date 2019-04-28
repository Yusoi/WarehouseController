package com.example.yusoi.warehousecontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        String username = getIntent().getStringExtra("USERNAME");
        ((TextView) findViewById(R.id.welcome_message)).setText("Current user: "+username);
    }

    public void onClickScannerButton(View view){
        startActivity(new Intent(MainMenuActivity.this,QRCodeScannerActivity.class));
    }

}
