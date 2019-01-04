package com.example.lenovo.twice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AddingRecipe extends AppCompatActivity {

    EditText recipe_name;
    Spinner type_spinner;
    Spinner theme_spinner;
    Spinner main_ingr_spinner;
    Spinner add_ingr_spinner;
    Spinner add2_ingr_spinner;
    EditText step1;
    EditText step2;
    EditText step3;
    EditText step4;
    EditText step5;
    Button btn_add_recipeToDB;

    DatabaseReference recipeDB;

    ListView listViewRecipes;
    List<Recipe> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_recipe);

        recipeDB = FirebaseDatabase.getInstance().getReference();

        recipe_name = (EditText) findViewById(R.id.recipe_name);
        type_spinner = (Spinner) findViewById(R.id.type_spinner);
        theme_spinner = (Spinner) findViewById(R.id.theme_spinner);
        main_ingr_spinner = (Spinner) findViewById(R.id.main_ingr_spinner);
        add_ingr_spinner = (Spinner) findViewById(R.id.add_ingr_spinner);
        add2_ingr_spinner = (Spinner) findViewById(R.id.add2_ingr_spinner);
        step1 = (EditText) findViewById(R.id.step1);
        step2 = (EditText) findViewById(R.id.step2);
        step3 = (EditText) findViewById(R.id.step3);
        step4 = (EditText) findViewById(R.id.step4);
        step5 = (EditText) findViewById(R.id.step5);
        btn_add_recipeToDB = (Button) findViewById(R.id.btn_add_recipeToDB);

        listViewRecipes = (ListView) findViewById(R.id.listViewRecipes);

        recipeList = new ArrayList<>();
        btn_add_recipeToDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addRecipe();

                Intent move = new Intent(AddingRecipe.this, DisplayAllRecipes.class);
                startActivity(move);
            }
        });
    }


    private void addRecipe(){
        String recipeName = recipe_name.getText().toString().trim();
        String recipeType = type_spinner.getSelectedItem().toString();
        String recipeTheme = theme_spinner.getSelectedItem().toString();
        String mainIngr = main_ingr_spinner.getSelectedItem().toString();
        String addIngr = add_ingr_spinner.getSelectedItem().toString();
        String addIngr2 = add2_ingr_spinner.getSelectedItem().toString();
        String steps1 = step1.getText().toString().trim();
        String steps2 = step2.getText().toString().trim();
        String steps3 = step3.getText().toString().trim();
        String steps4 = step4.getText().toString().trim();
        String steps5 = step5.getText().toString().trim();

        if(!TextUtils.isEmpty(recipeName)){
            if(!TextUtils.isEmpty(steps1)) {

                String id = recipeDB.push().getKey();

                Recipe recipe = new Recipe(id, recipeName, recipeType, recipeTheme, mainIngr, addIngr, addIngr2, steps1, steps2, steps3, steps4, steps5);

                recipeDB.child("recipes").child(id).setValue(recipe);


                Toast.makeText(this, "Recipe added", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "You should add at least 1 step!", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "You should enter recipe name!", Toast.LENGTH_LONG).show();
        }
    }
}
