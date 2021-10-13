package ru.job4j.ood.lsp.food;

import java.util.List;
import java.util.Set;

public interface FoodStorageSet {
    boolean saveFood(Food food);
    Set<Food> getFood();
}
