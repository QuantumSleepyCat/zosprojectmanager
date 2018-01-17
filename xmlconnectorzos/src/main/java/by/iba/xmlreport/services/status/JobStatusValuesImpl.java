package by.iba.xmlreport.services.status;


import by.iba.projmanmodels.model.status.StatusList;
import by.iba.projmanmodels.model.status.StatusValue;
import by.iba.projmanmodels.model.statuslist.StatusBarList;
import by.iba.projmanmodels.model.statuslist.item.StatusItem;
import org.springframework.stereotype.Service;

@Service
public class JobStatusValuesImpl implements JobStatusValues {
    @Override
    public void updateStatus() {
        for(StatusValue statusValue:
                StatusList.getInstance().getStatusValues().values())
        {
            try {
                StatusItem statusItem = StatusBarList.getInstance().getStatusItems().get(
                        statusValue.getIdInfo()
                );
                if(statusValue.getStatus().equals("Approved") &&
                		!statusItem.getStatus().equals("Finished") && !statusItem.getStatus().equals("In process") &&
                        !statusItem.getStatus().equals("Failed"))
                {
                    statusItem.setStyleClass("list-group-item list-group-item-action list-group-item-success")
                            .setStatus("Approved")
                            .setComment(statusValue.getComment());
                }
            else if(statusValue.getStatus().equals("Rejected") &&
            		!statusItem.getStatus().equals("Finished") && !statusItem.getStatus().equals("In process") &&
                    !statusItem.getStatus().equals("Failed"))
            {
                statusItem.setStyleClass("list-group-item list-group-item-action list-group-item-danger")
                        .setStatus("Rejected")
                        .setComment(statusValue.getComment());

            }
            }
            catch (Exception ex)
            {
                System.err.println(ex.getMessage());
            }
        }
    }

    @Override
    public void updateStatusById(int id) {
         StatusValue statusValue = StatusList.getInstance().getStatusValues().get(id);
         try {
             StatusItem statusItem = StatusBarList.getInstance().getStatusItems().get(
                     statusValue.getIdInfo()
             );
             if (statusValue.getStatus().equals("Approved") &&
                     !statusItem.getStatus().equals("Finished") && !statusItem.getStatus().equals("In process") &&
                     !statusItem.getStatus().equals("Failed")) {
                 statusItem.setStyleClass("list-group-item list-group-item-action list-group-item-success")
                         .setStatus("Approved")
                         .setComment(statusValue.getComment())
                         .setIdInList(statusValue.getIdInList());
                 System.out.println(statusValue.getComment());
             } else if (statusValue.getStatus().equals("Rejected") &&
            		 !statusItem.getStatus().equals("Finished") && !statusItem.getStatus().equals("In process") &&
                     !statusItem.getStatus().equals("Failed")) {
                 statusItem.setStyleClass("list-group-item list-group-item-action list-group-item-danger")
                         .setStatus("Rejected")
                         .setComment(statusValue.getComment());
             }
         }
         catch (Exception ex)
         {
             System.err.println(ex.getMessage());
         }
    }
}
