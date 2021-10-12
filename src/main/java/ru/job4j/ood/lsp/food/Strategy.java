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
        FoodStorageList IfoodStorageList = new FoodStorageList();
        IfoodStorageList.saveList(foodStorageW);
        IfoodStorageList.saveList(foodStorageS);
        IfoodStorageList.saveList(foodStorageT);
        IFoodSet iFoodSet = new FootSet();
        ControllQuality controllQuality = new ControllQuality(IfoodStorageList,iFoodSet);
        controllQuality.shelfLife(food);
        controllQuality.resort();
        System.out.println(foodStorageT.getSet().toString());

    }
}
