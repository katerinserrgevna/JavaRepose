package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.carService.CarService;
import web.model.Car;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String printCar(@RequestParam (value = "count", required = false) Integer count, ModelMap model) {
        CarService carService = new CarService();
        if (count == null) {
            model.addAttribute("messages", carService.getAllCars());
        } else {
            model.addAttribute("messages", carService.getSetCars(count));
        }
        return "cars";
    }
}
