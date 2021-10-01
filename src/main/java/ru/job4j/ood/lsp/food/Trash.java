package ru.job4j.ood.lsp.food;

import java.util.Calendar;
import java.util.List;

public class Trash implements FoodStorage {

    private  List<Food> foodList;

    public Trash(List<Food> foodList) {
        this.foodList = foodList;
    }

    @Override
    public void add(Food food) {
        foodList.add(food);
    }

    @Override
    public boolean validate(Food food) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = food.getCreateDate();
        long milliseconds1 = calendar1.getTimeInMillis();
        long milliseconds2 = calendar2.getTimeInMillis();
        long diff = milliseconds1 - milliseconds2;
        long diffDays =  diff / (24 * 60 * 60 * 1000);
        if (diffDays > food.getExpiryDate()) {
            return true;
        }
        return false;
    }

    @Override
    public List<Food> getFoodList() {
        return foodList;
    }
}
