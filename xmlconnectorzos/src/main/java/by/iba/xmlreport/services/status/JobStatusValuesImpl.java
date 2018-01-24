package by.iba.xmlreport.services.status;


import by.iba.jpadb.db.entities.promoting.StatusItem;
import by.iba.jpadb.db.services.facade.DBServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobStatusValuesImpl implements JobStatusValues {

    @Autowired
    private DBServices dbServices;
    @Override
    public void updateStatus() {

            try {
                for (StatusItem statusItem : dbServices.getStatusItemService().findAll()) {
                    if (statusItem.getStatus().equals("Approved")) {
                        statusItem.setStyleClass("list-group-item list-group-item-action list-group-item-success");
                    } else if (statusItem.getStatus().equals("Rejected")) {
                        statusItem.setStyleClass("list-group-item list-group-item-action list-group-item-danger");
                    }
                    dbServices.getStatusItemService().addOrUpdate(statusItem);
                }
            }
            catch (Exception ex)
            {
                System.err.println(ex.getMessage());
            }

    }

    @Override
    public void updateStatusById(long id) {
         try {
              StatusItem statusItem = dbServices.getStatusItemService()
                      .findById(id);
                 if (statusItem.getStatus().equals("Approved")) {
                     statusItem.setStyleClass("list-group-item list-group-item-action list-group-item-success");
                 } else if (statusItem.getStatus().equals("Rejected")) {
                     statusItem.setStyleClass("list-group-item list-group-item-action list-group-item-danger");
                 }
                 dbServices.getStatusItemService().addOrUpdate(statusItem);
             }
         catch (Exception ex)
         {
             System.err.println(ex.getMessage());
         }
    }
}
