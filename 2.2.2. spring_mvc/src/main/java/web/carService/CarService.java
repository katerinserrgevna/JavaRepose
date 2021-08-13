package web.carService;

import web.model.Car;

import java.util.List;
import java.util.Set;

public class CarService {
    static private Car car = new Car();

    public List<Car> getSetCars(int count) {
        return car.getSetCars(count);
    }

    public List<Car> getAllCars() {
        return car.getSetCars();
    }

    static private void initCars() {
        car.addCar(new Car("BMW", "X6", 1999));
        car.addCar(new Car("Honda","CRV", 2007));
        car.addCar(new Car("Hyundai","Solaris", 2015));
        car.addCar(new Car("Lada", "Vesta", 1985));
        car.addCar(new Car("Porsche", "Cayenne", 2021));
    }
}
