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
        if (car.getSize() == 1) {
            if (placeOfCar > 0) {
                placeOfCar--;
                return true;
            }
        } else if (car.getSize() > 1) {
            if (placeOfTrucks > 0) {
                placeOfTrucks--;
                return true;
            } else if (placeOfCar > 0) {
                placeOfCar -= car.getSize();
                return true;
            }
        }
        return false;
    }


    @Override
    public void add(Car car) {
        if (toPark(car)) {
            carList.add(car);
        }
    }
}
