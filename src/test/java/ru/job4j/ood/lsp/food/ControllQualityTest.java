package ru.job4j.ood.lsp.food;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ControllQualityTest {

    @Test
    public void distributionOfProductsToStoragesTest1() {
        FoodStorage foodStorageW = new Warehouse();
        FoodStorage foodStorageS = new Shop();
        FoodStorage foodStorageT = new Trash();
        FoodStorageList IfoodStorageList = new FoodStorageList();
        IfoodStorageList.saveList(foodStorageW);
        IfoodStorageList.saveList(foodStorageS);
        IfoodStorageList.saveList(foodStorageT);
        IFoodSet iFoodSet = new FootSet();
        ControllQuality controllQuality = new ControllQuality(IfoodStorageList,iFoodSet);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.OCTOBER, 6);
        Food food = new Bread("Хлеб", 30, calendar, 25, 30);
        controllQuality.shelfLife(food);
        FoodStorage foodStorage = new Warehouse();
        foodStorage.add(food);
        assertThat(foodStorageW.getSet(), is(foodStorage.getSet()));
    }

    @Test
    public void distributionOfProductsToStoragesTest2() {
        FoodStorage foodStorageW = new Warehouse();
        FoodStorage foodStorageS = new Shop();
        FoodStorage foodStorageT = new Trash();
        FoodStorageList foodStorageList = new FoodStorageList();
        foodStorageList.saveList(foodStorageW);
        foodStorageList.saveList(foodStorageS);
        foodStorageList.saveList(foodStorageT);
        IFoodSet iFoodSet = new FootSet();
        ControllQuality controllQuality = new ControllQuality(foodStorageList, iFoodSet);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.SEPTEMBER, 18);
        Food food = new Bread("Хлеб", 30, calendar, 25, 20);
        controllQuality.shelfLife(food);
        Shop shop = new Shop();
        shop.add(food);
        assertThat(foodStorageS.getSet(), is(shop.getSet()));
    }

    @Test
    public void distributionOfProductsToStoragesTest3() {
        FoodStorage foodStorageW = new Warehouse();
        FoodStorage foodStorageS = new Shop();
        FoodStorage foodStorageT = new Trash();
        FoodStorageList foodStorageList = new FoodStorageList();
        foodStorageList.saveList(foodStorageW);
        foodStorageList.saveList(foodStorageS);
        foodStorageList.saveList(foodStorageT);
        IFoodSet iFoodSet = new FootSet();
        ControllQuality controllQuality = new ControllQuality(foodStorageList, iFoodSet);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.SEPTEMBER, 1);
        Food food = new Bread("Хлеб", 20, calendar, 25, 20);
        controllQuality.shelfLife(food);
        FoodStorage foodStorage = new Trash();
        foodStorage.add(food);
        assertThat(foodStorageT.getSet(), is(foodStorage.getSet()));
    }
}