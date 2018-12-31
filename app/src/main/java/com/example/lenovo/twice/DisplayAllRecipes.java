package com.example.lenovo.twice;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
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

        recipeDB = FirebaseDatabase.getInstance().getReference();

        listViewRecipes = (ListView) findViewById(R.id.listViewRecipes);

        recipeList = new ArrayList<>();


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
