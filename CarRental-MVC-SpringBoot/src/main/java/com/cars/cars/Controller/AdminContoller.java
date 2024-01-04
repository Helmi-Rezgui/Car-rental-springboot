package com.cars.cars.Controller;

import com.cars.cars.Model.Car;
import com.cars.cars.Model.Customer;
import com.cars.cars.Service.CarService;
import com.cars.cars.Service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminContoller {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private CarService carService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/admin/vehicles")
    public ModelAndView GetAllCarsForAdmin(){
        ModelAndView modelAndView = new ModelAndView("admin-cars");
        List<Car> carList = carService.GetAllCars();
        modelAndView.addObject("carList",carList);
        logger.info("Admin viewing cars");
        return modelAndView;
    }


    @GetMapping("/admin/add-vehicle")
    public ModelAndView AddCar(){
        ModelAndView modelAndView = new ModelAndView("new-car");
        Car car = new Car();
        modelAndView.addObject("car",car);
        logger.info("Admin trying to add a new car");
        return modelAndView;
    }

    @GetMapping("/admin/vehicle")
    public ModelAndView UpdateCarInfo(@RequestParam Integer carId){
        ModelAndView modelAndView = new ModelAndView("update-car");
        Car car = carService.findCarById(carId);
        modelAndView.addObject("car",car);
        logger.info("Admin trying to update a car");
        return modelAndView;
    }


    @GetMapping("error-delete")
    public ModelAndView DeleteError(){
        logger.info("Admin couldn't delete a car");
        return new ModelAndView("error-delete");
    }

    @GetMapping("delete-cars")
    public String DeleteCar(@RequestParam Integer carId){
        Car car = carService.findCarById(carId);
        if(car.isCarStatus()){
            carService.DeleteCar(carId);
            logger.info("Admin deleted a car with info " + " " + car.getCarName() + " " + car.getCarModel());
            return "redirect:/admin/vehicles";
        }
        else {
            return "redirect:/error-delete";
        }

    }
    @GetMapping("/admin/customers")
    public ModelAndView GetAllCustomers(){
        ModelAndView modelAndView = new ModelAndView("customers");
        List<Customer> customerList = customerService.GetAllCustomer();
        modelAndView.addObject("customerList",customerList);
        logger.info("Admin viewing customers");
        return modelAndView;
    }

    @GetMapping("/admin/customer/customer-id")
    public ModelAndView UpdateCustomer(@RequestParam int customerId){
        ModelAndView modelAndView = new ModelAndView("update-customer");
        Customer customer = customerService.FindCustomerById(customerId);
        modelAndView.addObject("customer",customer);
        logger.info("Admin trying to update a customer info");
        return modelAndView;
    }

    @GetMapping("delete/customer")
    public String DeleteCustomer(@RequestParam Integer customerId){
        Customer customer = customerService.FindCustomerById(customerId);
        customerService.DeleteCustomer(customer);
        logger.info("Admin deleted a customer");
        return "redirect:/admin/customers";
    }

    @GetMapping("/admin/new/customer")
    public ModelAndView AddCustomer(){
        ModelAndView modelAndView = new ModelAndView("new-customer");
        Customer customer = new Customer();
        modelAndView.addObject("customer",customer);
        logger.info("Admin trying to add  a new customer");
        return modelAndView;
    }


    @PostMapping("/save-customer")
    public String SaveCustomer(@ModelAttribute Customer customer){
        customerService.SaveCustomer(customer);
        logger.info("Admin saved some process about customers");
        return "redirect:/admin/customers";
    }

    @PostMapping("/save-cars")
    public String SaveCar(@ModelAttribute Car car){
        carService.SaveCar(car);
        logger.info("Admin saved some process about cars");
        return "redirect:/admin/vehicles";
    }


}
