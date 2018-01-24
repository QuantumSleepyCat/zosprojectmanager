package by.iba.jpadb.db.dao;

import by.iba.jpadb.db.entities.promoting.PageInfoModel;
import by.iba.jpadb.db.entities.promoting.StatusItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusItemDAO extends JpaRepository<StatusItem,Long>{
    StatusItem findById(long id);
    StatusItem findByPageInfoModel(PageInfoModel pageInfoModel);
}
