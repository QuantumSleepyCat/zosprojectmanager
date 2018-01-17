package by.iba.projmanmodels.model.statuslist.item;

public class StatusItem {
    private int id;
    private int idInList;
    private String appName;
    private String status;
    private String styleClass;
    private String initiator;
    private String comment;
    private String logs;
    
    
    public String getLogs() {
		return logs;
	}

	public void setLogs(String logs) {
		if(this.logs.equals("No logs"))
		{
		   this.logs="";	
		}
		this.logs += logs;
	}

	public StatusItem(int id, String appName, String status, String styleClass, String initiator, String comment) {
        this.id = id;
        this.appName = appName;
        this.status = status;
        this.styleClass = styleClass;
        this.initiator = initiator;
        this.comment = comment;
        this.logs="No logs";
    }

    public StatusItem(String appName, String status, String styleClass) {
        this.appName = appName;
        this.status = status;
        this.styleClass = styleClass;
    }

    public int getIdInList() {
        return idInList;
    }

    public StatusItem setIdInList(int idInList) {
        this.idInList = idInList;
        return this;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public StatusItem setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public StatusItem() {
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getStatus() {
        return status;
    }

    public StatusItem setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public StatusItem setStyleClass(String styleClass) {
        this.styleClass = styleClass;
        return this;
    }

    @Override
    public int hashCode() {
        return appName.hashCode()+status.hashCode()+styleClass.hashCode();
    }
}
