package by.iba.xmlreport.db.dao;

import by.iba.xmlreport.db.entities.PromoteInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoteInfoDAO extends JpaRepository<PromoteInfo,Long> {
    PromoteInfo findById(long id);
}
