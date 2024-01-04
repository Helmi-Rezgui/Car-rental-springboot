package com.cars.cars.Repository;

import com.cars.cars.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Integer> {

    List<Booking> findAllByCustomerId(int customerId);
}
