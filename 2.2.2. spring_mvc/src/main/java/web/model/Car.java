package web.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Car {
    private String model;
    private String series;
    private int year;

    static private List<Car> listCars = new ArrayList<>();
    static {
        listCars.add(new Car("BMW", "X6", 1999));
        listCars.add(new Car("Honda","CRV", 2007));
        listCars.add(new Car("Hyundai","Solaris", 2015));
        listCars.add(new Car("Lada", "Vesta", 1985));
        listCars.add(new Car("Porsche", "Cayenne", 2021));
    }

    public Car(String model, String series, int year) {
        this.model = model;
        this.series = series;
        this.year = year;
    }

    public Car() {

    }

    public void addCar(Car car) {
        this.listCars.add(car);
    }

    public List<Car> getSetCars() {
        return this.listCars;
    }

    public String getModel() {
        return this.model;
    }

    public String getSeries() {
        return this.series;
    }

    public int getYear() {
        return this.year;
    }

    public List<Car> getSetCars (int count) {
        return listCars.stream().limit(count).collect(Collectors.toList());
    }
}
