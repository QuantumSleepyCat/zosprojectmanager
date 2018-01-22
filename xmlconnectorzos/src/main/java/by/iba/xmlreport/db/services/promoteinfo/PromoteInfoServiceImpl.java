package by.iba.xmlreport.db.services.promoteinfo;

import by.iba.xmlreport.db.dao.PromoteInfoDAO;
import by.iba.xmlreport.db.entities.promoting.PageInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PromoteInfoServiceImpl implements PromoteInfoService {

    @Autowired
    private PromoteInfoDAO promoteInfoDAO;

    @Override
    public PageInfoModel findById(long id) {
        return promoteInfoDAO.findById(id);
    }

    @Override
    public List<PageInfoModel> findAll() {
        return promoteInfoDAO.findAll();
    }

    @Override
    public void addOrUpdate(PageInfoModel pageInfoModel) {
        promoteInfoDAO.save(pageInfoModel);
    }

    @Override
    public void delete(PageInfoModel pageInfoModel) {
        promoteInfoDAO.delete(pageInfoModel);
    }

    @Override
    public void delete(long id) {
        promoteInfoDAO.delete(id);
    }
}
