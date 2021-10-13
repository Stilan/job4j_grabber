package ru.job4j.ood.lsp.food;

import java.util.Calendar;

public class Strategy {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.SEPTEMBER, 10);
        Food food = new Bread("Хлеб", 20, calendar, 25, 30);
        FoodStorage foodStorageW = new Warehouse();
        FoodStorage foodStorageS = new Shop();
        FoodStorage foodStorageT = new Trash();
        FoodStorageList foodStorageList = new FoodStorageList();
        foodStorageList.saveList(foodStorageW);
        foodStorageList.saveList(foodStorageS);
        foodStorageList.saveList(foodStorageT);
        FoodSet iFoodSet = new FootSet();
        ControllQuality controllQuality = new ControllQuality(foodStorageList, iFoodSet);
        controllQuality.shelfLife(food);
        controllQuality.resort();
        System.out.println(foodStorageT.getSet().toString());

    }
}
