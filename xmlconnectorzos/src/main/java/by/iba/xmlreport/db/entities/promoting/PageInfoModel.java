package by.iba.xmlreport.db.entities.promoting;






import by.iba.xmlreport.db.entities.User;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "promote_info")
public class PageInfoModel implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "application_name")
    private String applicationName;
    @Column
    private Date date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User requester;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "info_id",referencedColumnName = "id")
    private List<Item> items;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "send_info_id")
    private SendInfo sendInfo;

    public PageInfoModel()
    {
        items=new ArrayList<>();
        sendInfo=new SendInfo();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SendInfo getSendInfo() {
        return sendInfo;
    }

    public void setSendInfo(SendInfo sendInfo) {
        this.sendInfo = sendInfo;
    }

    public void setItem(Item item)
    {
        items.add(item);
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }


    public User getRequester() {
        return requester;
    }

    public void setRequester(User requester) {
        this.requester = requester;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public int hashCode() {
        int code = (int) ((applicationName.length()*requester.getLogin().length())*(Math.random()*123));
        for(Item item:items)
        {
            code+=item.hashCode()*(Math.random()*323+232);
        }
        return code+sendInfo.hashCode();
    }
}
