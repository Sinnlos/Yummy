package com.example.lenovo.twice;

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
        Button btn_randomRecipe = findViewById(R.id.btn_randomRecipe);
        Button btn_toadd = findViewById(R.id.btn_toadd);
        Button btn_display_all_recipes = findViewById(R.id.btn_display_all_recipes);

        btnRecipeFilters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recipeFilterLaunch = new Intent(Start.this, SearchRecipe.class);
                startActivity(recipeFilterLaunch);
            }
        });


        btn_randomRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent search = new Intent(Start.this, DisplayRandomRecipe.class);
                startActivity(search);
            }
        });

        btn_toadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add = new Intent(Start.this, AddingRecipe.class);
                startActivity(add);
            }
        });

        btn_display_all_recipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent display = new Intent(Start.this, DisplayAllRecipes.class);
                startActivity(display);
            }
        });

    }
}
