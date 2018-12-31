package com.example.lenovo.twice;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class RecipeList extends ArrayAdapter<Recipe> {

    private Activity context;
    private List<Recipe> recipeList;

    public RecipeList(Activity context, List<Recipe> recipeList){
        super(context, R.layout.list_view, recipeList);
        this.context = context;
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_view,null, true);
        TextView textViewRecipeName = (TextView) listViewItem.findViewById(R.id.textViewRecipeName);
        TextView textViewRecipeType = (TextView) listViewItem.findViewById(R.id.textViewRecipeType);

        Recipe recipe = recipeList.get(position);
        textViewRecipeName.setText(recipe.getRecipeName());
        textViewRecipeType.setText(recipe.getRecipeType());




        return listViewItem;
    }
}
