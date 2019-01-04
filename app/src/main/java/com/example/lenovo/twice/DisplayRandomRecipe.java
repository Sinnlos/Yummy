package com.example.lenovo.twice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DisplayRandomRecipe extends AppCompatActivity {

    DatabaseReference recipeDB;

    ListView listViewRecipes;
    List<Recipe> recipeList;

    TextView display_recipeName;
    TextView display_recipeType;
    TextView display_recipeTheme;
    TextView display_mainIngr;
    TextView display_steps1;
    TextView display_steps2;
    TextView display_steps3;
    TextView display_steps4;
    TextView display_steps5;

    Button btn_random_recipe_again;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_random_recipe);

        recipeDB = FirebaseDatabase.getInstance().getReference().child("recipes");

        //listViewRecipes = (ListView) findViewById(R.id.listViewRecipes);

        recipeList = new ArrayList<>();

        btn_random_recipe_again = (Button) findViewById(R.id.btn_random_recipe_again);

        btn_random_recipe_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent oneTimeMore = new Intent(DisplayRandomRecipe.this, DisplayRandomRecipe.class);
                startActivity(oneTimeMore);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        recipeDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                display_recipeName = (TextView) findViewById(R.id.display_recipeName);
                display_recipeType = (TextView) findViewById(R.id.display_recipeType);
                display_recipeTheme = (TextView) findViewById(R.id.display_recipeTheme);
                display_mainIngr = (TextView) findViewById(R.id.display_mainIngr);
                display_steps1 = (TextView) findViewById(R.id.display_steps1);
                display_steps2 = (TextView) findViewById(R.id.display_steps2);
                display_steps3 = (TextView) findViewById(R.id.display_steps3);
                display_steps4 = (TextView) findViewById(R.id.display_steps4);
                display_steps5 = (TextView) findViewById(R.id.display_steps5);

                recipeList.clear();
                for(DataSnapshot recipeSnapshot : dataSnapshot.getChildren()){
                    Recipe recipe = recipeSnapshot.getValue(Recipe.class);

                    recipeList.add(recipe);

                }

                int value = recipeList.size();

                Random generator = new Random();
                int randomInt = generator.nextInt(value) + 1;

                Recipe recipe = recipeList.get(randomInt);
                recipeList.clear();
                recipeList.add(recipe);

                String name = recipe.getRecipeName();
                String type = recipe.getRecipeType();
                String theme = recipe.getRecipeTheme();
                String main = recipe.getMainIngr();
                String step1 = recipe.getSteps1();
                String step2 = recipe.getSteps2();
                String step3 = recipe.getSteps3();
                String step4 = recipe.getSteps4();
                String step5 = recipe.getSteps5();

                display_recipeName.setText(name);
                display_recipeType.setText(type);
                display_recipeTheme.setText(theme);
                display_mainIngr.setText(main);
                display_steps1.setText(step1);
                display_steps2.setText(step2);
                display_steps3.setText(step3);
                display_steps4.setText(step4);
                display_steps5.setText(step5);

                //RecipeList adapter = new RecipeList(DisplayRandomRecipe.this, recipeList);
                //listViewRecipes.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
