package web.services;

import web.models.Car;
import java.util.List;

public interface CarService {
    List<Car> getCars(Integer count);
    Integer getDecreasedCount(Integer count);
    Integer getIncreasedCount(Integer count);
}
