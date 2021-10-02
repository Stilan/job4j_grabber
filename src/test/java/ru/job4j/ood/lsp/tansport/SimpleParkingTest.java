package ru.job4j.ood.lsp.tansport;


import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleParkingTest  {
     @Ignore
     @Test
    public void toParkTest() {
          SimpleParking simpleParking = new SimpleParking();
          Car car1 = new Truck(5);
          Car car2 = new PassengerCars(1);
          assertThat(simpleParking.toPark(car1), is(true));
          assertThat(simpleParking.toPark(car2), is(true));
     }
    @Ignore
     @Test
     public void addTest() {
          SimpleParking simpleParking = new SimpleParking();
          Car car1 = new Truck(5);
          Car car2 = new PassengerCars(1);
          simpleParking.add(car1);
          simpleParking.add(car2);
          List<Car> carList = List.of(car1, car2);
          assertThat(simpleParking.getCarList(), is(carList));
     }
}