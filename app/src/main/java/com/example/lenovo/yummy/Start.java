package com.example.lenovo.yummy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button btnRecipeFilters = findViewById(R.id.btn_RecipeFilters);
        Button btnRandomRecipe = findViewById(R.id.btn_randomRecipe);
        Button btnAddRecipe = findViewById(R.id.btn_AddRecipe);

        btnRecipeFilters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recipeFilterLaunch = new Intent(Start.this, RecipeLookingFilters.class);
                startActivity(recipeFilterLaunch);
            }
        });

        btnRandomRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent randomRecipeDisplay = new Intent(Start.this, DisplayRandomRecipe.class);
                startActivity(randomRecipeDisplay);
            }
        });

        btnAddRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addRecipeDisplay = new Intent(Start.this, AddingRecipe.class);
                startActivity(addRecipeDisplay);
            }
        });



    }
}
