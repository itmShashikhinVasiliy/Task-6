package web.services;

import web.models.Car;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {
    private final List<Car> cars = new ArrayList<>();

    private final Integer carCount;

    public Integer getCarCount() {
        return carCount;
    }

    public CarServiceImpl() {
        cars.add(new Car("Nissan", "Silvia", 2008));
        cars.add(new Car("Toyota", "MarkII", 2002));
        cars.add(new Car("Ford", "Focus", 2011));
        cars.add(new Car("Toyota", "Chaser", 1999));
        cars.add(new Car("VAZ", "2108", 1978));
        carCount = cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }
}
