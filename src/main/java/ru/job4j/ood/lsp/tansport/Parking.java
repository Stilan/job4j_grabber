package ru.job4j.ood.lsp.tansport;

import java.util.Scanner;

public class Parking {

    private Car car;

    public Parking(Car car) {
        this.car = car;
    }

    public boolean parked(Car car) {
        return true;
    }
}
