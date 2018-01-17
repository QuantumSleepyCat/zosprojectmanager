package by.iba.projmanmodels.model.result;

public class RejectResult {
    private int id;
    private String comment;

    public RejectResult() {
    }

    public RejectResult(int id, String comment) {
        this.id = id;
        this.comment = comment;
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

    public void setComment(String comment) {
        this.comment = comment;
    }
}
