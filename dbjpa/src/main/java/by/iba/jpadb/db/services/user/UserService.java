package by.iba.jpadb.db.services.user;

import by.iba.jpadb.db.entities.User;

import java.util.List;

public interface UserService {
    User findByLogin(String login);
    User findById(long id);
    List<User> findAll();
    void addOrUpdate(User user);
    void delete(User user);
    void delete(long id);
}
