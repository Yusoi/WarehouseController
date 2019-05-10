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
            String titleString = qrCodeString.split(" :: ")[0] + " contents:";

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
            TextView title = findViewById(R.id.title);
            title.setText(e.getMessage());
        }
    }


    public void checksumVerifier(String qrCodeString) throws InvalidBoxCodeException {
        try {
            //Default qrCode format is "Box <BoxNumber> :: <ChecksumCode>"
            int startingInt = Integer.parseInt(qrCodeString.split("Box ")[1].split(" :: ")[0]);

            int code = startingInt + 50;
            code = (int) Math.pow(code,2);
            code *= 67;
            code -= 30;

            if(code != Integer.valueOf(qrCodeString.split(" :: ")[1])){
                throw new InvalidBoxCodeException(String.valueOf(code));
            }

        }catch(NumberFormatException e){
            throw new InvalidBoxCodeException("Invalid box code 2");
        }catch(ArrayIndexOutOfBoundsException e){
            throw new InvalidBoxCodeException("Invalid box code 3");
        }

    }

}
