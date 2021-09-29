package ru.job4j.ood.ocp;

/**
 *  Класс программист спроектирован неверно если нам нужно создать класс строитель у него тоже есть метод навыки,
 *  нужен интерфейс.
 */
public class ProfessionsInheritance2 {

    public static class Programmer {
        public String skills() {
            return "...";
        }
    }

    public static void main(String[] args) {
        Programmer programmer = new Programmer();
        System.out.println(programmer);
    }
}
