package web.services;

import web.models.Car;
import java.util.List;

public interface CarService {
    Integer getCarCount();
    List<Car> getCars();
}
