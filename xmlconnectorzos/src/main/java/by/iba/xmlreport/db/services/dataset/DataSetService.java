package by.iba.xmlreport.db.services.dataset;

import by.iba.xmlreport.db.entities.promoting.DataSet;

import java.util.List;

public interface DataSetService {
    DataSet findById(long id);
    List<DataSet> findAll();
    void addOrUpdate(DataSet dataSet);
    void delete(DataSet dataSet);
    void delete(long id);
}
