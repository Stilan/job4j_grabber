package ru.job4j.ood.lsp.tansport;

public class PassengerCars implements Car {

   private int size;

    public PassengerCars(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}
