package ru.job4j.ood.lsp.food;

import java.util.List;

public interface IControllQualitySet {
    boolean saveList(FoodStorage foodStorage);
    List<FoodStorage> getFoodStorage();
}
