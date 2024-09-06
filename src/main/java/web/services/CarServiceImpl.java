package web.services;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import web.models.Car;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final List<Car> cars = new ArrayList<>();

    public CarServiceImpl() {
        cars.add(new Car("Nissan", "Silvia", 2008));
        cars.add(new Car("Toyota", "MarkII", 2002));
        cars.add(new Car("Ford", "Focus", 2011));
        cars.add(new Car("Toyota", "Chaser", 1999));
        cars.add(new Car("VAZ", "2108", 1978));
    }

    @Override
    public List<Car> getCars(Integer count) {
        return (isCountValid(count)) ? cars.subList(0, count) : cars;
    }

    @Override
    public Integer getDecreasedCount(Integer count) {
        return (isCountValid(count))
                ? Math.max(count - 1, 0)
                : cars.size() - 1;
    }

    @Override
    public Integer getIncreasedCount(Integer count) {
        return (isCountValid(count))
                ? Math.min(count + 1, cars.size())
                : cars.size();
    }

    private boolean isCountValid(Integer count) {
        return count != null && count >= 0 && count <= cars.size();
    }
}
