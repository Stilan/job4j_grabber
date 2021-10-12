package ru.job4j.ood.lsp.food;

import java.util.List;
import java.util.Set;

public interface IFoodSet {
    boolean saveFood(Set<Food> set);
    Set<Food> getFood();
}
