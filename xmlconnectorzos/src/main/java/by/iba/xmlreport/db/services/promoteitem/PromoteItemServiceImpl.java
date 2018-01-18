package by.iba.xmlreport.db.services.promoteitem;


import by.iba.xmlreport.db.dao.PromoteItemDAO;
import by.iba.xmlreport.db.entities.promoting.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromoteItemServiceImpl implements PromoteItemService{

    @Autowired
    private PromoteItemDAO promoteItemDAO;

    @Override
    public Item findById(long id) {
        return promoteItemDAO.findById(id);
    }

    @Override
    public List<Item> findAll() {
        return promoteItemDAO.findAll();
    }

    @Override
    public void addOrUpdate(Item item) {
        promoteItemDAO.save(item);
    }

    @Override
    public void delete(Item item) {
        promoteItemDAO.delete(item);
    }

    @Override
    public void delete(long id) {
        promoteItemDAO.delete(id);
    }
}
