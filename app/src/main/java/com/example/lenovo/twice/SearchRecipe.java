package com.example.lenovo.twice;

import android.app.Service;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class SearchRecipe extends AppCompatActivity {

    Spinner spinner_search_type;
    Spinner spinner_search_theme;
    Spinner spinner_search_main;
    Spinner spinner_search_add1;
    Spinner spinner_search_add2;
    Button btn_search_recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_recipe);

        spinner_search_type = (Spinner) findViewById(R.id.spinner_search_type);
        spinner_search_theme = (Spinner) findViewById(R.id.spinner_search_theme);
        spinner_search_main = (Spinner) findViewById(R.id.spinner_search_main);
        spinner_search_add1 = (Spinner) findViewById(R.id.spinner_search_add1);
        spinner_search_add2 = (Spinner) findViewById(R.id.spinner_search_add2);
        btn_search_recipe = (Button) findViewById(R.id.btn_search_recipe);

        btn_search_recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String searchType = spinner_search_type.getSelectedItem().toString();
                String searchTheme = spinner_search_theme.getSelectedItem().toString();
                String searchMain = spinner_search_main.getSelectedItem().toString();
                String searchAdd1 = spinner_search_add1.getSelectedItem().toString();
                String searchAdd2 = spinner_search_add2.getSelectedItem().toString();

                Intent moveNext = new Intent(SearchRecipe.this, DisplayFoundListRecipes.class);
                moveNext.putExtra("searchType",searchType);
                moveNext.putExtra("searchTheme",searchTheme);
                moveNext.putExtra("searchMain",searchMain);
                moveNext.putExtra("searchAdd1",searchAdd1);
                moveNext.putExtra("searchAdd2",searchAdd2);
                startActivity(moveNext);

            }
        });


    }


}
