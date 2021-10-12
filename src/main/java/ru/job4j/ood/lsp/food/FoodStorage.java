package ru.job4j.ood.lsp.food;


import java.util.List;
import java.util.Set;

public interface FoodStorage {
     void add(Food food);
     boolean validate(Food food);
     Set<Food> getSet();
}
