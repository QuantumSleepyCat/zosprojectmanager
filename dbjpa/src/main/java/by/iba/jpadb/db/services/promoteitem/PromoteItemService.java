package by.iba.jpadb.db.services.promoteitem;



import by.iba.jpadb.db.entities.promoting.Item;

import java.util.List;

public interface PromoteItemService {
    Item findById(long id);
    List<Item> findAll();
    void addOrUpdate(Item item);
    void delete(Item item);
    void delete(long id);
}
