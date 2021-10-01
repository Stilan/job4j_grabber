package ru.job4j.ood.lsp.tansport;

import java.util.List;

public class SimpleParking implements Parking {

    private Car car;
    private List<Car> carList;

    @Override
    public boolean toPark(Car car) {
        return false;
    }

    @Override
    public void add(Car car) {

    }
}
