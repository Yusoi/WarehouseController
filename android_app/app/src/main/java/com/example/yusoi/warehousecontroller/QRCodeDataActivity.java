package com.example.yusoi.warehousecontroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yusoi.warehousecontroller.Exceptions.InvalidBoxCodeException;

public class QRCodeDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_data);

        String qrCodeString = getIntent().getStringExtra("DATA");

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.main_layout_qrcode_data);

        try {
            checksumVerifier(qrCodeString);
            String titleString = "Box " + qrCodeString.split("::")[0];

            TextView title = findViewById(R.id.title);
            title.setText(titleString);

            //TODO ir buscar o id à bd
            String boxId = "1";
            TextView id_tv = (TextView) findViewById(R.id.id_tv);
            id_tv.setText(boxId);



            /*
            TextView tvt = (TextView) findViewById(R.id.title_main_menu);

            TextView tv = new TextView(this);
            tv.setText(titleString);
            tv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            linearLayout.addView(tv);
            */
        }catch(InvalidBoxCodeException e){
            String titleString = e.getMessage();
            TextView tv = new TextView(this);

            tv.setText(titleString);
            tv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            linearLayout.addView(tv);
        }
    }

    public void checksumVerifier(String qrCodeString) throws InvalidBoxCodeException {

        if(qrCodeString.equals("1")) {
            throw new InvalidBoxCodeException("");
        }
    }
}
