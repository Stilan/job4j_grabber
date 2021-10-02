package ru.job4j.ood.lsp.tansport;

import java.util.List;

public interface Parking {
    boolean toPark(Car car);
    void add(Car car);
    List<Car> getCarList();
}
