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
        List<FoodStorage> foodStorageList = List.of(foodStorageW, foodStorageS, foodStorageT);
        ControllQuality controllQuality = new ControllQuality(foodStorageList);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.SEPTEMBER, 30);
        Food food = new Bread("Хлеб", 20, calendar, 25, 30);
        controllQuality.shelfLife(food);
        FoodStorage foodStorage = new Warehouse();
        foodStorage.add(food);
        assertThat(foodStorageW.getFoodList(), is(foodStorage.getFoodList()));
    }

    @Test
    public void distributionOfProductsToStoragesTest2() {
        FoodStorage foodStorageW = new Warehouse();
        FoodStorage foodStorageS = new Shop();
        FoodStorage foodStorageT = new Trash();
        List<FoodStorage> foodStorageList = List.of(foodStorageW, foodStorageS, foodStorageT);
        ControllQuality controllQuality = new ControllQuality(foodStorageList);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.SEPTEMBER, 18);
        Food food = new Bread("Хлеб", 20, calendar, 25, 20);
        controllQuality.shelfLife(food);
        Shop shop = new Shop();
        shop.add(food);
        assertThat(foodStorageS.getFoodList(), is(shop.getFoodList()));
    }

    @Test
    public void distributionOfProductsToStoragesTest3() {
        FoodStorage foodStorageW = new Warehouse();
        FoodStorage foodStorageS = new Shop();
        FoodStorage foodStorageT = new Trash();
        List<FoodStorage> foodStorageList = List.of(foodStorageW, foodStorageS, foodStorageT);
        ControllQuality controllQuality = new ControllQuality(foodStorageList);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.SEPTEMBER, 1);
        Food food = new Bread("Хлеб", 20, calendar, 25, 20);
        controllQuality.shelfLife(food);
        FoodStorage foodStorage = new Trash();
        foodStorage.add(food);
        assertThat(foodStorageT.getFoodList(), is(foodStorage.getFoodList()));
    }
}