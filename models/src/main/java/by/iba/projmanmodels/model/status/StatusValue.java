package by.iba.projmanmodels.model.status;

public class StatusValue {
    private int idInfo;
    private int idInList;
    private String status;
    private String comment;

    public StatusValue(int idInfo, String status) {
        this.idInfo = idInfo;
        this.status = status;
        this.comment = "No comment";
    }

    public StatusValue() {
    }

    public int getIdInList() {
        return idInList;
    }

    public void setIdInList(int idInList) {
        this.idInList = idInList;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getIdInfo() {
        return idInfo;
    }

    public void setIdInfo(int idInfo) {
        this.idInfo = idInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        return idInfo*100/50+status.hashCode();
    }
}
