package ru.job4j.ood.lsp.tansport;

import java.util.ArrayList;
import java.util.List;

public class SimpleParking implements Parking {

    private List<Car> carList = new ArrayList<>();
    private  int placeOfTrucks;
    private  int placeOfCar;

    public SimpleParking(int placeOfTrucks, int placeOfCar) {
        this.placeOfTrucks = placeOfTrucks;
        this.placeOfCar = placeOfCar;
    }

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
