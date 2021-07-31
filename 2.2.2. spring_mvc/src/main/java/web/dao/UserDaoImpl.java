package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Users;

import javax.persistence.*;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public Users getUser (int id) {
        TypedQuery<Users> typeQ = entityManager.createQuery(
                "SELECT u FROM Users u WHERE u.id = :id",
                Users.class
        );
        typeQ.setParameter("id", id);
        return typeQ.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public List<Users> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM Users u", Users.class).getResultList();
    }

    @Override
    @Transactional
    public void saveUser(Users user) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("ХАХА! " + e.getMessage());
        }
    }

    @Override
    public Users update(Users users) {
        return entityManager.merge(users);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(getUser(id));
    }
}
