package by.iba.jpadb.db.services.promoteinfo;

import by.iba.jpadb.db.entities.promoting.PageInfoModel;

import java.util.List;

public interface PromoteInfoService {
    PageInfoModel findById(long id);
    List<PageInfoModel> findAll();
    void addOrUpdate(PageInfoModel pageInfoModel);
    void delete(PageInfoModel pageInfoModel);
    void delete(long id);
}
