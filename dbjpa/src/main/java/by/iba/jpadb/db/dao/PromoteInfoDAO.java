package by.iba.jpadb.db.dao;

import by.iba.jpadb.db.entities.promoting.PageInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoteInfoDAO extends JpaRepository<PageInfoModel,Long> {
    PageInfoModel findById(long id);
}
