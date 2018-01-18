package by.iba.xmlreport.db.dao;

import by.iba.xmlreport.db.entities.promoting.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromoteItemDAO extends JpaRepository<Item, Long> {
    Item findById(long id);
}
