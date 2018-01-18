package by.iba.xmlreport.db.promoteinfo;

import by.iba.xmlreport.db.entities.promoting.PromoteInfo;

import java.util.List;

public interface PromoteInfoService {
    PromoteInfo findById(long id);
    List<PromoteInfo> findAll();
    void addOrUpdate(PromoteInfo promoteInfo);
    void delete(PromoteInfo promoteInfo);
    void delete(long id);
}
