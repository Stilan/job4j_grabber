package ru.job4j.ood.lsp.food;

import java.util.Calendar;
import java.util.Set;

public interface FoodStorage {
     void add(Food food);
     boolean validate(Food food);
     Set<Food> getSet();

      default long getDaysOfSinceCreation(Food food) {
          Calendar calendar1 = Calendar.getInstance();
          Calendar calendar2 = food.getCreateDate();
          long milliseconds1 = calendar1.getTimeInMillis();
          long milliseconds2 = calendar2.getTimeInMillis();
          long diff = milliseconds1 - milliseconds2;
          return diff / (24 * 60 * 60 * 1000);
     }
}
