package by.iba.xmlreport.db.services.dataset;

import by.iba.xmlreport.db.dao.DataSetDAO;
import by.iba.xmlreport.db.entities.promoting.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataSetServiceImpl implements DataSetService {

    @Autowired
    private DataSetDAO dataSetDAO;

    @Override
    public DataSet findById(long id) {
        return dataSetDAO.findById(id);
    }

    @Override
    public List<DataSet> findAll() {
        return dataSetDAO.findAll();
    }

    @Override
    public void addOrUpdate(DataSet dataSet) {
        dataSetDAO.save(dataSet);
    }

    @Override
    public void delete(DataSet dataSet) {
        dataSetDAO.delete(dataSet);
    }

    @Override
    public void delete(long id) {
        dataSetDAO.delete(id);
    }
}
