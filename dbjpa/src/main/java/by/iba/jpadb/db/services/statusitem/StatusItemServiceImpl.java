package by.iba.jpadb.db.services.statusitem;

import by.iba.jpadb.db.dao.StatusItemDAO;
import by.iba.jpadb.db.entities.promoting.PageInfoModel;
import by.iba.jpadb.db.entities.promoting.StatusItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusItemServiceImpl implements StatusItemService{
    @Autowired
    private StatusItemDAO statusItemDAO;

    @Override
    public StatusItem findById(long id) {
        return statusItemDAO.findById(id);
    }

    @Override
    public StatusItem findByPageInfo(PageInfoModel pageInfoModel) {
        return statusItemDAO.findByPageInfoModel(pageInfoModel);
    }

    @Override
    public List<StatusItem> findAll() {
        return statusItemDAO.findAll();
    }

    @Override
    public void addOrUpdate(StatusItem statusItem) {
        statusItemDAO.save(statusItem);
    }

    @Override
    public void delete(StatusItem statusItem) {
        statusItemDAO.delete(statusItem);
    }

    @Override
    public void delete(long id) {
        statusItemDAO.delete(id);
    }
}
