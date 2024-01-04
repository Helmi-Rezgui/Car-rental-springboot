package com.cars.cars.Repository;

import com.cars.cars.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends JpaRepository<Car,Integer> {

    List<Car> findAllByCarStatusTrue();
}
