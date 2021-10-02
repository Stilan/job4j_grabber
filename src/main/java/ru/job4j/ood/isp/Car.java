package ru.job4j.ood.isp;

/**
 * Интерфейс содержит два метода с разными характеристиками 1 метод получить количество топлива в баке подходит для автомобилей на бензине,
 * 2 количество заряда батареи подходит для электромобилей
 */
public interface Car  {
    void getFuelLiters();
    void getBatteryCharge();
    boolean carIsStarted();
    boolean moving();

      class  ElectricCar implements Car {


          @Override
          public void getFuelLiters() {
              System.out.println();
          }

          @Override
          public void getBatteryCharge() {
              System.out.println();
          }

          @Override
          public boolean carIsStarted() {
              return false;
          }

          @Override
          public boolean moving() {
              return false;
          }
      }
}
