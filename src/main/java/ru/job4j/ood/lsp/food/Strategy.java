package ru.job4j.ood.lsp.food;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Strategy {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.SEPTEMBER, 10);
        Food food = new Bread("Хлеб", 20, calendar, 25, 30);
        FoodStorage foodStorageW = new Warehouse();
        FoodStorage foodStorageS = new Shop();
        FoodStorage foodStorageT = new Trash();
        List<FoodStorage> foodStorageList = List.of(foodStorageW, foodStorageS, foodStorageT);
        ControllQuality controllQuality = new ControllQuality(foodStorageList);
        controllQuality.shelfLife(food);
        System.out.println(foodStorageT.getFoodList().toString());

    }
}
