package by.iba.xmlreport.db.services.promoteinfo;

import by.iba.xmlreport.db.dao.PromoteInfoDAO;
import by.iba.xmlreport.db.entities.promoting.PromoteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromoteInfoServiceImpl implements PromoteInfoService {

    @Autowired
    private PromoteInfoDAO promoteInfoDAO;

    @Override
    public PromoteInfo findById(long id) {
        return promoteInfoDAO.findById(id);
    }

    @Override
    public List<PromoteInfo> findAll() {
        return promoteInfoDAO.findAll();
    }

    @Override
    public void addOrUpdate(PromoteInfo promoteInfo) {
        promoteInfoDAO.save(promoteInfo);
    }

    @Override
    public void delete(PromoteInfo promoteInfo) {
        promoteInfoDAO.delete(promoteInfo);
    }

    @Override
    public void delete(long id) {
        promoteInfoDAO.delete(id);
    }
}
