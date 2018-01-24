package by.iba.jpadb.db.services.promoteinfo;

import by.iba.jpadb.db.dao.PromoteInfoDAO;
import by.iba.jpadb.db.dao.PromoteItemDAO;
import by.iba.jpadb.db.entities.promoting.Item;
import by.iba.jpadb.db.entities.promoting.PageInfoModel;
import by.iba.jpadb.db.services.promoteitem.PromoteItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PromoteInfoServiceImpl implements PromoteInfoService {

    @Autowired
    private PromoteInfoDAO promoteInfoDAO;
    @Autowired
    private PromoteItemService promoteItemService;

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
        for(Item item : pageInfoModel.getItems())
        {
            item.setPageInfoModel(pageInfoModel);
            promoteItemService.addOrUpdate(item);
        }
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
