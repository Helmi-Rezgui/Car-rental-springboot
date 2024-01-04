package com.cars.cars.Controller;

import com.cars.cars.Model.Booking;
import com.cars.cars.Model.Car;
import com.cars.cars.Service.BookingService;
import com.cars.cars.Service.CarService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;


@Controller
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private CarService carService;
    @Autowired
    private BookingService bookingService;


    @GetMapping("/")
    public ModelAndView GetHomeView(){
        ModelAndView modelAndView = new ModelAndView("home");
        logger.info("Someone in");
        return modelAndView;
    }

    @GetMapping("/cars")
    public ModelAndView GetAllCars(){
        ModelAndView modelAndView = new ModelAndView("cars");
        List<Car> carList = carService.findAllByCarStatusTrue();
        modelAndView.addObject("carList",carList);
        logger.info("User viewing available cars");
        return modelAndView;
    }
    @GetMapping("/orders")
    public ModelAndView GetMyOrders(@RequestParam Integer customerId){
        ModelAndView modelAndView = new ModelAndView("orders");
        List<Booking> bookingList = bookingService.FindAllByCustomerId(customerId);
        modelAndView.addObject("bookingList",bookingList);
        logger.info("User viewing orders");
        return modelAndView;
    }

    @GetMapping("/bookingform")
    public ModelAndView BookingCar(@RequestParam Integer carId){
        ModelAndView modelAndView = new ModelAndView("bookingform");
        Car car = carService.findCarById(carId);
        Booking booking = new Booking();
        booking.setCarId(car.getCarId());
        booking.setCustomerId(1);
        modelAndView.addObject("booking",booking);
        logger.info("Some user trying to rent a car");
        return modelAndView;
    }

    @PostMapping("/save-booking")
    public String SaveBooking(@ModelAttribute Booking booking, @RequestParam Integer carId){
        Car car = carService.findCarById(carId);
        car.setCarStatus(false);
        LocalDate dateBefore = LocalDate.parse(booking.getBookingDateFrom());
        LocalDate dateAfter = LocalDate.parse(booking.getBookingDateTo());
        long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
        if(noOfDaysBetween <1){
            booking.setTotalPrice(car.getCarPrice() );
        }
        else{
            booking.setTotalPrice(car.getCarPrice() * noOfDaysBetween);
        }

        booking.setCustomerId(1);
        booking.setCarId(carId);
        booking.setImage(car.getCarImage());
        booking.setPriceDay(car.getCarPrice());
        carService.SaveCar(car);
        bookingService.BookingSave(booking);
        logger.info("User rented a car");
        return "redirect:/cars";
    }

    @GetMapping("/update-booking")
    public ModelAndView UpdateBooking(@RequestParam Integer bookingId){
        ModelAndView modelAndView = new ModelAndView("update-booking");
        Booking booking = bookingService.FindBooking(bookingId);
        System.out.println(booking.getBookingId());
        modelAndView.addObject("booking",booking);
        logger.info("User trying to update booking");
        return modelAndView;
    }

    @PostMapping("/return-car")
    public String ReturnCar(@ModelAttribute Booking booking,@RequestParam Integer bookingId, @RequestParam Integer carId) {
        Booking booking1 = bookingService.FindBooking(bookingId);
        Car car = carService.findCarById(carId);
        car.setCarStatus(true);
        bookingService.DeleteBooking(booking1.getBookingId());
        carService.SaveCar(car);
        logger.info("User returned a car");
        return "redirect:/cars";
    }

    // Don't know why, But I got a big problem with update , it's like h2 make a new one, duplicate.
    // This is why I made this function!!
    @PostMapping("/save-update")
    public String SaveUpdate(@ModelAttribute Booking booking, @RequestParam Integer bookingId) {
        Booking booking1 = bookingService.FindBooking(bookingId);
        LocalDate dateBefore = LocalDate.parse(booking.getBookingDateFrom());
        LocalDate dateAfter = LocalDate.parse(booking.getBookingDateTo());
        long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
        if(noOfDaysBetween < 1) {
            booking1.setTotalPrice(booking1.getPriceDay());
        }
        else{
            booking1.setTotalPrice(booking1.getPriceDay() * noOfDaysBetween);
        }
        booking1.setBookingDateFrom(booking.getBookingDateFrom());
        booking1.setBookingDateTo(booking.getBookingDateTo());
        bookingService.BookingSave(booking1);
        logger.info("User updated booking");
        return "redirect:/cars";
    }




}
