package ru.job4j.ood.lsp.food;

import java.util.Calendar;
import java.util.List;

public class Shop implements FoodStorage {

    private  List<Food> foodList;

    public Shop(List<Food> foodList) {
        this.foodList = foodList;
    }

    @Override
    public void add(Food food) {
        foodList.add(food);
        System.out.println("s");
    }

    @Override
    public boolean validate(Food food) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = food.getCreateDate();
        long milliseconds1 = calendar1.getTimeInMillis();
        long milliseconds2 = calendar2.getTimeInMillis();
        long diff = milliseconds1 - milliseconds2;
        int diffDays = (int) diff / (24 * 60 * 60 * 1000);
        if (diffDays > food.getExpiryDate() * 25 / 100 && diffDays < food.getExpiryDate() * 75 / 100) {
            foodList.add(food);
            return true;
        } else if (diffDays > food.getExpiryDate() * 75 / 100 && diffDays < food.getExpiryDate()) {
            food.setPrice(food.getPrice() - (food.getPrice() * food.getDiscount() / 100));
            foodList.add(food);
            return true;
        }
        return false;
    }
}
