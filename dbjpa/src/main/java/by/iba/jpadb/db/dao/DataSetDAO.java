package by.iba.jpadb.db.dao;

import by.iba.jpadb.db.entities.promoting.DataSet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataSetDAO extends JpaRepository<DataSet,Long> {
    DataSet findById(long id);
}
