package ru.job4j.ood.lsp.food;

import java.util.List;

public class ControllQuality {

   private List<FoodStorage> foodStorageList;

    public ControllQuality(List<FoodStorage> foodStorageList) {
        this.foodStorageList = foodStorageList;
    }

    public void shelfLife(Food food) {
        for (FoodStorage foodStorage: foodStorageList) {
            if (foodStorage.validate(food)) {
                foodStorage.add(food);
            }
        }

    }
}
