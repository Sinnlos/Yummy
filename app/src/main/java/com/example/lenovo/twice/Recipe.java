package com.example.lenovo.twice;

public class Recipe {

    String id;
    String recipeName;
    String recipeType;
    String recipeTheme;
    String mainIngr;
    String addIngr;
    String addIngr2;
    String steps1;
    String steps2;
    String steps3;
    String steps4;
    String steps5;

    public Recipe(){

    }

    public Recipe(String id, String recipeName, String recipeType, String recipeTheme, String mainIgrd, String addIgrd, String addIgrd2, String steps1, String steps2, String steps3, String steps4, String steps5) {
        this.id = id;
        this.recipeName = recipeName;
        this.recipeType = recipeType;
        this.recipeTheme = recipeTheme;
        this.mainIngr = mainIgrd;
        this.addIngr = addIgrd;
        this.addIngr2 = addIgrd2;
        this.steps1 = steps1;
        this.steps2 = steps2;
        this.steps3 = steps3;
        this.steps4 = steps4;
        this.steps5 = steps5;
    }

    public String getId() {
        return id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getRecipeType() {
        return recipeType;
    }

    public String getRecipeTheme() {
        return recipeTheme;
    }

    public String getMainIngr() {
        return mainIngr;
    }

    public String getAddIngr() {
        return addIngr;
    }

    public String getAddIngr2() {
        return addIngr2;
    }

    public String getSteps1() {
        return steps1;
    }

    public String getSteps2() {
        return steps2;
    }

    public String getSteps3() {
        return steps3;
    }

    public String getSteps4() {
        return steps4;
    }

    public String getSteps5() {
        return steps5;
    }
}
