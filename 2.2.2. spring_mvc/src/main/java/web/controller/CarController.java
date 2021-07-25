package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.Car;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String printCar(HttpServletRequest request, ModelMap model) {
        String count = request.getParameter("count");
        if (count == null) {
            model.addAttribute("messages", Car.setCars);
        } else {
            model.addAttribute("messages", Car.getSetCars(Integer.parseInt(count)));
        }
        return "cars";
    }
}
