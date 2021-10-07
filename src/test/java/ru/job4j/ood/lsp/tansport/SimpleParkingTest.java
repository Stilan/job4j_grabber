package ru.job4j.ood.lsp.tansport;

import org.junit.Test;

import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleParkingTest  {


     @Test
    public void toParkTest() {
          SimpleParking simpleParking = new SimpleParking(43, 50);
          Car car1 = new Truck();
          Car car2 = new PassengerCars();
          assertThat(simpleParking.toPark(car1), is(true));
          assertThat(simpleParking.toPark(car2), is(true));
     }


     @Test
     public void addTest() {
          SimpleParking simpleParking = new SimpleParking(12, 13);
          Car car1 = new Truck();
          Car car2 = new PassengerCars();
          simpleParking.add(car1);
          simpleParking.add(car2);
          List<Car> carList = List.of(car1, car2);
          assertThat(simpleParking.getCarList(), is(carList));
     }

    @Test
    public void whenAllTakePlaceOnPassengerPlaces() {
        SimpleParking simpleParking = new SimpleParking(0, 8);
        Car car1 = new Truck();
        Car car2 = new PassengerCars();
        Car car3 = new Truck();
        Car car4 = new PassengerCars();
        Car car5 = new Truck();
        Car car6 = new PassengerCars();
        assertThat(simpleParking.toPark(car1), is(true));
        assertThat(simpleParking.toPark(car2), is(true));
        assertThat(simpleParking.toPark(car3), is(true));
        assertThat(simpleParking.toPark(car4), is(true));
        assertThat(simpleParking.toPark(car5), is(true));
        assertThat(simpleParking.toPark(car6), is(false));
    }

}