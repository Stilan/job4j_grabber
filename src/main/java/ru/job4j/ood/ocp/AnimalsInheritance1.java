package ru.job4j.ood.ocp;

/**
 * Код спроектирован неверно класс КОТ неспособен на расширения.
 * Если нам надо создать класс собака она тоже может издавать звуки, но это разные животные
 * нужен интерфейс животные.
 */
public class AnimalsInheritance1 {

    public static class Cat {
        public String theSounds() {
            return "...";
        }
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println(cat);
    }
}
