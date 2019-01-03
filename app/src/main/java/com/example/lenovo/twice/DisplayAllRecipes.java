package com.example.lenovo.twice;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DisplayAllRecipes extends AppCompatActivity {

    DatabaseReference recipeDB;

    ListView listViewRecipes;
    List<Recipe> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_recipes);

        recipeDB = FirebaseDatabase.getInstance().getReference().child("recipes");

        listViewRecipes = (ListView) findViewById(R.id.listViewRecipes);

        recipeList = new ArrayList<>();

        listViewRecipes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {

               /* String variable;
                recipeDB = FirebaseDatabase.getInstance().getReference().child("recipeTheme");
                final Query query = recipeDB.orderByChild("recipeTheme");
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        int total = (int) dataSnapshot.getChildrenCount();
                        int i = 0;

                        for (DataSnapshot childSnapshot : dataSnapshot.getChildren()){
                            String variable = childSnapshot.child("recipeTheme").getValue(String.class);

                            Toast.makeText(this, variable, Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });*/



                String value = (String) adapter.getItemAtPosition(position);

                //Recipe recipe = adapter.getItemIdAtPosition(position);

                //recipeDB.child("recipes").child()

                Recipe recipe = recipeList.get(position);
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

    @Override
    protected void onStart() {
        super.onStart();

        recipeDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                recipeList.clear();
                for(DataSnapshot recipeSnapshot : dataSnapshot.getChildren()){
                    Recipe recipe = recipeSnapshot.getValue(Recipe.class);

                    recipeList.add(recipe);
                }

                RecipeList adapter = new RecipeList(DisplayAllRecipes.this, recipeList);
                listViewRecipes.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
