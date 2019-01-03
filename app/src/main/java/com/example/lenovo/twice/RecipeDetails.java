package com.example.lenovo.twice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecipeDetails extends AppCompatActivity {

    private String nameRecipe;
    TextView display_recipeName;
    TextView display_recipeType;
    TextView display_recipeTheme;
    TextView display_mainIngr;
    TextView display_steps1;
    TextView display_steps2;
    TextView display_steps3;
    TextView display_steps4;
    TextView display_steps5;
    private String typeRecipe;
    private String themeRecipe;
    private String mainRecipe;
    private String step1Recipe;
    private String step2Recipe;
    private String step3Recipe;
    private String step4Recipe;
    private String step5Recipe;


    private List<Recipe> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        display_recipeName = (TextView) findViewById(R.id.display_recipeName);
        display_recipeType = (TextView) findViewById(R.id.display_recipeType);
        display_recipeTheme = (TextView) findViewById(R.id.display_recipeTheme);
        display_mainIngr = (TextView) findViewById(R.id.display_mainIngr);
        display_steps1 = (TextView) findViewById(R.id.display_steps1);
        display_steps2 = (TextView) findViewById(R.id.display_steps2);
        display_steps3 = (TextView) findViewById(R.id.display_steps3);
        display_steps4 = (TextView) findViewById(R.id.display_steps4);
        display_steps5 = (TextView) findViewById(R.id.display_steps5);

        nameRecipe = getIntent().getExtras().get("name").toString();
        typeRecipe = getIntent().getExtras().get("type").toString();
        themeRecipe = getIntent().getExtras().get("theme").toString();
        mainRecipe = getIntent().getExtras().get("main").toString();
        step1Recipe = getIntent().getExtras().get("step1").toString();
        step2Recipe = getIntent().getExtras().get("step2").toString();
        step3Recipe = getIntent().getExtras().get("step3").toString();
        step4Recipe = getIntent().getExtras().get("step4").toString();
        step5Recipe = getIntent().getExtras().get("step5").toString();



        //textViewRecipeType.setText(recipe.getRecipeType());

        display_recipeName.setText(nameRecipe);
        display_recipeType.setText(typeRecipe);
        display_recipeTheme.setText(themeRecipe);
        display_mainIngr.setText(mainRecipe);
        display_steps1.setText(step1Recipe);
        display_steps2.setText(step2Recipe);
        display_steps3.setText(step3Recipe);
        display_steps4.setText(step4Recipe);
        display_steps5.setText(step5Recipe);

       Toast.makeText(this, nameRecipe, Toast.LENGTH_LONG).show();



    }
}
