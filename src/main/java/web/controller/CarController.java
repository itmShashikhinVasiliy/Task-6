package web.controller;

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

    @GetMapping
    public String index(ModelMap model, @RequestParam(value = "count", required = false) Integer count) {
        CarService carService = new CarServiceImpl();
        List<Car> cars = carService.getCars();
        model.addAttribute("count", "Count = " + count);
        if (count == null || count >= carService.getCarCount())
            count = carService.getCarCount();

        model.addAttribute("countPlusOne", Math.min(count + 1, carService.getCarCount()));
        model.addAttribute("countMinusOne", Math.max(count - 1, 0));
        model.addAttribute("cars", cars.subList(0, count));
        return "cars";
    }
}
