package ru.job4j.ood.ocp;

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
