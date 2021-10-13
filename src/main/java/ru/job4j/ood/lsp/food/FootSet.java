package ru.job4j.ood.lsp.food;

import java.util.HashSet;
import java.util.Set;

public class FootSet implements FoodSet {

    Set<Food> foodSet = new HashSet<>();

    @Override
    public boolean saveFood(Set<Food> set) {
        if (set == null) {
            return false;
        }
        foodSet.addAll(set);
        return true;
    }

    @Override
    public Set<Food> getFood() {
        return foodSet;
    }
}
