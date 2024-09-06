package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.services.CarService;
import web.services.CarServiceImpl;

import java.util.List;

@Controller
@RequestMapping("cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String index(ModelMap model, @RequestParam(value = "count", required = false) Integer count) {
        List<Car> cars = carService.getCars(count);
        model.addAttribute("count", "Count = " + count);
        model.addAttribute("countPlusOne", carService.getIncreasedCount(count));
        model.addAttribute("countMinusOne", carService.getDecreasedCount(count));
        model.addAttribute("cars", cars);
        return "cars";
    }
}
