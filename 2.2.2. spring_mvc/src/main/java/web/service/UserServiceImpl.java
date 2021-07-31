package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.Users;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public List<Users> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public Users getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public void saveUser(Users users) {
        userDao.saveUser(users);
    }

    @Override
    @Transactional
    public Users update(Users users) {
        return userDao.update(users);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }
}
