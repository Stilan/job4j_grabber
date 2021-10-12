package ru.job4j.ood.dip;

/**
 *  Нарушен принцип DIP Модули верхнего уровня не должны зависеть от модулей нижнего уровня.
 *  И те и другие должны зависеть от абстракций. Мы зависим от реализации, а не от абстракции.
 */
public class Shop {

   private Clothes clothes;
   private Food food;

    class Food {

    }
    class Clothes {

    }
}
