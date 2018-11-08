package com.example.lenovo.yummy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button btnRecipeFilters = findViewById(R.id.btn_RecipeFilters);
        Button btnRandomRecipe = findViewById(R.id.btn_randomRecipe);
        Button btnAddReceipe = findViewById(R.id.btn_AddReceipe);

        btnRecipeFilters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent receipeFilterLaunch = new Intent(Start.this, RecipeLookingFilters.class);
                startActivity(receipeFilterLaunch);
            }
        });

        btnRandomRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent randomRecipeDisplay = new Intent(Start.this, DisplayRandomRecipe.class);
                startActivity(randomRecipeDisplay);
            }
        });

        btnAddReceipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addRecipeDisplay = new Intent(Start.this, AddingRecipe.class);
                startActivity(addRecipeDisplay);
            }
        });



    }
}
