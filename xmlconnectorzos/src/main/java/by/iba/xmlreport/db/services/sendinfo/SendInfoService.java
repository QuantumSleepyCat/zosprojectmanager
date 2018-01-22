package by.iba.xmlreport.db.services.sendinfo;

import by.iba.xmlreport.db.entities.promoting.SendInfo;

import java.util.List;

public interface SendInfoService {
    SendInfo findById(long id);
    List<SendInfo> findAll();
    void addOrUpdate(SendInfo sendInfo);
    void delete(SendInfo sendInfo);
    void delete(long id);
}
