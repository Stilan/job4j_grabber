package ru.job4j.ood.lsp.food;


import java.util.List;

public interface FoodStorage {
     void add(Food food);
     boolean validate(Food food);
     List<Food> getFoodList();
}
