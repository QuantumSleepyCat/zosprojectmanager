package by.iba.xmlreport.db.dao;

import by.iba.xmlreport.db.entities.promoting.DataSet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataSetDAO extends JpaRepository<DataSet,Long> {
}
