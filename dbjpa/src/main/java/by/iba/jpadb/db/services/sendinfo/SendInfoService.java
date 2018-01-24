package by.iba.jpadb.db.services.sendinfo;

import by.iba.jpadb.db.entities.promoting.SendInfo;

import java.util.List;

public interface SendInfoService {
    SendInfo findById(long id);
    List<SendInfo> findAll();
    void addOrUpdate(SendInfo sendInfo);
    void delete(SendInfo sendInfo);
    void delete(long id);
}
