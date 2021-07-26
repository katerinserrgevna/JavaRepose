package web.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Car {
    private String model;
    private String series;
    private int year;

    static public Set<Car> setCars = new HashSet<>();
    static {
        setCars.add(new Car("BMW", "X6", 1999));
        setCars.add(new Car("Honda","CRV", 2007));
        setCars.add(new Car("Hyundai","Solaris", 2015));
        setCars.add(new Car("Lada", "Vesta", 1985));
        setCars.add(new Car("Porsche", "Cayenne", 2021));
    }

    public Car(String model, String series, int year) {
        this.model = model;
        this.series = series;
        this.year = year;
    }

    public Car() {

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

    public Set<Car> getSetCars (int count) {
        return setCars.stream().limit(count).collect(Collectors.toSet());
    }
}
