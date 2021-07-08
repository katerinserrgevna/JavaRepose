package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    User getUserByCar(String model, String series);
    List<User> listUsers();
}
