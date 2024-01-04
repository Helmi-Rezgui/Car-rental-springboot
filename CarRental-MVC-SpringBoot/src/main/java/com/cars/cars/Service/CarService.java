package com.cars.cars.Service;

import com.cars.cars.Model.Car;
import com.cars.cars.Repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService implements CarServices{

    @Autowired
    private CarRepo carRepo;

    @Override
    public List<Car> findAllByCarStatusTrue() {
        return carRepo.findAllByCarStatusTrue();
    }

    @Override
    public List<Car> GetAllCars() {
        return carRepo.findAll();
    }

    @Override
    public Car findCarById(int carId) {
        Optional<Car> optional = carRepo.findById(carId);
        Car car;
        if (optional.isPresent()) {
            car = optional.get();
        }
        else {
            throw new RuntimeException(
                    "Car not found for id : " + carId);
        }
        return car;

    }

    @Override
    public void SaveCar(Car car) {
        carRepo.save(car);
    }

    @Override
    public void DeleteCar(int carId) {
        carRepo.deleteById(carId);
    }


}
