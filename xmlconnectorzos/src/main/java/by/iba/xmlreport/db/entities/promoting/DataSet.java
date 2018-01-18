package by.iba.xmlreport.db.entities.promoting;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dataset")
public class DataSet {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column
    private String itemValue;
    @Column
    private String itemRemark;
    @OneToMany(mappedBy = "dataSet")
    private List<Member> members;



    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    public String getItemRemark() {
        return itemRemark;
    }

    public void setItemRemark(String itemRemark) {
        this.itemRemark = itemRemark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @Override
    public int hashCode() {
        int code = (int) ((itemValue.length()+itemRemark.length())*(Math.random()*121));
        for(Member member : members)
        {
            int membCode = member.getName().length();
            code+=membCode;
        }
        return code;
    }
}
