package ru.job4j.ood.dip;

/**
 * Нарушен принцип DIP класс computerFactory в методи computerFactory зависим от класса Computer
 */
public class ComputerFactory {
    public Computer makeComputer() {
        return new Computer();
    }
    class Computer {

    }
}
