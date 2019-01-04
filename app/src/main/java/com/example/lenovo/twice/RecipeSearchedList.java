package com.example.lenovo.twice;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class RecipeSearchedList extends ArrayAdapter<Recipe> {

    private Activity context;
    private List<Recipe> recipeList;

    public RecipeSearchedList(Activity context, List<Recipe> recipeList){
        super(context, R.layout.list_view_just_name, recipeList);
        this.context = context;
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_view_just_name,null, true);
        TextView textViewFoundRecipeName = (TextView) listViewItem.findViewById(R.id.textViewFoundRecipeName);


        Recipe recipe = recipeList.get(position);
        textViewFoundRecipeName.setText(recipe.getRecipeName());





        return listViewItem;
    }
}

