package com.cars.cars.Service;

import com.cars.cars.Model.Car;

import java.util.List;

public interface CarServices {
    List<Car> findAllByCarStatusTrue();
    List<Car> GetAllCars();
    Car findCarById(int carId);
    void SaveCar(Car car);
    void DeleteCar(int carId);

}
