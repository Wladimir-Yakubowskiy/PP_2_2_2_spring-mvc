package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    @GetMapping(value = "/cars")
    public String countCars(@RequestParam(defaultValue = "0") int count, Model model) {
        CarService carService = new CarServiceImpl();
        List<Car> carList = carService.getCars(allCar(), count);
        model.addAttribute("carList", carList);
        return "cars";
    }

    public List<Car> allCar(){
        List<Car> carAllList = new ArrayList<>();
        carAllList.add(new Car("BMW", 220, 150));
        carAllList.add(new Car("Mercedes", 220, 150));
        carAllList.add(new Car("Toyota", 220, 150));
        carAllList.add(new Car("Toyota", 200, 150));
        carAllList.add(new Car("Toyota", 250, 150));
        return carAllList;
    }
}
