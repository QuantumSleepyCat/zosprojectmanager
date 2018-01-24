package by.iba.jpadb.db.dao;

import by.iba.jpadb.db.entities.promoting.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromoteItemDAO extends JpaRepository<Item, Long> {
    Item findById(long id);
}
