package ru.job4j.ood.lsp.food;

import java.util.List;

public interface ControllQualitySet {
    boolean saveList(FoodStorage foodStorage);
    List<FoodStorage> getFoodStorage();
}
