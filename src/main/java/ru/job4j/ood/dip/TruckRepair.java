package ru.job4j.ood.dip;

import java.util.ArrayList;
import java.util.List;

/**
 * Нарушен принцип DIP класс TruckRepair зависит от реализации truckList.
 */
public class TruckRepair {
    List<Truck> truckList = new ArrayList<>();

    class Truck {

    }
}
