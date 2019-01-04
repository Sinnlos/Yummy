package com.example.lenovo.twice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class YummyMainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yummy_main_screen);
        

        Button btn_start = findViewById(R.id.btn_start);

        Button btn_toadd = findViewById(R.id.btn_toadd);
        Button btn_go_to_search = findViewById(R.id.btn_go_to_search);


        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent start = new Intent(YummyMainScreen.this, HomePageActivity.class);
                startActivity(start);
            }
        });

        btn_toadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add = new Intent(YummyMainScreen.this, DisplayAllRecipes.class);
                startActivity(add);
            }
        });

        btn_go_to_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent search = new Intent(YummyMainScreen.this, DisplayRandomRecipe.class);
                startActivity(search);
            }
        });


    }
}
