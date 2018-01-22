package by.iba.xmlreport.db.dao;

import by.iba.xmlreport.db.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Long>{
    User findByLogin(String login);
    User findById(long id);
}
