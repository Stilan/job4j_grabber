package ru.job4j.ood.lsp.food;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

public class Trash implements FoodStorage {

    private SetFood setFood;

    public Trash() {
        setFood = new SetFood();
    }

    @Override
    public void add(Food food) {
        setFood.saveFood(food);
    }

    @Override
    public boolean validate(Food food) {
        long diffDays = getDaysOfSinceCreation(food);
        if (diffDays > food.getExpiryDate()) {
            return true;
        }
        return false;
    }

    @Override
    public Set<Food> getSet() {
        return setFood.getFood();
    }

}
