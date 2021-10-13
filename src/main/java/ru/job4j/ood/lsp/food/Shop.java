package ru.job4j.ood.lsp.food;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

public class Shop implements FoodStorage  {

    private SetFood setFood;

    public Shop() {
        setFood = new SetFood();
    }

    @Override
    public void add(Food food) {
        setFood.saveFood(food);
    }

    @Override
    public boolean validate(Food food) {
        long diffDays = getDaysOfSinceCreation(food);
        if (diffDays > food.getExpiryDate() * 25L / 100 && diffDays < food.getExpiryDate() * 75L / 100) {
            return true;
        } else if (diffDays > food.getExpiryDate() * 75L / 100 && diffDays < food.getExpiryDate()) {
            food.setPrice(food.getPrice() - (food.getPrice() * food.getDiscount() / 100));
            return true;
        }
        return false;
    }

    @Override
    public Set<Food> getSet() {
        return setFood.getFood();
    }
}
