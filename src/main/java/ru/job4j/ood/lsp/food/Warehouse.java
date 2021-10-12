package ru.job4j.ood.lsp.food;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;


public class Warehouse implements FoodStorage {


    private SetFood setFood;

    public Warehouse(){
        setFood = new SetFood();
    }

    @Override
    public void add(Food food) {
        setFood.saveFood(food);
    }

    @Override
    public boolean validate(Food food) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = food.getCreateDate();
        long milliseconds1 = calendar1.getTimeInMillis();
        long milliseconds2 = calendar2.getTimeInMillis();
        long diff = milliseconds1 - milliseconds2;
        long diffDays = diff / (24 * 60 * 60 * 1000);
        if (diffDays <= food.getExpiryDate() / 4) {
            return true;
        }
        return false;
    }
    @Override
    public Set<Food> getSet() {
        return setFood.getFood();
    }
}
