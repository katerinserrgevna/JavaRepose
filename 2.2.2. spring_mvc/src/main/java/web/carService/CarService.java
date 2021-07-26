package web.carService;

import web.model.Car;

import java.util.Set;

public class CarService {
    private Car car = new Car();

    public Set<Car> getSetCars(int count) {
        return car.getSetCars(count);
    }

    public Set<Car> getAllCars() {
        return car.setCars;
    }
}
