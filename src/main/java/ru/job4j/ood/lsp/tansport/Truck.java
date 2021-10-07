package ru.job4j.ood.lsp.tansport;

public class Truck implements Car {

    private int size = 2;

    @Override
    public int getSize() {
        return size;
    }
}
