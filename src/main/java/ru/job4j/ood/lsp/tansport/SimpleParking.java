package ru.job4j.ood.lsp.tansport;

import java.util.ArrayList;
import java.util.List;

public class SimpleParking implements Parking {

    private Car car;
    private static int parkingSize;
    private static int occupiedSize;
    private List<Car> carList = new ArrayList<>();

    @Override
    public List<Car> getCarList() {
        return carList;
    }

    @Override
    public boolean toPark(Car car) {
        return true;
    }

    @Override
    public void add(Car car) {

    }
}
