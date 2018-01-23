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
    private long id;
    @Column(name = "application_name")
    private String applicationName;
    @Column
    private Date date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User requester;
    @OneToMany(mappedBy = "pageInfoModel")
    private List<Item> items;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "send_info_id")
    private SendInfo sendInfo;

    public PageInfoModel()
    {
        items=new ArrayList<>();
        sendInfo=new SendInfo();
    }

    public long getId() {
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

    public int randomHash() {
        int code = (int) ((applicationName.length()*requester.getLogin().length())*(Math.random()*123));
        for(Item item:items)
        {
            code+=item.randomHash()*(Math.random()*323+232);
        }
        return code+sendInfo.randomHash();
    }
}
