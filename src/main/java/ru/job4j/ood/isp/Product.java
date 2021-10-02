package ru.job4j.ood.isp;

/**
 * Интерфейс содержит три метода с разными характеристиками 1 не все продукты имеют срок годности,
 * 2 есть бесплатные продукты, 3 не всегда нужен вес продукта
 */

public interface Product {
     void setShelfLife();
     void setPrice();
     void setWeight();
}
