package ru.job4j.ood.lsp.food;


public class ControllQuality {

   public ControllQualitySet controllQualitySet;
   public FoodSet iFoodSet;

   public ControllQuality(ControllQualitySet ifoodStorageList, FoodSet iFoodSet) {
       this.controllQualitySet = ifoodStorageList;
       this.iFoodSet = iFoodSet;
   }

    public void shelfLife(Food food) {
        for (FoodStorage foodStorage: controllQualitySet.getFoodStorage()) {
            if (foodStorage.validate(food)) {
                foodStorage.add(food);
            }
        }
    }

    public void resort() {
        for (FoodStorage foodStorage: controllQualitySet.getFoodStorage()) {
            if (foodStorage.getSet().size() > 0) {
               iFoodSet.saveFood(foodStorage.getSet());
            }
        }
        for (Food f: iFoodSet.getFood()) {
            shelfLife(f);
        }
    }
}
