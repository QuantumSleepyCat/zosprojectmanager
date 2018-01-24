package by.iba.jpadb.db.services.sendinfo;

import by.iba.jpadb.db.dao.SendInfoDAO;
import by.iba.jpadb.db.entities.promoting.SendInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendInfoServiceImpl implements SendInfoService {

    @Autowired
    private SendInfoDAO sendInfoDAO;

    @Override
    public SendInfo findById(long id) {
        return sendInfoDAO.findById(id);
    }

    @Override
    public List<SendInfo> findAll() {
        return sendInfoDAO.findAll();
    }

    @Override
    public void addOrUpdate(SendInfo sendInfo) {
        sendInfoDAO.save(sendInfo);
    }

    @Override
    public void delete(SendInfo sendInfo) {
        sendInfoDAO.delete(sendInfo);
    }

    @Override
    public void delete(long id) {
        sendInfoDAO.delete(id);
    }
}
