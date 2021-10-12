package ru.job4j.ood.lsp.food;

import java.util.HashSet;
import java.util.Set;

public class SetFood implements IFoodStorageSet {
    Set<Food> foodSet = new HashSet<>();

    @Override
    public boolean saveFood(Food food) {
        if (food == null) {
            return false;
        }
        foodSet.add(food);
        return true;
    }

    @Override
    public Set<Food> getFood() {
        return foodSet;
    }
}
