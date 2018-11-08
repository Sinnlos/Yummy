package com.example.lenovo.yummy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class YummyMainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yummy_main_screen);

        Button btn_infoscreen = findViewById(R.id.btn_infoscreen);

        btn_infoscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent info = new Intent(YummyMainScreen.this,InfoScreen.class);
                startActivity(info);
            }
        });

        Button btn_start = findViewById(R.id.btn_start);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent start = new Intent(YummyMainScreen.this, Start.class);
                startActivity(start);
            }
        });


    }
}
