package by.iba.jpadb.db.dao;

import by.iba.jpadb.db.entities.promoting.SendInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SendInfoDAO extends JpaRepository<SendInfo,Long> {
    SendInfo findById(long id);
}
