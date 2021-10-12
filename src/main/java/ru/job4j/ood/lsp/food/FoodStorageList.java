package ru.job4j.ood.lsp.food;

import java.util.ArrayList;
import java.util.List;

public class FoodStorageList implements IControllQualitySet {

    List<FoodStorage> foodStorageList = new ArrayList<>();

    @Override
    public boolean saveList(FoodStorage foodStorage) {
        if ( foodStorage == null) {
            return false;
        }
        foodStorageList.add(foodStorage);
        return true;
    }

    @Override
    public List<FoodStorage> getFoodStorage() {
        return foodStorageList;
    }
}
