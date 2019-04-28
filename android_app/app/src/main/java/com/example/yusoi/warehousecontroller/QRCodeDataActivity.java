package com.example.yusoi.warehousecontroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class QRCodeDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_data);

        String dataString = getIntent().getStringExtra("DATA");

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.main_layout);
        TextView tv = new TextView(QRCodeDataActivity.this);
        tv.setText(dataString);
        linearLayout.addView(tv);

    }
}
