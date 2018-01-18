package by.iba.xmlreport.db.entities.promoting;

import by.iba.projmanmodels.model.DataSet;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "promote_item")
public class Item {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @OneToMany
    private List<DataSet> dataSets;

    public void setDataSet(DataSet dataSet)
    {
        dataSets.add(dataSet);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DataSet> getDataSets() {
        return dataSets;
    }

    public void setDataSets(List<DataSet> dataSets) {
        this.dataSets = dataSets;
    }

    @Override
    public int hashCode() {
        int code = (int) (name.length()+(Math.random()*23));
        for(DataSet dataSet : dataSets)
        {
            code+=dataSet.hashCode();
        }
        return code;
    }
}
