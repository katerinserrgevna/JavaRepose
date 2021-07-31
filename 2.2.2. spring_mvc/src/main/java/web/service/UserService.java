package web.service;

import web.model.Users;

import java.util.List;

public interface UserService {
    List<Users> getAllUsers();
    Users getUser(int id);
    void saveUser(Users users);
    Users update(Users users);
    void delete(int id);
}
