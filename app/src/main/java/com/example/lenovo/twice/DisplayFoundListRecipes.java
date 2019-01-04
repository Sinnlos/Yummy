package com.example.lenovo.twice;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DisplayFoundListRecipes extends AppCompatActivity {

    DatabaseReference recipeDB;

    ListView listViewFoundRecipes;
    List<Recipe> recipeFoundList;


    String searchType;
    String searchTheme;
    String searchMain;
    String searchAdd1;
    String searchAdd2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_found_list_recipes);

        listViewFoundRecipes = (ListView) findViewById(R.id.listViewFoundRecipes);

        recipeFoundList = new ArrayList<>();

        //SELECT * FROM Recipes
        //recipeDB = FirebaseDatabase.getInstance().getReference().child("recipes");
        //recipeDB.addValueEventListener(valueEventListener);

        String searchType = getIntent().getExtras().get("searchType").toString();
        String searchTheme = getIntent().getExtras().get("searchTheme").toString();
        String searchMain = getIntent().getExtras().get("searchMain").toString();
        String searchAdd1 = getIntent().getExtras().get("searchAdd1").toString();
        String searchAdd2 = getIntent().getExtras().get("searchAdd2").toString();

        Toast.makeText(this, searchType, Toast.LENGTH_LONG).show();

        //SELECT * FROM Recipes WHERE recipeTheme = "Kookie"
        Query query = FirebaseDatabase.getInstance().getReference("recipes")
                .orderByChild("recipeType")
                .equalTo(searchType);
        query.addListenerForSingleValueEvent(valueEventListener);


        listViewFoundRecipes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {

                String value = (String) adapter.getItemAtPosition(position);

                Recipe recipe = recipeFoundList.get(position);
                String name = recipe.getRecipeName();
                String type = recipe.getRecipeType();
                String theme = recipe.getRecipeTheme();
                String main = recipe.getMainIngr();
                String step1 = recipe.getSteps1();
                String step2 = recipe.getSteps2();
                String step3 = recipe.getSteps3();
                String step4 = recipe.getSteps4();
                String step5 = recipe.getSteps5();

                Intent move = new Intent(view.getContext(), RecipeDetails.class);
                move.putExtra("name", name);
                move.putExtra("type", type);
                move.putExtra("theme", theme);
                move.putExtra("main", main);
                move.putExtra("step1", step1);
                move.putExtra("step2", step2);
                move.putExtra("step3", step3);
                move.putExtra("step4", step4);
                move.putExtra("step5", step5);
                startActivity(move);
            }
        });

    }


    ValueEventListener valueEventListener = new ValueEventListener() {

        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            recipeFoundList.clear();
            String searchTheme = getIntent().getExtras().get("searchTheme").toString();
            String searchMain = getIntent().getExtras().get("searchMain").toString();
            String searchAdd1 = getIntent().getExtras().get("searchAdd1").toString();
            String searchAdd2 = getIntent().getExtras().get("searchAdd2").toString();

            for (DataSnapshot recipeSnapshot : dataSnapshot.getChildren()) {
                Recipe recipe = recipeSnapshot.getValue(Recipe.class);

                if ((recipe.recipeTheme.equals(searchTheme)) && (recipe.mainIngr.equals(searchMain)) &&
                        (recipe.addIngr.equals(searchAdd1) || recipe.addIngr.equals(searchAdd2))&&
                        (recipe.addIngr2.equals(searchAdd1) || recipe.addIngr2.equals(searchAdd2))) {

                    recipeFoundList.add(recipe);
                }


            }

            RecipeSearchedList adapter = new RecipeSearchedList(DisplayFoundListRecipes.this, recipeFoundList);
            listViewFoundRecipes.setAdapter(adapter);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };

}

