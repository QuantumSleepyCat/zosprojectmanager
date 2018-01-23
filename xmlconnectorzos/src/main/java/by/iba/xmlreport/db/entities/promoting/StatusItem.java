package by.iba.xmlreport.db.entities.promoting;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "status_item")
public class StatusItem implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @Column
    private String status;
    @Column(name = "style_class")
    private String styleClass;
    @Column
    private String comment;
    @Column
    private String logs;
    @ManyToOne
    @JoinColumn(name = "prom_info_id")
    private PageInfoModel pageInfoModel;

    public StatusItem() {
    }

    public StatusItem(String status, String styleClass, String comment, PageInfoModel pageInfoModel) {
        this.status = status;
        this.styleClass = styleClass;
        this.comment = comment;
        this.logs = "No logs";
        this.pageInfoModel = pageInfoModel;
    }

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

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getComment() {
        return comment;
    }

    public StatusItem setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public PageInfoModel getPageInfoModel() {
        return pageInfoModel;
    }

    public void setPageInfoModel(PageInfoModel pageInfoModel) {
        this.pageInfoModel = pageInfoModel;
    }

    @Override
    public int hashCode() {
        return status.hashCode()+styleClass.hashCode();
    }
}
